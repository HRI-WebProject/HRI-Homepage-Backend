package com.hri.hri_web_backend.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateRequestDto {

	private String topic;

	private String detail;

	protected UpdateRequestDto(){
	}

	@Builder
	public UpdateRequestDto(String topic, String detail){
		this.topic = topic;
		this.detail = detail;
	}
}
