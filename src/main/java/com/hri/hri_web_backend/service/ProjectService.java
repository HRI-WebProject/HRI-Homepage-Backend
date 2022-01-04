package com.hri.hri_web_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hri.hri_web_backend.dto.UpdateProjectRequestDto;
import com.hri.hri_web_backend.dto.EngProjectDto;
import com.hri.hri_web_backend.dto.KrProjectDto;
import com.hri.hri_web_backend.domain.Project;
import com.hri.hri_web_backend.dto.ProjectDto;
import com.hri.hri_web_backend.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {

	private final ProjectRepository projectRepository;

	public List<KrProjectDto> getProjects(){
		List<Project> projects = projectRepository.findAll();
		return projects.stream().map(project -> new KrProjectDto(project.getTopic(), project.getSubTopic(),
			project.getDetail1(), project.getDetail2(), project.getDetail3(), project.getDetail4(), project.getDetail5(),
			project.getPhoto())).collect(Collectors.toList());
	}

	public List<EngProjectDto> getEngProjects() {
		List<Project> projects = projectRepository.findAll();
		return projects.stream().map(project -> new EngProjectDto(project.getEngTopic(), project.getEngSubTopic(),
			project.getEngDetail1(), project.getEngDetail2(), project.getEngDetail3(), project.getEngDetail4(),
			project.getEngDetail5(), project.getPhoto())).collect(Collectors.toList());
	}

	public void saveProject(ProjectDto dto){
		Project project = Project.builder()
			.topic(dto.getTopic())
			.subTopic(dto.getSubTopic())
			.detail1(dto.getDetail1())
			.detail2(dto.getDetail2())
			.detail3(dto.getDetail3())
			.detail4(dto.getDetail4())
			.detail5(dto.getDetail5())
			.engTopic(dto.getEngTopic())
			.engSubTopic(dto.getEngSubTopic())
			.engDetail1(dto.getEngDetail1())
			.engDetail2(dto.getEngDetail2())
			.engDetail3(dto.getEngDetail3())
			.engDetail4(dto.getEngDetail4())
			.engDetail5(dto.getEngDetail5())
			.photo(dto.getPhoto())
			.build();

		projectRepository.save(project);
	}

	public void changeProjectInfo(UpdateProjectRequestDto dto, long id){
		Optional<Project> updateProject = projectRepository.findById(id);
		if(updateProject.isEmpty())
			throw new NullPointerException();

		updateProject.ifPresent(selectProject->{
			selectProject.setTopic(dto.getTopic());
			selectProject.setSubTopic(dto.getSubTopic());
			selectProject.setDetail1(dto.getDetail1());
			selectProject.setDetail2(dto.getDetail2());
			selectProject.setDetail3(dto.getDetail3());
			selectProject.setDetail4(dto.getDetail4());
			selectProject.setDetail5(dto.getDetail5());
			selectProject.setEngTopic(dto.getEngTopic());
			selectProject.setEngSubTopic(dto.getEngSubTopic());
			selectProject.setEngDetail1(dto.getEngDetail1());
			selectProject.setEngDetail2(dto.getEngDetail2());
			selectProject.setEngDetail3(dto.getEngDetail3());
			selectProject.setEngDetail4(dto.getEngDetail4());
			selectProject.setEngDetail5(dto.getEngDetail5());
			selectProject.setPhoto(dto.getPhoto());
		});

	}

	public void deleteProjectInfo(long id){
		projectRepository.deleteById(id);
	}

}