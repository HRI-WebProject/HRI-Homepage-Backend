package com.hri.hri_web_backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateProjectRequestDto {

	private String topic;
	private String subTopic;
	private String detail1;
	private String detail2;
	private String detail3;
	private String detail4;
	private String detail5;

	//영문
	private String engTopic;
	private String engSubTopic;
	private String engDetail1;
	private String engDetail2;
	private String engDetail3;
	private String engDetail4;
	private String engDetail5;

	private String photo;

	protected UpdateProjectRequestDto(){
	}

	@Builder
	public UpdateProjectRequestDto(String topic, String subTopic, String detail1, String detail2, String detail3, String detail4, String detail5,
		String engTopic, String engSubTopic, String engDetail1, String engDetail2, String engDetail3, String engDetail4, String engDetail5, String photo){
		this.topic = topic;
		this.subTopic = subTopic;
		this.detail1 = detail1;
		this.detail2 = detail2;
		this.detail3 = detail3;
		this.detail4 = detail4;
		this.detail5 = detail5;
		this.engTopic = engTopic;
		this.engSubTopic = engSubTopic;
		this.engDetail1 = engDetail1;
		this.engDetail2 = engDetail2;
		this.engDetail3 = engDetail3;
		this.engDetail4 = engDetail4;
		this.engDetail5 = engDetail5;
		this.photo = photo;
	}
}
