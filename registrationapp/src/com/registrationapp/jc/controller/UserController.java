package com.registrationapp.jc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.registrationapp.jc.model.UserEntity;
import com.registrationapp.jc.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping("/home")
	public String gohome() {
		
		return "home";
	}
	
	@RequestMapping("/registration")
	public ModelAndView getregform() {
		ModelAndView mv = new ModelAndView("registration");
		mv.addObject("user", new UserEntity());
		return mv;
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String addCompBook(@ModelAttribute("user") UserEntity user) {
		if(service.addUser(user))
			return "redirect:/home";
		else {
			return "ErrorPage";
		}
	}
	
	@RequestMapping("/login")
	public ModelAndView getloginform() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new UserEntity());
		return mv;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginAction(@ModelAttribute("user") UserEntity user) {
		if(service.isUserExist(user.getEmail(), user.getPass()))
			return "redirect:/home";
		else {
			return "ErrorPage";
		}
	}
}
