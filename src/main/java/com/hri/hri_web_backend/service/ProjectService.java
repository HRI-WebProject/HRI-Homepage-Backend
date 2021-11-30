package com.hri.hri_web_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hri.hri_web_backend.domain.Project;
import com.hri.hri_web_backend.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {

	private final ProjectRepository projectRepository;

	public List<Project> getProjects(){
		return projectRepository.findAll();
	}
}