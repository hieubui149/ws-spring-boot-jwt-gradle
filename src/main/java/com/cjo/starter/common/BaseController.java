package com.cjo.starter.common;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
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
 * 
 * @author Tomas
 * @version 1.0
 * @since Feb 20, 2019
 *
 */
@Transactional
public class BaseController {

	@Autowired
	private MessageSource messageSource;

	private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

	private String getMessage(final String messageCode) {
		try {
			return messageSource.getMessage(messageCode, null, DEFAULT_LOCALE);
		} catch (NoSuchMessageException ex) {
			return messageCode;
		}
	}

	public ResponseEntity<Response> success() {
		return new ResponseEntity<Response>(new Response(0, ""), HttpStatus.OK);
	}

	public ResponseEntity<Response> success(Object data) {
		return new ResponseEntity<Response>(new Response(0, "", data), HttpStatus.OK);
	}

	public ResponseEntity<Response> error(final int code, final String messageCode) {
		return new ResponseEntity<Response>(new Response(code, getMessage(messageCode), null),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Response> badRequest(final String messageCode) {
		return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(), getMessage(messageCode), null),
				HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Response> badRequest(final String... messages) {
		return new ResponseEntity<Response>(
				new Response(HttpStatus.BAD_REQUEST.value(), Arrays.toString(messages), null), HttpStatus.BAD_REQUEST);
	}

}
