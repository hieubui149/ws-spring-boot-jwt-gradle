package com.cjo.starter.auth.principal;

import com.cjo.starter.auth.domain.Role;

public class UserPrincipal implements IPrincipal {

	public final String userId;
	public final String token;
	
	public UserPrincipal(final String userId, final String token) {
		this.userId = userId;
		this.token = token;
	}
	
	@Override
	public String[] getRoleNames() {
		return new String[] {Role.ROLE_USER.role};
	}
}
