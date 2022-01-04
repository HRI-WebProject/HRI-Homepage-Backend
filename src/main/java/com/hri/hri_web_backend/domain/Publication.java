package com.hri.hri_web_backend.domain;

import java.time.LocalDateTime;

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

	String inventor;

	@Column(name = "filling_no")
	String fillingNo;
	@Column(name = "filling_date")
	LocalDateTime fillingDate;
	@Column(name = "granted_no")
	String grantedNo;
	@Column(name = "granted_date")
	LocalDateTime grantedDate;

	String progress;

	String link;
	String detail;

	@Enumerated(EnumType.STRING)
	private PublicationType publicationType;

	protected Publication(){
	}

	@Builder
	public Publication(String topic, String link, String detail, PublicationType publicationType, String inventor, String fillingNo, LocalDateTime fillingDate, String grantedNo, LocalDateTime grantedDate, String progress){
		this.topic = topic;
		this.link = link;
		this.detail = detail;
		this.publicationType = publicationType;
		this.inventor = inventor;
		this.fillingDate = fillingDate;
		this.fillingNo = fillingNo;
		this.grantedDate = grantedDate;
		this.grantedNo = grantedNo;
		this.progress = progress;
	}
}
