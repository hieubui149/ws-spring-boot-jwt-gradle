package com.cjo.starter.module.jspdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("${url.prefix}/view")
public class JSPViewTestController {

	@RequestMapping("/welcome")
	public ModelAndView welcomePage() {
		return new ModelAndView("Welcome");
	}
	
}
