-- 곽민성
INSERT INTO users (name, grade, gender, timeout) VALUES ('곽민성', 1, 'MALE', 0);

-- 권태연
INSERT INTO users (name, grade, gender, timeout) VALUES ('권태연', 1, 'FEMALE', 0);

-- 김겸비
INSERT INTO users (name, grade, gender, timeout) VALUES ('김겸비', 1, 'MALE', 0);

-- 김유준
INSERT INTO users (name, grade, gender, timeout) VALUES ('김유준', 1, 'MALE', 0);

-- 김재균
INSERT INTO users (name, grade, gender, timeout) VALUES ('김재균', 1, 'MALE', 0);

-- 김주은
INSERT INTO users (name, grade, gender, timeout) VALUES ('김주은', 1, 'MALE', 0);

-- 문혜성
INSERT INTO users (name, grade, gender, timeout) VALUES ('문혜성', 1, 'MALE', 0);

-- 박유현
INSERT INTO users (name, grade, gender, timeout) VALUES ('박유현', 1, 'MALE', 0);

-- 박진우
INSERT INTO users (name, grade, gender, timeout) VALUES ('박진우', 1, 'MALE', 0);

-- 방가온
INSERT INTO users (name, grade, gender, timeout) VALUES ('방가온', 1, 'MALE', 0);

-- 손찬형
INSERT INTO users (name, grade, gender, timeout) VALUES ('손찬형', 1, 'MALE', 0);

-- 신희성
INSERT INTO users (name, grade, gender, timeout) VALUES ('신희성', 1, 'MALE', 0);

-- 엄지성
INSERT INTO users (name, grade, gender, timeout) VALUES ('엄지성', 1, 'MALE', 0);

-- 이승화
INSERT INTO users (name, grade, gender, timeout) VALUES ('이승화', 1, 'FEMALE', 0);

-- 이예나
INSERT INTO users (name, grade, gender, timeout) VALUES ('이예나', 1, 'FEMALE', 0);

-- 이진헌
INSERT INTO users (name, grade, gender, timeout) VALUES ('이진헌', 1, 'MALE', 0);

-- 전민혁
INSERT INTO users (name, grade, gender, timeout) VALUES ('전민혁', 1, 'MALE', 0);

-- 정성찬
INSERT INTO users (name, grade, gender, timeout) VALUES ('정성찬', 1, 'MALE', 0);

---

-- 김민영 ⭐️
INSERT INTO users (id, name, grade, gender, timeout) VALUES (1004, '김민영', 4, 'FEMALE', 0);

-- 김은영 ⭐️
INSERT INTO users (id, name, grade, gender, timeout) VALUES (777, '임은영', 4, 'FEMALE', 0);

---

INSERT INTO access_log (enter, late, user_id, log_time) VALUES
                                                            (FALSE, FALSE, 1, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 2, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 3, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 4, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 5, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 6, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 7, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 8, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 9, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 10, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 11, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 12, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 13, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 14, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 15, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 16, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 17, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 18, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 1004, (current_timestamp AT TIME ZONE 'Asia/Seoul')),
                                                            (FALSE, FALSE, 777, (current_timestamp AT TIME ZONE 'Asia/Seoul'));