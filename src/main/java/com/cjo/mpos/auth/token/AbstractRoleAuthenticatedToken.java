package com.cjo.mpos.auth.token;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.cjo.mpos.auth.principal.IPrincipal;

/**
 * 
 * The class AbstractRoleAuthenticatedToken<br>
 * <br>
 * Defined a base authentication token for traveling inside application.<br>
 * <br>
 * @author Tomas
 * @version 1.0
 * @since Feb 20, 2019
 *
 */
public abstract class AbstractRoleAuthenticatedToken implements Authentication {

	private static final long serialVersionUID = 8002258688206667598L;
	
	private IPrincipal principal;
	
	public AbstractRoleAuthenticatedToken(IPrincipal principal) {
		this.principal = principal;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(principal.getRoleNames().length);
		for (String roleName : principal.getRoleNames()) {
			authorities.add(new SimpleGrantedAuthority(roleName));
		}
		return authorities;
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getDetails() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	@Override
	public boolean isAuthenticated() {
		return true;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		
	}

	@Override
	public String getName() {
		return null;
	}

}
