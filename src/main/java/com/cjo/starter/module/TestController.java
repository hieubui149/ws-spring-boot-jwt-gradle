package com.cjo.starter.module;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Secured({"ROLE_USER"})
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
}
