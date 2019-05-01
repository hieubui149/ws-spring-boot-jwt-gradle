package com.cjo.starter.auth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.cjo.starter.auth.service.AuthService;
import com.cjo.starter.common.BaseController;
import com.cjo.starter.common.domain.Response;

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
@RequestMapping("${url.prefix}/v1/auth")
public class AuthController extends BaseController {

//	private static final Logger LOGGER = LogManager.getLogger(AuthController.class);
	private static final String REGEX_EMAIL_PATTERN = "^[a-zA-Z0-9.]*@[a-zA-Z0-9]*.[a-z]*$";
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signin")
	public ResponseEntity<Response> postLogin(@RequestBody Map<String, String> body) {
		final String email = body.get("email");
		final String password = body.get("password");
		
		if (StringUtils.isEmpty(email) || !email.matches(REGEX_EMAIL_PATTERN)) { 
			return badRequest("email", "password");
		}
		
		if (StringUtils.isEmpty(password)) {
			return badRequest("email", "password");
		}
		
		String token = authService.signin(email, password);
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
		
		if (StringUtils.isEmpty(email) || !email.matches(REGEX_EMAIL_PATTERN)) { 
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
	
	@DeleteMapping("/signout")
	public ResponseEntity<Response> signout() {
		// TODO delete user session
		// currently doing nothing here
		System.out.println("sign out successfully");
		return success();
	}

}
