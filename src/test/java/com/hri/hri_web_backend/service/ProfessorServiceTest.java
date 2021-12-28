package com.hri.hri_web_backend.service;

import com.hri.hri_web_backend.domain.Professor;
import com.hri.hri_web_backend.dto.ProfessorDto;
import com.hri.hri_web_backend.fixture.ProfessorFixture;
import com.hri.hri_web_backend.repository.ProfessorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ProfessorServiceTest {

    @InjectMocks
    ProfessorService professorService;

    @Mock
    ProfessorRepository professorRepository;

    @DisplayName("교수 소개를 가져온다")
    @Test
    public void getProfessors() throws Exception {
        //when
        List<Professor> professors = professorService.getProfessor();
        //then
        then(professorRepository).should(times(1)).findAll();
    }

    @DisplayName("교수 소개를 등록한다")
    @Test
    public void registerProfessor() throws Exception {
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
        //when
        professorService.registerProfessor(professorDto);
        //then
        then(professorRepository).should(times(1)).save(any());
    }

    @DisplayName("교수 소개를 삭제한다")
    @Test
    public void deleteProfessor() throws Exception {
        //when
        professorService.deleteProfessor(ProfessorFixture.Professor1.ID);

        //then
        then(professorRepository).should(times(1)).deleteById(any());
    }
}
