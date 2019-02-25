package com.cjo.mpos.common.domain;

/**
 * 
 * The class Response<br>
 * <br>
 * Wrap http response in application looks <br>
 * <br>
 * @author Tomas
 * @version 1.0
 * @since Feb 20, 2019
 *
 */
public class Response {
	
	public final int code;
	public final String message;
	public final Object data;
	
	public Response(final int code, final String message) {
		this(code, message, null);
	}
	
	public Response(final int code, final String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
}
