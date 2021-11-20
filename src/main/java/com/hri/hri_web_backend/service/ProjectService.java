package com.hri.hri_web_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hri.hri_web_backend.dto.RegisterProjectDto;
import com.hri.hri_web_backend.dto.UpdateRequestDto;
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

	public void saveProject(RegisterProjectDto dto){
		Project project = Project.builder()
			.topic(dto.getTopic())
			.detail(dto.getDetail())
			.build();
		projectRepository.save(project);
	}

	public void changeProjectInfo(UpdateRequestDto dto, long id){
		Optional<Project> updateProject = projectRepository.findById(id);
		if(updateProject.isEmpty())
			throw new NullPointerException();

		updateProject.ifPresent(selectProject->{
			selectProject.setTopic(dto.getTopic());
			selectProject.setDetail(dto.getDetail());
		});
	}

	public void deleteProjectInfo(long id){
		projectRepository.deleteById(id);
	}
}