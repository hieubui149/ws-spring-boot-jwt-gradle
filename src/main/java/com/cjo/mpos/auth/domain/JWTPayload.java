package com.cjo.mpos.auth.domain;

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
