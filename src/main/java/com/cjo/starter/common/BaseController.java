package com.cjo.starter.common;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.cjo.starter.common.domain.Response;

/**
 * 
 * The class BaseController<br>
 * <br>
 * Define some utilities and useful function for derived controller.<br>
 * <br>
 * @author Tomas
 * @version 1.0
 * @since Feb 20, 2019
 *
 */
@Transactional
public class BaseController {

	public ResponseEntity<Response> success() {
		return new ResponseEntity<Response>(new Response(0, ""), HttpStatus.OK);
	}
	
	public ResponseEntity<Response> success(Object data) {
		return new ResponseEntity<Response>(new Response(0, "", data), HttpStatus.OK);
	}

	public ResponseEntity<Response> error(final int code, final String message) {
		return new ResponseEntity<Response>(new Response(code, message, null), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<Response> badRequest(final String message) {
		return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(), message, null), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<Response> badRequest(final String... messages) {
		return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(), Arrays.toString(messages), null), HttpStatus.BAD_REQUEST);
	}
	
}
