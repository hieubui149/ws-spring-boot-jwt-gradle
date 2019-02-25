package com.cjo.mpos.auth;

import com.auth0.jwt.JWTCreator.Builder;
import com.cjo.mpos.auth.domain.JWTPayload;

/**
 * 
 * The class JWTClaimer<br>
 * <br>
 * Jwt custom person to extract information from jwt token .<br>
 * <br>
 * @author Tomas
 * @version 1.0
 * @since Feb 20, 2019
 *
 */
public class JWTClaimer {

	public static void claim(JWTPayload payload, Builder builder) {
		builder.withClaim("email", payload.getEmail());
		builder.withClaim("role", payload.getRole());
	}
	
}
