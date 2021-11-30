package com.hri.hri_web_backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Salt {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private String salt;

	public Salt() {
	}

	public Salt(String salt) {
		this.salt = salt;
	}
}