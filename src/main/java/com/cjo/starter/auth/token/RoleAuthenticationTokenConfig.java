package com.cjo.starter.auth.token;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
