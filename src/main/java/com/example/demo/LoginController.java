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


 	
	 @RequestMapping("/restricted")  
	    String restricted() {  
	        return "error";  
	    }  
    		
    		
	
  

    	
    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute Users user){

    	System.out.println("Servicio llamado");

    	
    	
    	
    	
    	List<Users> users = service.requestUsers(user.getUsername(), user.getPassword());
    	
    	

    	System.out.println(users);
    	if(users.isEmpty()) {
    		System.out.println("Not found");
    		return "Error";
    	}
    	else {
    		if(users.get(0).isLogged()) {
    			return "Main";
    		}else {
    			return "login";
    		}
    		
    		
    		

    	}

    	return "/Main";
   
    

    }

    
    
   
    
    
    
    @RequestMapping(value = "/getusers", method = RequestMethod.POST)
    public List<Users> getusers(){
    	
    	return service.getAllUsers();
    }

    
   
	
	
}
