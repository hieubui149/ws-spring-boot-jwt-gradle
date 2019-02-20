package com.cjo.mpos.auth.domain;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JWTConfig {
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.issuer}")
	private String issuer;
	
	private Algorithm algorithm;
	
	@PostConstruct
	public void init() {
		algorithm = Algorithm.HMAC256(secret);
	}
	
	public Algorithm getAlgorithm() {
		return algorithm;
	}
	
	public final String getIssuer() {
		return issuer;
	}
	
}
