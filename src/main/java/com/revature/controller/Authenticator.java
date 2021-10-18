package com.revature.controller;

import com.revature.repo.UserDAOImplimentation;
import com.revature.service.Service;

import io.javalin.http.Context;

public class Authenticator {
	
	public boolean login(String username, String password) {
		
		boolean status = false;
		
		UserDAOImplimentation ud = new UserDAOImplimentation();
		Service s = new Service();
		String destination = "";
		int id = s.validate(username);
		
		
		
		if(id != 0 && password.equals(ud.checkPassword(id))) {
			
			status = true;
			
		}
		
		return status;
		
	}

}
