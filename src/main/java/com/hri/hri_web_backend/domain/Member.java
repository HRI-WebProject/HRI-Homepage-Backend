package com.hri.hri_web_backend.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "member_id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String engName;

    @NotNull
    private String email;

    @NotNull
    private String photo;

    @NotNull
    private String degree;

    @NotNull
    private String graduate;

    protected Member() {

    }

    @Builder
    public Member(Long id, String name, String engName, String email, String photo, String degree, String graduate) {
        this.id = id;
        this.name = name;
        this.engName = engName;
        this.email = email;
        this.photo = photo;
        this.degree = degree;
        this.graduate = graduate;
    }
}
