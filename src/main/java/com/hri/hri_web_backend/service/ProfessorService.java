package com.hri.hri_web_backend.service;

import com.hri.hri_web_backend.domain.Professor;
import com.hri.hri_web_backend.dto.ProfessorDto;
import com.hri.hri_web_backend.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Professor> getProfessor(){
        return professorRepository.findAll();
    }

    public void registerProfessor(ProfessorDto professorDto){
        Professor professor = Professor.builder()
                .name(professorDto.getName())
                .engName(professorDto.getEngName())
                .photo(professorDto.getPhoto())
                .boldDetail(professorDto.getBoldDetail())
                .detail(professorDto.getDetail())
                .email(professorDto.getEmail())
                .build();
        professorRepository.save(professor);
    }

    public void changeProfessorInfo(ProfessorDto professorDto, long id){
        Optional<Professor> updateProfessor = professorRepository.findById(id);
        if(updateProfessor.isEmpty())
            throw new NullPointerException();

        updateProfessor.ifPresent(selectProfessor->{
            selectProfessor.setName(professorDto.getName());
            selectProfessor.setEngName(professorDto.getEngName());
            selectProfessor.setDetail(professorDto.getDetail());
            selectProfessor.setEmail(professorDto.getEmail());
            selectProfessor.setBoldDetail(professorDto.getBoldDetail());
            selectProfessor.setPhoto(professorDto.getPhoto());
        });
    }

    public void deleteProfessor(Long id){
        professorRepository.deleteById(id);
    }
}
