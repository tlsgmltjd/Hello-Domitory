package com.example.hellodomitory.global.Jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Slf4j(topic = "JwtUtil")
@Component
public class JwtUtil {

    /* 1. JWT 데이터 준비하기 */
    public static final String AUTHORIZATION_HEADER = "Authorization";      // Header KEY 값
    public static final String AUTHORIZATION_KEY = "auth";      // 사용자 권한 값의 KEY
    public static final String BEARER_PREFIX = "Bearer ";       // Token 식별자
    private static final long TOKEN_TIME = 24 * 60 * 60 * 1000L * 24;

    @Value("${jwt.secret.key}") // Base64 Encode 한 SecretKey (application.yml 에 추가해둔 값)
    private String secretKey;       // 그 값을 가져와서 secretKey 변수에 넣는다
    private static Key key;        // Secret key 를 담을 변수
    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;     // 사용할 알고리즘 선택

    @PostConstruct      // 한 번만 받으면 값을 사용할 때마다, 매번 요청을 새로 호출하는 것을 방지
    public void init() {
        byte[] bytes = Base64.getDecoder().decode(secretKey);
        key = Keys.hmacShaKeyFor(bytes);
    }

    /* 2. JWT 토큰 생성 */
    // 인증된 토큰을 기반으로 JWT 토큰을 발급
    public static String createToken(String username) {
        Date date = new Date();

        // 암호화
        return BEARER_PREFIX + Jwts.builder()
                        .setSubject(username)
                        .setExpiration(new Date(date.getTime() + TOKEN_TIME))
                        .setIssuedAt(date)
                        .signWith(key, signatureAlgorithm)
                        .compact();
    }

    // 3. header 에서 JWT 가져오기
    public String getJwtFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
            return bearerToken.substring(7);
        }
        return null;
    }

    /* 4. JWT 토큰 검증 */
    // 토큰의 만료, 위/변조 를 검증
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            log.error("Invalid JWT signature, 유효하지 않는 JWT 서명 입니다.");
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token, 만료된 JWT token 입니다.");
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token, 지원되지 않는 JWT 토큰 입니다.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("JWT claims is empty, 잘못된 JWT 토큰 입니다.");
        } catch (Exception e) {
            log.error("=========== 토큰 검증 중 예외가 발생 했습니다. ===========");
        }
        return false;
    }

}