package com.cjo.starter.common.domain;

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
public class Response<T> {
	
	public final int code;
	public final String message;
	protected T data;
	
	public Response(final int code, final String message) {
		this(code, message, null);
	}
	
	public Response(final int code, final String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
