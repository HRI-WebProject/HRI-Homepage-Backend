package com.hri.hri_web_backend.dto;

import javax.persistence.Column;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterProjectDto {

	private String topic;

	@Column(length = 500)
	private String detail;

	protected RegisterProjectDto(){
	}

	@Builder
	public RegisterProjectDto(String topic, String detail){
		this.topic = topic;
		this.detail = detail;
	}
}