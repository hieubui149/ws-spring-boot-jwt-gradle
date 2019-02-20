package com.cjo.mpos.auth.domain;

public enum Role {

	ROLE_USER("ROLE_USER"),
	ROLE_ADMIN("ROLE_ADMIN");
	
	public final String role;
	
	private Role(String value) {
		this.role = value;
	}
	
	public static Role fromString(String roleName) {
		for (Role role : Role.values()) {
			if (roleName.equals(role.role)) {
				return role;
			}
		}
		return null;
	}
	
}
