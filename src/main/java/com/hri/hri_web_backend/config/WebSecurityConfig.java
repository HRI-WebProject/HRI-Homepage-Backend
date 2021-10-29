package com.hri.hri_web_backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.httpBasic().disable();
		//
		// http.authorizeRequests()
		// 	.antMatchers("/**").hasRole("ADMIN")
		// 	.anyRequest().authenticated(); /* 그 외 모든 요청은 인증된 사용자만 접근이 가능하게 처리*/

		http.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers("/**").hasRole("ADMIN")// 내부적으로 접두어 "ROLE_"가 붙음
			.anyRequest().authenticated();

		http.formLogin()
			.loginPage("/login") // default
			.loginProcessingUrl("/authenticate")
			.failureUrl("/login?error") // default
			.defaultSuccessUrl("/home")
			.usernameParameter("email")
			.passwordParameter("password")
			.permitAll();
		//
		// http.logout()
		// 	.logoutUrl("/logout") // default
		// 	.logoutSuccessUrl("/login")
		// 	.permitAll();
	}
}