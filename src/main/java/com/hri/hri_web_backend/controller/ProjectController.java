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
import org.springframework.web.bind.annotation.ResponseBody;

import com.hri.hri_web_backend.dto.UpdateProjectRequestDto;
import com.hri.hri_web_backend.dto.EngProjectDto;
import com.hri.hri_web_backend.dto.KrProjectDto;
import com.hri.hri_web_backend.dto.ProjectDto;
import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.service.ProjectService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProjectController {

	private final ProjectService projectService;

	@ResponseBody
	@GetMapping("/api/projects")
	public SuccessResponse getProjects(){
		List<KrProjectDto> projects = projectService.getProjects();
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.data(projects)
			.message("프로젝트 조회 성공")
			.build();
	}

	@ResponseBody
	@GetMapping("/api/en/projects")
	public SuccessResponse getEngProjects(){
		List<EngProjectDto> projects = projectService.getEngProjects();
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.data(projects)
			.message("프로젝트 조회 성공")
			.build();
	}

	@ResponseBody
	@PostMapping("/api/admin/projects")
	public SuccessResponse registerProject(@Valid @RequestBody ProjectDto dto){
		projectService.saveProject(dto);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("프로젝트 등록 성공")
			.build();
	}

	@ResponseBody
	@PutMapping("/api/admin/projects/{id}")
	public SuccessResponse updateProject(@Valid @RequestBody UpdateProjectRequestDto dto, @PathVariable long id){
		projectService.changeProjectInfo(dto, id);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("프로젝트 수정 성공")
			.build();
	}

	@ResponseBody
	@DeleteMapping("/api/admin/projects/{id}")
	public SuccessResponse deleteProject(@PathVariable long id){
		projectService.deleteProjectInfo(id);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("프로젝트 삭제 성공")
			.build();
	}
}
