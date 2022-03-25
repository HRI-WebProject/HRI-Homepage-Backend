package com.hri.hri_web_backend.controller;

import com.hri.hri_web_backend.domain.Professor;
import com.hri.hri_web_backend.dto.ProfessorDto;
import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @ResponseBody
    @GetMapping("/api/professors")
    public SuccessResponse getProfessor(){
        List<Professor> professor = professorService.getProfessor();
        return SuccessResponse.builder()
                .status(StatusEnum.OK)
                .message("교수 소개 조회 성공")
                .data(professor)
                .build();
    }

    @ResponseBody
    @PostMapping("/api/admin/professors")
    public SuccessResponse registerProfessor(@Valid @RequestBody ProfessorDto professorDto){
        professorService.registerProfessor(professorDto);
        return SuccessResponse.builder()
                .status(StatusEnum.OK)
                .message("교수 소개 등록 성공")
                .build();
    }

    @ResponseBody
    @PutMapping("/api/admin/professors/{id}")
    public SuccessResponse updateProfessor(@Valid @RequestBody ProfessorDto professorDto, @PathVariable Long id){
        professorService.changeProfessorInfo(professorDto, id);
        return SuccessResponse.builder()
                .status(StatusEnum.OK)
                .message("교수 소개 수정 성공")
                .build();
    }

    @ResponseBody
    @DeleteMapping("/api/admin/professors/{id}")
    public SuccessResponse deleteProfessor(@PathVariable Long id){
        professorService.deleteProfessor(id);
        return SuccessResponse.builder()
                .status(StatusEnum.OK)
                .message("교수 소개 삭제 성공")
                .build();
    }
}
