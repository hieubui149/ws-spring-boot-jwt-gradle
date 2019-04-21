package com.cjo.starter.auth.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjo.starter.auth.domain.AuthorityDomain;
import com.cjo.starter.auth.model.Authority;
import com.cjo.starter.auth.model.User;
import com.cjo.starter.auth.repository.AuthorityCRUDRepository;
import com.cjo.starter.auth.repository.UserCRUDRepository;
import com.cjo.starter.common.BaseService;
import com.cjo.starter.common.exception.UserException;

/**
 * @author Tomas
 * @date Apr 20, 2019
 *
 */
@Service
public class AuthorityService extends BaseService {

	@Autowired
	private AuthorityCRUDRepository authorityCRUDRepository;
	
	@Autowired
	private UserCRUDRepository userCRUDRepository;
	
	public AuthorityDomain createAuthority(AuthorityDomain authorityDomain) {
		Authority authority = new Authority(authorityDomain.getName(), authorityDomain.getShortName());
		authorityCRUDRepository.save(authority);
		
		return authorityDomain;
	}
	
	private User getUser(final int userId) {
		Optional<User> optUser = userCRUDRepository.findById(userId);
		if (!optUser.isPresent()) {
			throw new UserException("MSG_AUTH_0001");
		}
		return optUser.get();
	}
	
	/**
	 * @author Tomas
	 * @date Apr 21, 2019
	 */
	public Set<AuthorityDomain> getUserAuthorities(final int userId) {
		User user = getUser(userId);
		Set<Authority> userAuthorities = user.getAuthorities();
		
		AuthorityDomain.Builder builder = new AuthorityDomain.Builder();
		return userAuthorities.stream().map(authority -> {
			builder.setName(authority.getName()).setShortName(authority.getShortName());
			return builder.build();
		}).collect(Collectors.toSet());
	}
	
	public boolean addUserAuthority(int userId, List<Integer> authorityIds) {
		User user = getUser(userId);
		
		Set<Authority> authorities = authorityCRUDRepository.findByIdIn(authorityIds);
		if (authorities.size() != authorityIds.size()) {
			throw new UserException("MSG_AUTH_0002");
		}
		
		Set<Authority> userAuthorities = user.getAuthorities();
		if (userAuthorities != null) {
			userAuthorities.addAll(authorities);
		} else {
			user.setAuthorities(authorities);
		}
		userCRUDRepository.save(user);
		
		return true;
	}
	
	public boolean replaceUserAuthorities(int userId, List<Integer> authorityIds) {
		User user = getUser(userId);
		
		Set<Authority> authorities = authorityCRUDRepository.findByIdIn(authorityIds);
		if (authorities.size() != authorityIds.size()) {
			throw new UserException("MSG_AUTH_0002");
		}
		
		user.setAuthorities(authorities);
		userCRUDRepository.save(user);
		
		return true;
	}
	
}
