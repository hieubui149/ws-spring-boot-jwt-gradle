package com.cjo.mpos.common;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cjo.mpos.common.domain.Response;
import com.cjo.mpos.common.exception.UserException;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LogManager.getLogger(ErrorController.class);
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<Object> handleSQLException(HttpServletRequest request, SQLException ex){
		LOG.error("Execute SQL error", ex);
		String message = "Something's wrong (" + HttpStatus.INTERNAL_SERVER_ERROR.value() + ")";

		return new ResponseEntity<Object>(new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), message), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		int code = status.value();
//		String message = messageSource.get("com.exoty.webservice.error." + code);
		String message = "Something's wrong (" + code + ")";

		return new ResponseEntity<Object>(new Response(code, message), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ UserException.class })
	public ResponseEntity<Object> handleApplicationExceptionInternal(final RuntimeException ex, final WebRequest request) {
		return new ResponseEntity<Object>(new Response(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.OK);
	}

	@ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
	public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
		return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<Object> handleAccessDeniedInternal(final RuntimeException ex, final WebRequest request) {
		return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
	}
	
}
