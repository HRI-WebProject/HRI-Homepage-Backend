package com.hri.hri_web_backend.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

//글 목록 불러올 때 사용
@Getter
@Setter
public class GetArticleRequestDto {
	Long id;
	String topic;
	LocalDateTime createDate;
	String author;

	public GetArticleRequestDto(Long id, String topic, String author, LocalDateTime createDate) {
		this.id = id;
		this.topic = topic;
		this.createDate = createDate;
		this.author = author;
	}
}
