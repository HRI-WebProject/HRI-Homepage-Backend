package com.hri.hri_web_backend.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hri.hri_web_backend.domain.PublicationType;
import com.hri.hri_web_backend.dto.PublicationDto;
import com.hri.hri_web_backend.service.PublicationService;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class PublicationController {

	private final PublicationService ps;

	//ResponseBody
	//생성
	@ResponseBody
	@PostMapping(value = "/publications/new")
	public String create(@Valid @RequestBody PublicationDto publicationDto){ //SuccessResponse
		ps.savePublication(publicationDto);
		return "redirect:/publications";
	}

	//조회
	@ResponseBody
	@GetMapping(value = "/publications/{type}") //분리?
	public SuccessResponse getPublicationByType(@PathVariable PublicationType type){
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("Publication 생성 성공")
			.data(ps.findPublicationsByType(type))
			.build();
	}

	//수정
	@ResponseBody
	@PutMapping("/publications/{id}/edit")
	public String updatePublications(@Valid @RequestBody PublicationDto publicationDto, @PathVariable Long id){
		ps.updatePublication(publicationDto, id);
		return "redirect:/publications";
	}

	//삭제
	@ResponseBody
	@PostMapping("/publications/{id}/delete")
	public String deletePublications(@PathVariable Long id){
		ps.deletePublication(id);
		return "redirect:/publications";
	}
}
