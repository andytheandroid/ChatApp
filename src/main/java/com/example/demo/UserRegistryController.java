package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserRegistryController {
	
	
	@Autowired
	UserRegistryService registryService;
	
	
	 @RequestMapping(value= "/newUser", method=RequestMethod.POST)  
	 public String registerUser(@RequestBody Users newUser) {
	
		 System.out.println("hola mundo registrando usuario");
		 registryService.registerUser(newUser);
		 
		 return "Sucess";
		 
	      
	  
	 }
	

}
