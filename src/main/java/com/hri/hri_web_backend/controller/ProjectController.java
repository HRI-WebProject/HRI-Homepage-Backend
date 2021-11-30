package com.hri.hri_web_backend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hri.hri_web_backend.domain.Project;
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
}
