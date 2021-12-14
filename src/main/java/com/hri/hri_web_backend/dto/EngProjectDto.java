package com.hri.hri_web_backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class EngProjectDto {

	private String engTopic;

	private String engSubTopic;

	private String engDetail1;
	private String engDetail2;
	private String engDetail3;
	private String engDetail4;
	private String engDetail5;

	private String photo;

	protected EngProjectDto(){}

	@Builder
	public EngProjectDto(String engTopic, String engSubTopic, String engDetail1, String engDetail2, String engDetail3, String engDetail4, String engDetail5, String photo){
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
