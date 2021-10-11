package com.revature.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Request;
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
		
		app.get("/", ctx -> {
			HttpServletRequest request = ctx.req;
			HttpServletResponse response = ctx.res;
			
			RequestDispatcher reqDispatcher = ctx.req.getRequestDispatcher("/loginPage.html");
			
			reqDispatcher.forward(request, response);
		});
		
		app.get("/login", ctx -> ctx.redirect(authenticator.login(ctx)));
		
		app.get("/", ctx -> ctx.req.getRequestDispatcher("/loginPage.html").forward(ctx.req, ctx.res));
				
		app.get("/logout", ctx -> ctx.redirect("/loginPage.html"));
		
//		app.get("/getRequests", ctx -> ctx.json(rd.))
		
		app.get("/checkStatus", ctx -> {
			
			if(checkLogin(ctx)) {
				ctx.json(controller.checkRequestStatus(ctx));
			}else {
				ctx.redirect("/loginPage.html");
			}
		});
		
		app.post("/invalidateSession", ctx -> {
			
			ctx.consumeSessionAttribute("user");
			ctx.redirect("/loginPage");
			
		});
		
		app.get("/submitRequest", ctx -> {
			
			if(checkLogin(ctx)) {
				Request r = new Request(Integer.parseInt(ctx.queryParam("employeeId")), 
						Boolean.parseBoolean(ctx.queryParam("approval")), 
						ctx.queryParam("requestType"), ctx.queryParam("description"), 
						Integer.parseInt(ctx.queryParam("amount")));
				
				rd.submitRequest(r);
			} else {
				ctx.redirect("/loginPage.html");
			}
		});
		
		app.get("/editRequestType", ctx -> {
			
			if(checkLogin(ctx)) {
				
				String typeOrigin = ctx.queryParam("typeOrigin");
				String typeTarget = ctx.queryParam("typeTarget");
				int id = Integer.parseInt(ctx.queryParam("id"));
				
				ctx.json(rd.editRequestType(typeOrigin, typeTarget, id));
				
			}else {
				ctx.redirect("/loginPage.html");
			}
			
		});
		
		app.get("/editRequestDescription", ctx -> {
			
			if(checkLogin(ctx)) {
				
				String newDescription = ctx.queryParam("newDescription");
				String typeTarget = ctx.queryParam("typeTarget");
				int id = Integer.parseInt(ctx.queryParam("id"));
				
				ctx.json(rd.editRequestType(newDescription, typeTarget, id));
				
			}else {
				ctx.redirect("/loginPage.html");
			}
			
		});
		

	}

	
}
