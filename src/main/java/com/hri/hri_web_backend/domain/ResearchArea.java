package com.hri.hri_web_backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ResearchArea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "research_area_id")
	private Long id;

	@Column(nullable = false)
	private String name;
	private String engName;

	private String photo;

	private String detail;
	private String engDetail;

	protected ResearchArea(){}

	@Builder
	public ResearchArea(String name, String engName, String photo, String detail, String engDetail){
		this.name= name;
		this.engName = engName;
		this.photo = photo;
		this.detail = detail;
		this.engDetail = engDetail;
	}

}
