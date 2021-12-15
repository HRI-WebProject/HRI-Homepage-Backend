package com.hri.hri_web_backend.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hri.hri_web_backend.global.BoardType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private Long id;

	private String topic;
	@Column(length = 1000)
	private String content;
	private LocalDateTime createDate = LocalDateTime.now();
	private String author;
	private BoardType boardType;

	protected Article(){}

	@Builder
	public Article(String topic, String content, LocalDateTime dateTime, String author, BoardType boardType){
		this.topic=topic;
		this.content=content;
		this.author=author;
		this.boardType=boardType;
	}
}
