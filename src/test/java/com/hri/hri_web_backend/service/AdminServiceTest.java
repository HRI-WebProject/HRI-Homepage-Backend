package com.hri.hri_web_backend.service;

import com.hri.hri_web_backend.domain.Administrator;
import com.hri.hri_web_backend.repository.AdminRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class AdminServiceTest {
    @Autowired
    AdminService adminService;
    @Autowired
	AdminRepository adminRepository;

    // @Test
    // @DisplayName("관리자 저장 및 조회")
    // public void adminTest() throws Exception {
    //     //given
    //     Administrator administrator = new Administrator("root");
    //     Long savedId = adminService.join(administrator);
    //     //when
    //     Administrator adminById = adminService.findAdminById(savedId);
    //     Administrator adminByUP = adminService.findAdminByUsernameAndPassword(administrator);
    //     //then
    //     Assertions.assertThat(adminById).isEqualTo(administrator);
    //     Assertions.assertThat(adminByUP).isEqualTo(administrator);
    //
    // }

}