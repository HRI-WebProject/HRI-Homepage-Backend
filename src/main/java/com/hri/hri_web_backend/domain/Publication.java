package com.hri.hri_web_backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Publication {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pubilcation_id")
	private Long id;
	@Column(nullable = false)
	String topic;
	String link;
	String detail;

	@Enumerated(EnumType.STRING)
	private PublicationType publicationType;

	protected Publication(){
	}

	@Builder
	public Publication(String topic, String link, String detail, PublicationType publicationType){
		this.topic = topic;
		this.link = link;
		this.detail = detail;
		this.publicationType = publicationType;
	}
}
