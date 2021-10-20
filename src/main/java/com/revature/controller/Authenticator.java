package com.revature.controller;

import com.revature.repo.UserDAOImplimentation;
import com.revature.service.Service;

import io.javalin.http.Context;

public class Authenticator {
	
	public String login(Context ctx) {
		
		boolean status = false;
		
		UserDAOImplimentation ud = new UserDAOImplimentation();
		Service s = new Service();
		String destination = "";
		int id = s.validate(ctx.queryParam("username"));
		String password = ctx.queryParam("password");
		
		
		if(id != 0 && password.equals(ud.checkPassword(id))) {
			
			ctx.sessionAttribute("loggedIn",true);
			ctx.sessionAttribute("id",id);
			destination = "/RequestsMenu.html";
		
		} else {
			
			destination = "loginFailed.html";
		}
		
		return destination;
		
	}

	public String loginManager(Context ctx) {
		
boolean status = false;
		
		UserDAOImplimentation ud = new UserDAOImplimentation();
		Service s = new Service();
		String destination = "";
		int id = s.validateManager(ctx.queryParam("username"));
		String password = ctx.queryParam("password");
		
		
		if(id != 0 && password.equals(ud.checkPasswordManager(id))) {
			
			ctx.sessionAttribute("loggedIn",true);
			ctx.sessionAttribute("id",id);
			destination = "/RequestsMenuManager.html";
		
		} else {
			
			destination = "loginFailed.html";
		}
		
		return destination;
		
	}

}
