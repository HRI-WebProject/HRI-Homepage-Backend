package com.hri.hri_web_backend.controller;

import com.hri.hri_web_backend.domain.Administrator;
import com.hri.hri_web_backend.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdministratorController {
    private final AdministratorService administratorService;

//    @PostConstruct //배포시 삭제 , 테스트 코드 때문에 잠시 주석처리
//    public void init() {
//        Administrator administrator = new Administrator("root", "pass");
//        administratorService.join(administrator);
//    }

    @PostMapping("/login")
    public Administrator Login(@RequestBody Administrator administrator){
        return administratorService.findAdminByUsernameAndPassword(administrator.getUsername(), administrator.getPassword());
    }

}
