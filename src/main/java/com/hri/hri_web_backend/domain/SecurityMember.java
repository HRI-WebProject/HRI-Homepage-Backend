package com.hri.hri_web_backend.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityMember extends User {
	private static final long serialVersionUiD = 1L;

	public SecurityMember(Administrator admin) {
		super(admin.getUsername(), "{noop}" + admin.getPassword(),
			AuthorityUtils.createAuthorityList(admin.getRole().toString()));
	}
}
