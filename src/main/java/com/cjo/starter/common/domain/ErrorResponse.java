package com.cjo.starter.common.domain;

import org.springframework.http.HttpStatus;

public class ErrorResponse extends Response<String> {

    public ErrorResponse(final int code, final String message) {
        super(code, message);
    }

}
