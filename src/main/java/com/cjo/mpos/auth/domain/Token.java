package com.cjo.mpos.auth.domain;

public enum Token {
	
	Key("token");
	
	public final String value;
	private Token(final String value) {
		this.value = value;
	}
	
}
