package com.cjo.starter.auth.domain;

import com.cjo.starter.common.domain.Response;
import org.springframework.http.ResponseEntity;

public class AuthRequestDomain {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
