package com.hri.hri_web_backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long id;

	private String topic;

	private String detail;

	protected Project(){
	}

	@Builder
	public Project(Long id, String topic, String detail){
		this.id = id;
		this.topic = topic;
		this.detail = detail;
	}
}