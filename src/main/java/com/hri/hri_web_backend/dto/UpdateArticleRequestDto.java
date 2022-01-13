package com.hri.hri_web_backend.dto;

import com.hri.hri_web_backend.global.BoardType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateArticleRequestDto {

    private String topic;
    private String content;
    private String author;
    private BoardType boardType;

    protected UpdateArticleRequestDto(){
    }

    @Builder
    public UpdateArticleRequestDto(String topic, String content, String author, BoardType boardType){
        this.topic = topic;
        this.content = content;
        this.author = author;
        this.boardType = boardType;
    }
}
