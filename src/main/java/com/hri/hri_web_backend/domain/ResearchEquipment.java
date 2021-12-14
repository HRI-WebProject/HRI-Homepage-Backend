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
public class ResearchEquipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "researchArea_id")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(name = "eng_name")
	private String engName;

	private String photo;

	protected ResearchEquipment(){}

	@Builder
	public ResearchEquipment(String name, String engName, String photo){
		this.name= name;
		this.engName = engName;
		this.photo = photo;
	}
}
