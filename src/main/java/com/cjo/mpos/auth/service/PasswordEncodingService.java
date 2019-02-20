package com.cjo.mpos.auth.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.cjo.mpos.common.BaseService;

@Service
public class PasswordEncodingService extends BaseService {

	@Value("${bcrypt.logrounds}")
	private int logRounds;
	
	public String hashpw(final String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(logRounds));
	}

	public boolean check(final String password, final String hash) {
		return BCrypt.checkpw(password, hash);
	}
	
}
