package com.revature.controller;

import javax.servlet.ServletRequest;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class RequestHandler {
	
	public static boolean checkLogin(Context ctx) {
		
		if(ctx.sessionAttribute("loggedIn") != null && (Boolean) ctx.sessionAttribute("LoggedIn") == true) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static void defineEndpoints(Javalin app) {
		
		Authenticator authenticator = new Authenticator();
		
		app.get("/login", ctx -> ctx.redirect(authenticator.login(ctx)));//null will be replaced with an authenticator method
		
		app.get("/", ctx -> ctx.redirect("loginPage.html"));
		
		app.get("/setSession", ctx -> {
			
			ctx.sessionAttribute("user"); //does this need to be implemented for any username?
			
		});
		
		app.get("/invalidateSession", ctx -> {
			
			ctx.consumeSessionAttribute("user");
			
		});
		
		app.get("/RequestsMenu", ctx -> {
			
			if(checkLogin(ctx)) {
				
				//ctx.json(Controller.mainMenu(ctx)); 
				//Add mainMenu method to controller
				
			}
			
		});
		
		app.get("/loginFailed", ctx -> ctx.req.getRequestDispatcher("/loginFailed.html").forward(ctx.req, ctx.res));
		
		app.get("/logout", ctx -> {});
	}

	
}
