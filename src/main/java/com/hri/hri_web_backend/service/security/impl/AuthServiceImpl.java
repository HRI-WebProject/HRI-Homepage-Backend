package com.hri.hri_web_backend.service.security.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.hri.hri_web_backend.domain.Administrator;
import com.hri.hri_web_backend.domain.Salt;
import com.hri.hri_web_backend.repository.AdminRepository;
import com.hri.hri_web_backend.service.security.AuthService;
import com.hri.hri_web_backend.service.security.SaltUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	private final AdminRepository adminRepository;
	private final SaltUtil saltUtil;

	@Override
	public void signUpAdministrator(Administrator administrator) {
		String password = administrator.getPassword();
		String salt = saltUtil.genSalt();
		administrator.setSalt(new Salt(salt));
		administrator.setPassword(saltUtil.encodePassword(salt,password));
		adminRepository.save(administrator);
	}

	@Override
	public Administrator loginAdministrator(String username, String password) throws Exception{
		Administrator administrator = adminRepository.findByUsername(username);
		if (administrator == null) throw new Exception("멤버가 조회되지 않음");
		String salt = administrator.getSalt().getSalt();
		password = saltUtil.encodePassword(salt,password);
		if(!administrator.getPassword().equals(password))
			throw new Exception("비밀번호가 틀립니다");
		return administrator;
	}
}
