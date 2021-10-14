package com.hri.hri_web_backend.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Administrator { //관리자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="administrator_id")
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    protected Administrator() {
    }

    public Administrator(String username, String password){
        this.username = username;
        this.password = password;
    }

}
