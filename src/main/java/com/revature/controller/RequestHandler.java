package com.revature.controller;

import javax.servlet.ServletRequest;
import io.javalin.Javalin;

public class RequestHandler {
	
	public static void defineEndpoints(Javalin app) {
		app.get("/login", null);//null will be replaced with an authenticator method
		
		app.get("/", ctx -> ctx.redirect("loginPage.html"));
	}

	
}
