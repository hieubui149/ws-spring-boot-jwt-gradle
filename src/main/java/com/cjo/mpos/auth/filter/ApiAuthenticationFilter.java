package com.cjo.mpos.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.cjo.mpos.auth.domain.Token;
import com.cjo.mpos.auth.service.JWTAuthenticateService;

@Component
public class ApiAuthenticationFilter extends GenericFilterBean {

	@Autowired
	private JWTAuthenticateService jwtAuthenticateService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			final String token = request.getParameter(Token.Key.value);
			
			if (!StringUtils.isEmpty(token)) {
				Authentication authentication = jwtAuthenticateService.verifyToken(token);
				if (authentication != null) {
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}
		chain.doFilter(request, response);
	}
	
}
