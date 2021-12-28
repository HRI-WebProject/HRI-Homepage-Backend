package com.hri.hri_web_backend.fixture;

import com.hri.hri_web_backend.domain.Project;

public class ProjectFixture {

	public static class Project1 {
		public static final Long ID = 1L;
		public static final String DETAIL = "project1_detail";
		public static final String TOPIC = "project1_topic";

		public static final Project PROJECT = Project.builder()
			.detail1(DETAIL)
			.topic(TOPIC)
			.build();
	}
}
