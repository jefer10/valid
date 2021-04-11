package com.example.demo.controller.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view")
public class viewsController {
	
	@GetMapping(value = "/index")
	public String home() {
		//ModelAndView home=new ModelAndView();
		//home.setViewName("index");
		return "index";
	}
	
	@GetMapping(value="/update")
	public String update() {
		return "users";
	}

}
