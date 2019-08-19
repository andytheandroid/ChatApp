package com.example.demo.LoginModule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService service;

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String performLoginUser(@RequestBody Users user){
    	
    	List<Users> results = service.requestUsers(user.getUsername(), user.getPassword());
    	
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
