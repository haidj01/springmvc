package com.dkim.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dkim.springmvc.service.EmpService;

@Controller
public class WelcomeController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value="/" , method= {RequestMethod.GET})
	public ModelAndView welcome() {
		System.out.println("welcome controller reach here?????");
		System.out.println("emp Size ::"+ empService.getEmp().size());
		ModelAndView mv = new ModelAndView("Welcome");
		return mv;
	}
}
