package com.hri.hri_web_backend;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hri.hri_web_backend.domain.Administrator;
import com.hri.hri_web_backend.service.AdminService;

@SpringBootApplication
public class HriWebBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HriWebBackendApplication.class, args);
	}

}
