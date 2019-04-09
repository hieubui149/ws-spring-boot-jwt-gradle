package com.cjo.starter.auth.principal;

import com.cjo.starter.auth.domain.Role;

public class AdminPrincipal implements IPrincipal {

	public final String adminId;
	public final String token;
	
	public AdminPrincipal(final String adminId, final String token) {
		this.adminId = adminId;
		this.token = token;
	}
	
	@Override
	public String[] getRoleNames() {
		return new String[] {Role.ROLE_ADMIN.role};
	}

}
