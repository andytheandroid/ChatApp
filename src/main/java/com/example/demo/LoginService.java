package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component

public class LoginService implements UserDetailsService {

	@Autowired
	private LoginRepositoryImpl userRepo;
	
	
	public List<Users> requestUsers(String name,String password){
		
	List<Users> results = userRepo.findUserByName(name, password);

    if(!results.isEmpty()) {
    	
    	if(!results.get(0).isLogged()) {
    		
    		userRepo.save(results.get(0));
    		
    		
    	}
    	
    }
	
	
	
	
	return results;
	}
	
	public List<Users> getAllUsers(){
		return  userRepo.findAll();
	
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepo.findByUsername(username);
		System.out.println("Funciona por favor");
	System.out.println(user);
		if(user == null) {
	      throw new UsernameNotFoundException("User not found");
	    }
	    List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
	    return new User(user.getUsername(), user.getPassword(), authorities);
	}
}
