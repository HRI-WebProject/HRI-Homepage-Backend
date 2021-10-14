package com.hri.hri_web_backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hri.hri_web_backend.global.DegreeEnum;

@Entity
@Getter
@Setter
public class Member {
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

    private DegreeEnum degree;

    private Boolean graduate;

    protected Member() {
    }

    @Builder
    public Member(String name, String engName, String email, String photo, DegreeEnum degree, Boolean graduate) {
        this.name = name;
        this.engName = engName;
        this.email = email;
        this.photo = photo;
        this.degree = degree;
        this.graduate = graduate;
    }
}
