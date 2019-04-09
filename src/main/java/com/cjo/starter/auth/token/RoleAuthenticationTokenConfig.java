package com.cjo.starter.auth.token;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cjo.starter.auth.token.impl.AdminAuthenticatedToken;
import com.cjo.starter.auth.token.impl.UserAuthenticatedToken;

@Configuration
public class RoleAuthenticationTokenConfig {

	@Bean
	public IRoleAuthenticatedTokenFactory userAuthenticationTokenFactory() {
		return new UserAuthenticatedToken.UserAuthenticatedTokenFactory();
	}

	@Bean
	public IRoleAuthenticatedTokenFactory adminAuthenticationTokenFactory() {
		return new AdminAuthenticatedToken.AdminAuthenticatedTokenFactory();
	}

}
