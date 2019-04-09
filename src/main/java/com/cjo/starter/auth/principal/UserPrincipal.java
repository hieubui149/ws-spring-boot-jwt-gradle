package com.cjo.starter.auth.principal;

import com.cjo.starter.auth.domain.Role;

public class UserPrincipal implements IPrincipal {

	public final String mbrId;
	public final String token;
	
	public UserPrincipal(final String mbrId, final String token) {
		this.mbrId = mbrId;
		this.token = token;
	}
	
	@Override
	public String[] getRoleNames() {
		return new String[] {Role.ROLE_USER.role};
	}
}
