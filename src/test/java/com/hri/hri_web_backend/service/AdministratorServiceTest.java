package com.hri.hri_web_backend.service;

import com.hri.hri_web_backend.domain.Administrator;
import com.hri.hri_web_backend.repository.AdministratorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
class AdministratorServiceTest {
    @Autowired AdministratorService administratorService;
    @Autowired AdministratorRepository administratorRepository;

    @Test
    @DisplayName("관리자 저장 및 조회")
    public void adminTest() throws Exception {
        //given
        Administrator administrator = new Administrator("root", "pass");
        Long savedId = administratorService.join(administrator);
        //when
        Administrator adminById = administratorService.findAdminById(savedId);
        Administrator adminByUP = administratorService.findAdminByUsernameAndPassword(administrator.getUsername(), administrator.getPassword());
        //then
        Assertions.assertThat(adminById).isEqualTo(administrator);
        Assertions.assertThat(adminByUP).isEqualTo(administrator);

    }

}