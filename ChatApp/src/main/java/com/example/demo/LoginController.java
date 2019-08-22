package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute Users user){
    	System.out.println("Servicio llamado");

    	List<Users> results = service.requestUsers(user.getUsername(), user.getPassword());
    	System.out.println("Servicio llamado");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());

    	if(results.isEmpty()) {
    		System.out.println("Not found");
    		return "Not found";
    	}
    	else {
    		System.out.println("Sucess");

    		return "Sucess";
    	}
    }

    
    @RequestMapping(value = "/getusers", method = RequestMethod.POST)
    public List<Users> getusers(){
    	
    	return service.getAllUsers();
    }

    
   
	
	
}
