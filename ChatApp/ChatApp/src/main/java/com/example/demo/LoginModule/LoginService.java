package com.example.demo.LoginModule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class LoginService {

	@Autowired
	private LoginRepositoryImpl userRepo;
	
	
	public List<Users> requestUsers(String name,String password){
		
	List<Users> results = userRepo.findUserByName(name, password);

	return results;
	}
	
	public List<Users> getAllUsers(){
		return  userRepo.findAll();
	
	}
}
