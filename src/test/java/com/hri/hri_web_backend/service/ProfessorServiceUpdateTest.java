package com.hri.hri_web_backend.service;

import com.hri.hri_web_backend.domain.Professor;
import com.hri.hri_web_backend.dto.ProfessorDto;
import com.hri.hri_web_backend.fixture.ProfessorFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProfessorServiceUpdateTest {

    @Autowired
    ProfessorService professorService;

    @Test
    public void 교수업데이트() throws Exception {

        //given
        final Professor professor = ProfessorFixture.Professor1.PROFESSOR;
        final ProfessorDto professorDto = ProfessorDto.builder()
                .name(professor.getName())
                .engName(professor.getEngName())
                .email(professor.getEmail())
                .photo(professor.getPhoto())
                .boldDetail(professor.getBoldDetail())
                .detail(professor.getDetail())
                .build();
        professorService.registerProfessor(professorDto);

        //when
        final ProfessorDto changedProfessorDto = ProfessorDto.builder()
                .name("ChangedName")
                .email(professor.getEmail())
                .engName(professor.getEngName())
                .photo(professor.getPhoto())
                .detail(professor.getDetail())
                .boldDetail(professor.getBoldDetail())
                .build();

        professorService.changeProfessorInfo(changedProfessorDto, 1L);

        //then
        String changedName = professorService.getProfessor().get(0).getName();
        Assertions.assertThat(changedName).isEqualTo("ChangedName");

    }
}
