package com.niit.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.database.model.Registration;
import com.niit.database.service.RegistrationService;

@Controller
public class RegistrationController {
	@Autowired
	RegistrationService rs;
	@RequestMapping(value = "/register")
	public String gtReg() {
		return "register";
		
	}
	@ModelAttribute("rege")
	public Registration gt()
	{
		return new Registration();
	}
@RequestMapping(value="/fregister")
public ModelAndView ji(@ModelAttribute("rege") Registration registration)
{
	ModelAndView mc=new ModelAndView("index");
		rs.save(registration);
		return mc;
}


}
