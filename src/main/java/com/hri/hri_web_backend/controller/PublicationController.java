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

import com.hri.hri_web_backend.domain.Publication;
import com.hri.hri_web_backend.domain.PublicationType;
import com.hri.hri_web_backend.dto.PublicationDto;
import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.service.PublicationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PublicationController {

	private final PublicationService publicationService;

	//ResponseBody
	//조회
	@GetMapping(value = "/publications/{type}")
	public SuccessResponse getPublicationByType(@PathVariable PublicationType type){
		List<Publication> publications = publicationService.findPublicationsByType(type);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("Publication 조회 성공")
			.data(publications)
			.build();
	}

	//생성
	@PostMapping(value = "/publications/new")
	public SuccessResponse create(@Valid @RequestBody PublicationDto publicationDto){ //SuccessResponse
		publicationService.savePublication(publicationDto);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("Publication 생성 성공")
			.build();
	}

	//수정
	@PutMapping("/publications/{id}/edit")
	public SuccessResponse updatePublications(@Valid @RequestBody PublicationDto publicationDto, @PathVariable Long id){
		publicationService.updatePublication(publicationDto, id);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("Publication 수정 성공")
			.build();
	}

	//삭제
	@DeleteMapping("/publications/{id}/delete")
	public SuccessResponse deletePublications(@PathVariable Long id){
		publicationService.deletePublication(id);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("Publication 삭제 성공")
			.build();
	}
}
