package com.dkim.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class WelcomeController {
	@RequestMapping(method= {RequestMethod.GET})
	public ModelAndView welcome() {
		System.out.println("welcome controller reach here?????");
		
		ModelAndView mv = new ModelAndView("Welcome");
		return mv;
	}
}
