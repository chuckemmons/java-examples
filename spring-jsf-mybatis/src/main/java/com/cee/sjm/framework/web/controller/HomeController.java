package com.cee.sjm.framework.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/app/home")
	public ModelAndView home() {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("home");
		return mov;
	}
}
