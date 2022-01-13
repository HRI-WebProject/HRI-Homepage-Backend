package com.hri.hri_web_backend.domain;

import com.hri.hri_web_backend.global.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Administrator { //관리자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="administrator_id")
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.ROLE_ADMIN;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salt_id")
    private Salt salt;


    public Administrator() {
    }

    public Administrator(String username, String password){
        this.username = username;
        this.password = password;
    }

}
