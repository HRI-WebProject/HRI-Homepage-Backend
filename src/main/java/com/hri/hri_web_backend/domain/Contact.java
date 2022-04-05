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
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private Long id;

	private String professorName;
	private String professorEmail;
	private String professorPhone;

	private String labManagerName;
	private String labManagerEmail;
	private String labManagerPhone;

	private String officeLocation;
	private String officePhone;

	@Builder
	public Contact(String professorName, String professorEmail, String professorPhone,
		String labManagerName, String labManagerEmail, String labManagerPhone, String officeLocation,
		String officePhone) {
		this.professorName = professorName;
		this.professorEmail = professorEmail;
		this.professorPhone = professorPhone;
		this.labManagerName = labManagerName;
		this.labManagerEmail = labManagerEmail;
		this.labManagerPhone = labManagerPhone;
		this.officeLocation = officeLocation;
		this.officePhone = officePhone;
	}

	protected Contact() {}
}
