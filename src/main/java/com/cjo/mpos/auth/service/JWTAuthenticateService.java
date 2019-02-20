package com.cjo.mpos.auth.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cjo.mpos.auth.JWTClaimer;
import com.cjo.mpos.auth.domain.JWTConfig;
import com.cjo.mpos.auth.domain.JWTPayload;
import com.cjo.mpos.auth.token.AbstractRoleAuthenticatedToken;
import com.cjo.mpos.auth.token.AdminAuthenticatedToken;
import com.cjo.mpos.auth.token.IRoleAuthenticatedTokenFactory;
import com.cjo.mpos.auth.token.UserAuthenticatedToken;
import com.cjo.mpos.common.BaseService;

@Service
public class JWTAuthenticateService extends BaseService {

	private JWTVerifier verifier;

	@Autowired
	private JWTConfig jwtConfig;

	private Map<String, IRoleAuthenticatedTokenFactory> roleAuthenticatedTokenFactories;

	@PostConstruct
	public void init() {
		verifier = JWT.require(jwtConfig.getAlgorithm()).withIssuer(jwtConfig.getIssuer()).build();

		roleAuthenticatedTokenFactories = new HashMap<>();
		roleAuthenticatedTokenFactories.put("ROLE_USER", new UserAuthenticatedToken.UserAuthenticatedTokenFactory());
		roleAuthenticatedTokenFactories.put("ROLE_ADMIN", new AdminAuthenticatedToken.AdminAuthenticatedTokenFactory());
	}

	public final Optional<String> createToken(final String email, JWTPayload payload) {
		String generatedToken = null;
		try {
			Builder builder = JWT.create().withIssuer(jwtConfig.getIssuer());
			JWTClaimer.claim(payload, builder);
			generatedToken = builder.sign(jwtConfig.getAlgorithm());			
		} catch (JWTCreationException exception) {
		}
		return Optional.ofNullable(generatedToken);
	}

	public final Authentication verifyToken(final String token) {
		try {
			return getAuthenticationToken(verifier.verify(token), token);
		} catch (SignatureVerificationException svException) {
		} catch (TokenExpiredException teException) {
		}
		return null;
	}

	private AbstractRoleAuthenticatedToken getAuthenticationToken(DecodedJWT jwt, final String token) {
		String id = jwt.getClaim("email").asString();
		String role = jwt.getClaim("role").asString();
		return getAutenticationTokenFactory(role).getAuthenticatedToken(id, token);
	}

	private IRoleAuthenticatedTokenFactory getAutenticationTokenFactory(final String role) {
		return roleAuthenticatedTokenFactories.get(role);
	}

}