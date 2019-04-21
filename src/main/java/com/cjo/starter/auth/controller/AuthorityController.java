package com.cjo.starter.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjo.starter.auth.domain.AuthorityDomain;
import com.cjo.starter.auth.service.AuthorityService;
import com.cjo.starter.common.BaseController;
import com.cjo.starter.common.domain.Response;

/**
 * @author Tomas
 * @date Apr 20, 2019
 *
 */
@RestController
@RequestMapping("/mpos/v1/authority")
public class AuthorityController extends BaseController {

	@Autowired
	private AuthorityService authorityService;

	/**
	 * 
	 * @author Tomas
	 * @date Apr 21, 2019
	 * @param name
	 * @param shortName
	 * @return
	 */
	@Secured({"ROLE_ADMIN"})
	@PostMapping
	public ResponseEntity<Response> createAuthority(@RequestParam(name = "name") String name,
			@RequestParam(name = "shortName") String shortName) {
		AuthorityDomain.Builder builder = new AuthorityDomain.Builder();
		builder.setName(name).setShortName(shortName);

		AuthorityDomain domain = authorityService.createAuthority(builder.build());
		return success(domain);
	}

	/**
	 * @author Tomas
	 * @date Apr 21, 2019
	 */
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("/{userId}")
	public ResponseEntity<Response> getUserAuthorities(@PathVariable(name = "userId", required = true) Integer userId) {
		if (userId <= 0) {
			return badRequest("userId");
		}
		return success(authorityService.getUserAuthorities(userId));
	}
	
	/**
	 * 
	 * @author Tomas
	 * @date Apr 21, 2019
	 * @param userId
	 * @param authorityIds
	 * @return
	 */
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/{userId}")
	public ResponseEntity<Response> addUserAuthority(@PathVariable(name = "userId", required = true) Integer userId,
			@RequestParam(name = "authorityIds", required = true) List<Integer> authorityIds) {
		if (authorityIds.isEmpty()) {
			return badRequest("authorityIds");
		}
		
		authorityService.addUserAuthority(userId, authorityIds);
		return success();
	}

	/**
	 * 
	 * @author Tomas
	 * @date Apr 21, 2019
	 * @param userId
	 * @param authorityIds
	 * @return
	 */
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/{userId}/replace")
	public ResponseEntity<Response> replaceUserAuthorities(@PathVariable(name = "userId", required = true) Integer userId,
			@RequestParam(name = "authorityIds", required = true) List<Integer> authorityIds) {
		authorityService.replaceUserAuthorities(userId, authorityIds);
		return success();
	}
	
}
