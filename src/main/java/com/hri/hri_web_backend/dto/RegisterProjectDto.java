package com.hri.hri_web_backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterProjectDto {

	private String topic;

	private String detail;

	protected RegisterProjectDto(){
	}

	@Builder
	public RegisterProjectDto(String topic, String detail){
		this.topic = topic;
		this.detail = detail;
	}
}