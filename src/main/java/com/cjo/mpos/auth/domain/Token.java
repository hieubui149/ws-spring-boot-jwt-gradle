package com.cjo.mpos.auth.domain;

/**
 * 
 * The class Token<br>
 * <br>
 * <br>
 * @author Tomas
 * @version 1.0
 * @since Feb 20, 2019
 *
 */
public enum Token {
	
	Key("token");
	
	public final String value;
	private Token(final String value) {
		this.value = value;
	}
	
}
