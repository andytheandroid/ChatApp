package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistryService {
	
	
	@Autowired
	LoginRepositoryImpl userRepo;
	
	
	public String registerUser(Users newUser) {
	
		
		Users answer = userRepo.findByUsername(newUser.getUsername());
		
		
	   //if we cant found a user this means that is new so proceed to register it
		if (answer == null) {
			userRepo.save(newUser);
			return "Sucess";

		}
		
	
		
		return "Error";
		
		
		
	}
	
	

}
