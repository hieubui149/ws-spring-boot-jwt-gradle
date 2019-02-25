package com.cjo.mpos.common.exception;

/**
 * 
 * The class UserException<br>
 * <br>
 * Application defined exception by default.<br>
 * <br>
 * @author Tomas
 * @version 1.0
 * @since Feb 20, 2019
 *
 */
public class UserException extends RuntimeException {

	private static final long serialVersionUID = 1382317401738167200L;

	public UserException() {
		super();
	}
	
	public UserException(String message) {
		super(message);
	}
	
}
