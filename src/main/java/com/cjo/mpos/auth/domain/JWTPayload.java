package com.cjo.mpos.auth.domain;

/**
 * 
 * The class JWTPayload<br>
 * <br>
 * <br>
 * @author Tomas
 * @version 1.0
 * @since Feb 20, 2019
 *
 */
public class JWTPayload {

	private String email;
	private String role;
	
	public JWTPayload setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getEmail() {
		return email;
	}

	public JWTPayload setRole(String role) {
		this.role = role;
		return this;
	}

	public String getRole() {
		return role;
	}

}
