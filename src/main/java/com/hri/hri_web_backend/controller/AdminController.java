package com.hri.hri_web_backend.controller;

import com.hri.hri_web_backend.domain.Administrator;
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
    public Administrator login(@RequestBody Administrator administrator){
        return adminService.findAdminByUsernameAndPassword(administrator.getUsername(), administrator.getPassword());
    }

}
