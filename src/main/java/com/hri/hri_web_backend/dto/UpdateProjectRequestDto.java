package com.hri.hri_web_backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateProjectRequestDto {

	private String topic;

	private String detail;

	protected UpdateProjectRequestDto(){
	}

	@Builder
	public UpdateProjectRequestDto(String topic, String detail){
		this.topic = topic;
		this.detail = detail;
	}
}
