package com.hri.hri_web_backend.service;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.times;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hri.hri_web_backend.domain.Project;
import com.hri.hri_web_backend.dto.RegisterProjectDto;
import com.hri.hri_web_backend.fixture.ProjectFixture;
import com.hri.hri_web_backend.repository.ProjectRepository;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

	@InjectMocks
	ProjectService projectService;

	@Mock
	ProjectRepository projectRepository;

	@DisplayName("모든 프로젝트를 가져온다")
	@Test
	public void getProjects() throws Exception {
		//when
		List<Project> projects = projectService.getProjects();
		//then
		then(projectRepository).should(times(1)).findAll();
	}

	@DisplayName("프로젝트를 등록한다")
	@Test
	public void registerProject() throws Exception {
		//given
		final RegisterProjectDto projectDto = RegisterProjectDto.builder()
			.detail(ProjectFixture.Project1.DETAIL)
			.topic(ProjectFixture.Project1.TOPIC)
			.build();
		//when
		projectService.saveProject(projectDto);
		//then
		then(projectRepository).should(times(1)).save(any());
	}

	@DisplayName("프로젝트 정보를 삭제한다")
	@Test
	public void deleteProjectInfo() throws Exception {
		//when
		projectService.deleteProjectInfo(ProjectFixture.Project1.ID);

		//then
		then(projectRepository).should(times(1)).deleteById(any());
	}
}
