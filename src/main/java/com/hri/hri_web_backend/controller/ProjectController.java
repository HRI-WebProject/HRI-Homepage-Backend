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

import com.hri.hri_web_backend.domain.Project;
import com.hri.hri_web_backend.dto.RegisterProjectDto;
import com.hri.hri_web_backend.dto.UpdateRequestDto;
import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.service.ProjectService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProjectController {

	private final ProjectService projectService;

	@ResponseBody
	@GetMapping("/projects")
	public SuccessResponse getProjects(){
		List<Project> projects = projectService.getProjects();
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.data(projects)
			.message("프로젝트 조회 성공")
			.build();
	}

	@ResponseBody
	@PostMapping("/admin/projects")
	public SuccessResponse registerProject(@Valid @RequestBody RegisterProjectDto dto){
		projectService.saveProject(dto);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("프로젝트 등록 성공")
			.build();
	}

	@ResponseBody
	@PutMapping("/admin/projects/{id}")
	public SuccessResponse updateProject(@Valid @RequestBody UpdateRequestDto dto, @PathVariable long id){
		projectService.changeProjectInfo(dto, id);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("프로젝트 수정 성공")
			.build();
	}

	@ResponseBody
	@DeleteMapping("/admin/projects/{id}")
	public SuccessResponse deleteProject(@PathVariable long id){
		projectService.deleteProjectInfo(id);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("프로젝트 삭제 성공")
			.build();
	}
}
