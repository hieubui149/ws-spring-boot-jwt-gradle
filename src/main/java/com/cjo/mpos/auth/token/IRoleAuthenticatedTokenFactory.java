package com.cjo.mpos.auth.token;

import com.cjo.mpos.auth.domain.Role;

public interface IRoleAuthenticatedTokenFactory {

	Role getPresentedRole();
	
	AbstractRoleAuthenticatedToken getAuthenticatedToken(final String id, final String token);
	
}
