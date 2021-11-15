package com.hri.hri_web_backend.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hri.hri_web_backend.domain.Administrator;
import com.hri.hri_web_backend.domain.Salt;
import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.service.security.AuthService;
import com.hri.hri_web_backend.service.security.util.CookieUtil;
import com.hri.hri_web_backend.service.security.util.JwtUtil;
import com.hri.hri_web_backend.service.security.util.RedisUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AdminController {
    // private final AdminService adminService;
    private final AuthService authService;
    private final JwtUtil jwtUtil;
    private final CookieUtil cookieUtil;
    private final RedisUtil redisUtil;

    @PostConstruct //배포시 삭제 , 테스트 코드 때문에 잠시 주석처리
    public void init() {
        Administrator administrator = new Administrator("root","pass");
        signUpUser(administrator);
    }

    @PostMapping("/admin/signup")
    public SuccessResponse signUpUser(@RequestBody Administrator administrator) {
        try {
            authService.signUpAdministrator(administrator);
            return SuccessResponse.builder()
                .status(StatusEnum.OK)
                .message("회원가입을 성공적으로 완료했습니다.")
                .build();
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/login")
    public SuccessResponse login(@RequestBody Administrator administrator, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            //spring security - AuthService:loginAdministrator -> admin 객체 생성
            final Administrator admin = authService.loginAdministrator(administrator.getUsername(), administrator.getPassword());
            //Access, refresh 토큰 생성하여 쿠키 만듬
            final String token = jwtUtil.generateToken(admin);
            final String refreshJwt = jwtUtil.generateRefreshToken(admin);
            Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
            Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);
            //토큰 만료일자 설정
            redisUtil.setDataExpire(refreshJwt, admin.getUsername(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
            //HttpServletResponse에 쿠키 추가
            response.addCookie(accessToken);
            response.addCookie(refreshToken);
            //성공 메시지 반환
            return SuccessResponse.builder()
                .status(StatusEnum.OK)
                .message("로그인에 성공하였습니다.")
                .build();
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        }

    }
}
