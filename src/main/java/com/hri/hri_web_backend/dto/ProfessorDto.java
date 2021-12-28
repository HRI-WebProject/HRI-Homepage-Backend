package com.hri.hri_web_backend.dto;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
public class ProfessorDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "eng_name")
    private String engName;

    private String email;

    private String photo;

    private String boldDetail;

    private String detail;

    protected ProfessorDto() {
    }

    @Builder
    public ProfessorDto(String name, String engName, String email, String photo, String boldDetail, String detail) {
        this.name = name;
        this.engName = engName;
        this.email = email;
        this.photo = photo;
        this.boldDetail = boldDetail;
        this.detail = detail;
    }
}
