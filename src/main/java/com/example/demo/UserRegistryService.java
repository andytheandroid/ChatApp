package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistryService {
	
	
	@Autowired
	LoginRepositoryImpl userRepo;
	
	
	public String registerUser(Users newUser) {
	
		userRepo.save(newUser);
		
		
		return "Sucess";
		
	}
	
	

}
