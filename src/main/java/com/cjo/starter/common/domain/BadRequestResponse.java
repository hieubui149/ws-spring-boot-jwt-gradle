package com.cjo.starter.common.domain;

import org.springframework.http.HttpStatus;

public class BadRequestResponse extends Response<String[]> {

    public BadRequestResponse(final String message, final String... data) {
        super(HttpStatus.BAD_REQUEST.value(), "", data);
    }

}
