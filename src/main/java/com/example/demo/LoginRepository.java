package com.example.demo;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends  MongoRepository < Users, String > {

	    List<Users> findUserByName(String name,String password);
	    Users findByUsername(String username);

	   
}