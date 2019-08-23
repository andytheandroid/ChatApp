package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;

   
    		
    		
	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    public String login(HttpServletRequest req) {
        return "loginUser";
    }
    		
    		

    	
    

    
    
   
    
    @RequestMapping(value = "/getusers", method = RequestMethod.POST)
    public List<Users> getusers(){
    	
    	return service.getAllUsers();
    }

    
   
	
	
}
