package com.hri.hri_web_backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hri.hri_web_backend.domain.ResearchEquipment;
import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.service.ResearchEquipmentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ResearchEquipmentController {
	private final ResearchEquipmentService researchEquipmentService;

	@GetMapping("/researchEquipment")
	public SuccessResponse getResearchEquipments(){
		List<ResearchEquipment> Equipments = researchEquipmentService.getResearchEquipments();
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("연구장비 조회 성공")
			.data(Equipments)
			.build();
	}

	@PostMapping("/admin/researchEquipment")
	public SuccessResponse registerResearchEquipment(@Valid @RequestBody ResearchEquipment researchEquipment){
		researchEquipmentService.saveResearchEquipment(researchEquipment);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("연구장비 등록 성공")
			.build();
	}

	@PutMapping("/admin/researchEquipment/{id}")
	public SuccessResponse updateResearchEquipment(@Valid @RequestBody ResearchEquipment researchEquipment, @PathVariable Long id){
		researchEquipmentService.updateResearchEquipment(researchEquipment,id);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("연구장비 수정 성공")
			.build();
	}

	@DeleteMapping("/admin/researchEquipment/{id}")
	public SuccessResponse deleteResearchEquipment(@PathVariable Long id){
		researchEquipmentService.deleteResearchEquipment(id);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("연구장비 삭제 성공")
			.build();
	}
}
