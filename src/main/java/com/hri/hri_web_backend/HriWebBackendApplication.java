package com.hri.hri_web_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HriWebBackendApplication {

	public static void main(String[] args) {

		//    @PostConstruct //배포시 삭제 , 테스트 코드 때문에 잠시 주석처리
		//    public void init() {
		//        Administrator administrator = new Administrator("root", "pass");
		//        administratorService.join(administrator);
		//    }

		SpringApplication.run(HriWebBackendApplication.class, args);
	}

}
