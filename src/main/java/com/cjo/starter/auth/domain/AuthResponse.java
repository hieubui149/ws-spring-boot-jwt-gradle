package com.cjo.starter.auth.domain;

import com.cjo.starter.common.domain.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

public class AuthResponse extends Response<String> {

    public AuthResponse(final String token) {
        super(0, "", token);
    }

}
