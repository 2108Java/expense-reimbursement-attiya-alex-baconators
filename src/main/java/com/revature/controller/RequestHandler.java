package com.revature.controller;

import javax.servlet.ServletRequest;

import com.revature.repo.ReimbursementDAOImplimentation;

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
		ReimbursementDAOImplimentation rd = new ReimbursementDAOImplimentation();
		Controller controller = new Controller();
		
		app.get("/login", ctx -> ctx.redirect(authenticator.login(ctx)));
		
		//app.get("/", ctx -> ctx.req.getRequestDispatcher("/loginPage.html").forward(ctx.req, ctx.res));
				
		app.get("/logout", ctx -> ctx.redirect("/loginPage.html"));
		
		//app.get("/getRequests", ctx -> ctx.json(rd.))
		
		app.get("/checkStatus", ctx -> ctx.json(controller.checkRequestStatus(ctx)));
	}

	
}
