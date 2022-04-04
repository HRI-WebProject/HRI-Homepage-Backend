package com.hri.hri_web_backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContactDto {
	private String professorName;
	private String professorEmail;
	private String professorPhone;

	private String labManagerName;
	private String labManagerEmail;
	private String labManagerPhone;

	private String officeLocation;
	private String officePhone;
}
