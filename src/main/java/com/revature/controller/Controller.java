package com.revature.controller;

import io.javalin.http.Context;
import io.javalin.Javalin;

public class Controller implements ControllerInterface{

	public boolean connect() {
		// TODO Auto-generated method stub
	
		return false;
	}
	
	public String authenticateLogin(Context ctx) {
		// TODO Auto-generated method stub
		System.out.println(ctx.queryParam("username"));
		System.out.println(ctx.queryParam("password"));
		String page = "";
		if(ctx.queryParam("username").equals("user") && ctx.queryParam("password").equals("p4ss")){
					page = "loginPage.html";
				}else {
					page = "failedLogin.html";
				}
		
		return page;
	}

}