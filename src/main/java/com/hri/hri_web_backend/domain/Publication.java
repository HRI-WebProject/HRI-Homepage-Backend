package com.hri.hri_web_backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Publication {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pubilcation_id")
	private Long id;

	String topic;
	String link;
	String detail;

	@Enumerated
	private PublicationType publication_type;

	protected Publication(){
	}

	@Builder
	public Publication(Long id, String topic, String link, String detail, PublicationType publication_type){
		this.id = id;
		this.topic = topic;
		this.link = link;
		this.detail = detail;
		this.publication_type = publication_type;
	}
}
