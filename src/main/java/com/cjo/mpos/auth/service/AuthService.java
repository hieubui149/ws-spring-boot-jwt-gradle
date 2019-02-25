package com.cjo.mpos.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjo.mpos.auth.domain.JWTPayload;
import com.cjo.mpos.auth.domain.Role;
import com.cjo.mpos.auth.model.User;
import com.cjo.mpos.auth.model.UserRole;
import com.cjo.mpos.auth.repository.UserCRUDRepository;
import com.cjo.mpos.auth.repository.UserRoleCRUDRepository;
import com.cjo.mpos.common.BaseService;
import com.cjo.mpos.common.exception.UserException;

/**
 * 
 * The class AuthService<br>
 * <br>
 * A service to handle all authentication logic .<br>
 * <br>
 * @author Tomas
 * @version 1.0
 * @since Feb 20, 2019
 *
 */
@Service
public class AuthService extends BaseService {

	@Autowired
	private UserCRUDRepository userRepository;

	@Autowired
	private UserRoleCRUDRepository userRoleRepository;
	
	@Autowired
	private JWTAuthenticateService jwtAuthenticateService;

	@Autowired
	private PasswordEncodingService passwordEncodingService;

	private String prepareJwtToken(final String email, final Role role) {
		JWTPayload payload = new JWTPayload().setEmail(email).setRole(role.role);
		return jwtAuthenticateService.createToken(email, payload).get();
	}

	public String signup(final String email, final String password) {
		User user = new User(email, passwordEncodingService.hashpw(password));
		UserRole userRole = new UserRole(Role.ROLE_USER.role);
		userRole.setUser(user);
		
		String token = prepareJwtToken(email, Role.ROLE_USER);
		if (token != null) {
			user.setToken(token);
			user = userRepository.save(user);
			userRoleRepository.save(userRole);
			return token;
		} else {
			return null;
		}
	}

	public String login(final String email, final String password) throws UserException {
		List<User> users = userRepository.findByEmail(email);
		if (users.isEmpty()) {
			throw new UserException("Username or password does not match");
		}
		
		User user = users.get(0);
		if (!passwordEncodingService.check(password, user.getPassword())) {
			throw new UserException("Username or password does not match");
		}
		
		String token = prepareJwtToken(email, Role.fromString(user.getUserRole().getRoleName()));
		if (token != null) {
			user.setToken(token);
			user = userRepository.save(user);
			return token;
		}
		return null;
	}

}
