package com.cjo.mpos.auth.token;

import com.cjo.mpos.auth.principal.AdminPrincipal;

public class AdminAuthenticatedToken extends AbstractRoleAuthenticatedToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = -309211816317092680L;

	public AdminAuthenticatedToken(AdminPrincipal principal) {
		super(principal);
	}

	public static class AdminAuthenticatedTokenFactory implements IRoleAuthenticatedTokenFactory {

		@Override
		public AbstractRoleAuthenticatedToken getAuthenticatedToken(final String id, final String token) {
			return new AdminAuthenticatedToken(new AdminPrincipal(id, token));
		}
	}
	
}
