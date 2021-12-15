package com.hri.hri_web_backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateArticleRequestDto {

    private String topic;
    private String content;
    private String author;

    @Builder
    public UpdateArticleRequestDto(String topic, String content, String author){
        this.topic = topic;
        this.content = content;
        this.author = author;
    }
}
