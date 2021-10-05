package com.revature.controller;

import io.javalin.http.Context;

public class Authenticator {
	
	public String login(Context ctx) {
		
		System.out.println(ctx.formParam("username"));
		System.out.println(ctx.formParam("password"));
		String destination = "";
		
		if(ctx.formParam("username").equals("user") && ctx.formParam("password").equals("pass")) {
			
			ctx.sessionAttribute("loggedIn", true);
			destination = "/RequestsMenu";
			
		}else {
			ctx.sessionAttribute("loggedIn", false);
			destination = "/loginFailed";
			
		}
		
		return destination;
		
	}

}
