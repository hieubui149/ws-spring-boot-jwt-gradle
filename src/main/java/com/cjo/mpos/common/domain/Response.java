package com.cjo.mpos.common.domain;

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
