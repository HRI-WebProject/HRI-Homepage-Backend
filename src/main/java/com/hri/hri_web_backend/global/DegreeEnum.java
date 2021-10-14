package com.hri.hri_web_backend.global;

public enum DegreeEnum {

	PROFESSOR("교수님"),
	POSTDOCTORAL("박사후"),
	PHD("박사"),
	MASTER("석사"),
	BACHELOR("학사"),
	UNDERGRADUATE("학부생");

	private String degree;

	DegreeEnum(String degree){
		this.degree = degree;
	}
}
