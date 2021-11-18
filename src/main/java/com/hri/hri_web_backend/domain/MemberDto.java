package com.hri.hri_web_backend.domain;

import com.hri.hri_web_backend.global.DegreeEnum;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberDto {

	private String name;
	private String engName;
	private String email;
	private String photo;
	private DegreeEnum degree;
	private Boolean graduate;

	@Builder
	public MemberDto(String name, String engName, String email, String photo, DegreeEnum degree, Boolean graduate) {
		this.name = name;
		this.engName = engName;
		this.email = email;
		this.photo = photo;
		this.degree = degree;
		this.graduate = graduate;
	}
}