package com.hri.hri_web_backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberByDegreeDto {

	private String name;
	private String engName;
	private String email;
	private String photo;
	private Boolean graduate;
	private String researchArea;

	protected MemberByDegreeDto(){}

	@Builder
	public MemberByDegreeDto(String name, String engName, String email, String photo, Boolean graduate, String researchArea) {
		this.name = name;
		this.engName = engName;
		this.email = email;
		this.photo = photo;
		this.graduate = graduate;
		this.researchArea = researchArea;
	}
}