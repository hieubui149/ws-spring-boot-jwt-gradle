package com.cjo.mpos.auth;

import com.auth0.jwt.JWTCreator.Builder;
import com.cjo.mpos.auth.domain.JWTPayload;

public class JWTClaimer {

	public static void claim(JWTPayload payload, Builder builder) {
		builder.withClaim("email", payload.getEmail());
		builder.withClaim("role", payload.getRole());
	}
	
}
