package com.hri.hri_web_backend.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hri.hri_web_backend.domain.Administrator;
import com.hri.hri_web_backend.domain.SecurityMember;
import com.hri.hri_web_backend.repository.AdminRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Administrator admin = adminRepository.findByUsername(username);
		if(admin== null){
			throw new UsernameNotFoundException(username + " : 사용자 존재하지 않음");
		}

		return new SecurityMember(admin);
	}
}