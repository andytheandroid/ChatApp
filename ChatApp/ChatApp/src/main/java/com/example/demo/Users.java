package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "User")
@Entity
public class  Users {
	
    @Id
    public String id;
    
    @Field("Username")

    private String username;
    
    @Field("Password")

    private	String password;
    
   
   public String getUsername() {
		return username;
	}
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
