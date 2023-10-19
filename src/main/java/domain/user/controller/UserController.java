package domain.user.controller;

import com.example.hellodomitory.global.util.MsgResponseDto;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    public ResponseEntity<MsgResponseDto> login(@RequestBody LoginRequest loginRequestDto, HttpServletResponse response) {
        return ResponseEntity.ok(new MsgResponseDto("로그인 완료!", HttpStatus.OK.value()));
    }
}
