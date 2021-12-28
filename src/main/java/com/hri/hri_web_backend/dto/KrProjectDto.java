package com.hri.hri_web_backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class KrProjectDto {
	private String topic;

	private String subTopic;

	private String detail1;
	private String detail2;
	private String detail3;
	private String detail4;
	private String detail5;

	private String photo;

	protected KrProjectDto(){}

	@Builder
	public KrProjectDto(String topic, String subTopic, String detail1, String detail2, String detail3, String detail4, String detail5, String photo){
		this.topic = topic;
		this.subTopic = subTopic;
		this.detail1 = detail1;
		this.detail2 = detail2;
		this.detail3 = detail3;
		this.detail4 = detail4;
		this.detail5 = detail5;
		this.photo = photo;
	}
}
