package com.niit.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value="/landing")
	public String home()
	{
		return "carousel";
	}

}
