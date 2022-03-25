package com.hri.hri_web_backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hri.hri_web_backend.domain.ResearchArea;
import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.service.ResearchAreaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ResearchAreaController {
	private final ResearchAreaService researchAreaService;

	@GetMapping("/api/researchArea")
	public SuccessResponse getResearchAreas(){
		List<ResearchArea> areas = researchAreaService.getResearchAreas();
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("연구분야 조회 성공")
			.data(areas)
			.build();
	}

	@PostMapping("/api/admin/researchArea")
	public SuccessResponse registerResearchArea(@Valid @RequestBody ResearchArea researchArea){
		researchAreaService.saveResearchArea(researchArea);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("연구분야 등록 성공")
			.build();
	}

	@PutMapping("/api/admin/researchArea/{id}")
	public SuccessResponse updateResearchArea(@Valid @RequestBody ResearchArea researchArea, @PathVariable Long id){
		researchAreaService.updateResearchArea(researchArea,id);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("연구분야 수정 성공")
			.build();
	}

	@DeleteMapping("/api/admin/researchArea/{id}")
	public SuccessResponse deleteResearchArea(@PathVariable Long id){
		researchAreaService.deleteResearchArea(id);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("연구분야 삭제 성공")
			.build();
	}
}
