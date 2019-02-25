package com.cjo.mpos.auth.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjo.mpos.auth.service.AuthService;
import com.cjo.mpos.common.BaseController;
import com.cjo.mpos.common.domain.Response;

/**
 * 
 * The class AuthController<br>
 * <br>
 * An enpoints for application authentication.<br>
 * <br>
 * @author Tomas
 * @version 1.0
 * @since Feb 20, 2019
 *
 */
@RestController
@RequestMapping("mpos/v1/auth")
public class AuthController extends BaseController {

	private static final Logger LOGGER = LogManager.getLogger(AuthController.class);
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<Response> postLogin(@RequestBody Map<String, String> body) {
		final String email = body.get("email");
		final String password = body.get("password");
		
		// validate email
		String validatedEmailPattern = "^[a-zA-Z0-9.]*\\@[a-zA-Z0-9]*\\.[a-z]*$";
		if (StringUtils.isEmpty(email) || !email.matches(validatedEmailPattern)) { 
			return badRequest("email", "password");
		}
		
		if (StringUtils.isEmpty(password)) {
			return badRequest("email", "password");
		}
		
		String token = authService.login(email, password);
		if (token != null) {
			return success(token);
		} else {
			return error(500, "Cannot create token");
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Response> signup(@RequestBody Map<String, String> body) {
		final String email = body.get("email");
		final String password = body.get("password");
		
		// validate email
		String validatedEmailPattern = "^[a-zA-Z0-9.]*\\@[a-zA-Z0-9]*\\.[a-z]*$";
		if (StringUtils.isEmpty(email) || !email.matches(validatedEmailPattern)) { 
			return badRequest("email");
		}
		
		if (StringUtils.isEmpty(password)) {
			return badRequest("password");
		}
		
		String token = authService.signup(email, password);
		if (token != null) {
			return success(token);
		} else {
			return error(500, "Cannot create token");
		}
	}
	
}
