/**
 * 
 */
package com.elango.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.elango.flightreservation.entities.User;
import com.elango.flightreservation.repos.UserRepository;
import com.elango.flightreservation.springsecurity.SecurityService;

/**
 * @author Dell
 *
 */
@Controller
public class UserController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("/showReg")
	public String ShowRegistrationPage() {
		LOGGER.info("Inside ShowRegistrationPage()");
		return "login/registerUser";
	}
	
	@RequestMapping(value = "/registerUser",method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("Inside register()" +user);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		return "login/login";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("Inside showLoginPage()");
		return "login/login";
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap modelMap) {
		LOGGER.info("Inside login() and the email is : "+email);
		
		/*LOGGER.error("ERROR");
		LOGGER.error("WARN");
		LOGGER.error("INFO");
		LOGGER.error("DEBUG");
		LOGGER.error("TRACE");*/
		
		boolean loginResponse = securityService.login(email, password);
		
		//User user= userRepo.findByEmail(email);
		if(loginResponse)//user.getPassword().equals(password)
		{
			return "findflights";
		}else {
			modelMap.addAttribute("msg", "Invalid user name or password.Please try again.");
		}
		return "login/login";
		
	}
}
