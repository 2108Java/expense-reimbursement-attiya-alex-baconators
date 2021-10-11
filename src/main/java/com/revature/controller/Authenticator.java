package com.revature.controller;

import com.revature.repo.UserDAOImplimentation;
import com.revature.service.Service;

import io.javalin.http.Context;

public class Authenticator {
	
	public String login(Context ctx) {
		
		UserDAOImplimentation ud = new UserDAOImplimentation();
		Service s = new Service();
		String destination = "";
		int id = s.validate(ctx.formParam("username"));
		
		if(id != 0 && ctx.formParam("password").equals(ud.checkPassword(id))) {
			
			ctx.sessionAttribute("loggedIn", true);
			destination = "/RequestsMenu.html";
			
		}else {
			
			ctx.sessionAttribute("loggedIn", false);
			destination = "/loginFailed.html";
			
		}
		
		return destination;
		
	}

}
