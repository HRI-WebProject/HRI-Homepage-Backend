package com.hri.hri_web_backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Professor{

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

    protected Professor() {
    }

    @Builder
    public Professor(String name, String engName, String email, String photo, String boldDetail, String detail) {
        this.name = name;
        this.engName = engName;
        this.email = email;
        this.photo = photo;
        this.boldDetail = boldDetail;
        this.detail = detail;
    }

}
