package com.hri.hri_web_backend.controller;

import com.hri.hri_web_backend.domain.Administrator;
import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/login")
    public SuccessResponse login(@RequestBody Administrator administrator){

        Administrator admin = adminService.findAdminByUsernameAndPassword(administrator);
        //
        //세션 생성
        //
        return SuccessResponse.builder()
            .status(StatusEnum.OK)
            .message("Admin 조회 성공")
            .build();
    }
}
