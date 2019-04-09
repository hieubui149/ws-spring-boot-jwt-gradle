package com.cjo.starter.auth.token;

import com.cjo.starter.auth.domain.Role;

public interface IRoleAuthenticatedTokenFactory {

	Role getPresentedRole();
	
	AbstractRoleAuthenticatedToken getAuthenticatedToken(final String id, final String token);
	
}
