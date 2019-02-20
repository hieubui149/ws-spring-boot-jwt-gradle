package com.cjo.mpos.auth.token;

public interface IRoleAuthenticatedTokenFactory {

	AbstractRoleAuthenticatedToken getAuthenticatedToken(final String id, final String token);
	
}
