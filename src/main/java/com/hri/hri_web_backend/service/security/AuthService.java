package com.hri.hri_web_backend.service.security;

import com.hri.hri_web_backend.domain.Administrator;

public interface AuthService {
	void signUpAdministrator(Administrator administrator);

	Administrator loginAdministrator(String id, String password) throws Exception;
}
