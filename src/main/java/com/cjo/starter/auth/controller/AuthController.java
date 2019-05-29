package com.cjo.starter.auth.controller;

import java.util.Map;

import com.cjo.starter.auth.domain.AuthRequestDomain;
import com.cjo.starter.auth.domain.AuthResponse;
import com.cjo.starter.common.domain.BadRequestResponse;
import com.cjo.starter.common.domain.ErrorResponse;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@Api(value = "Authentication enpoints")
public class AuthController extends BaseController {

//	private static final Logger LOGGER = LogManager.getLogger(AuthController.class);
	private static final String REGEX_EMAIL_PATTERN = "^[a-zA-Z0-9.]*@[a-zA-Z0-9]*.[a-z]*$";
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signin")
	@ApiOperation(value = "Signing in into the system.", response = AuthResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = AuthResponse.class),
			@ApiResponse(code = 400, message = "Bad request", response = BadRequestResponse.class),
			@ApiResponse(code = 500, message = "Error", response = ErrorResponse.class),
	})
	public ResponseEntity<Response> postLogin(
			@ApiParam(
					value = "Authentication request body"
			) @RequestBody AuthRequestDomain auth) {
		final String email = auth.getEmail();
		final String password = auth.getPassword();
		
		if (StringUtils.isEmpty(email) || !email.matches(REGEX_EMAIL_PATTERN)) { 
			return badRequest("email", "password");
		}
		
		if (StringUtils.isEmpty(password)) {
			return badRequest("email", "password");
		}
		
		String token = authService.signin(email, password);
		if (token != null) {
			return success(new AuthResponse(token));
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
