package com.revature.presentation;

import io.javalin.Javalin;

public class RequestHandler {

	public static boolean getConnectionFront(Javalin app) {
		
		boolean status = false;
		Controller controller = new Controller();
		
		//put in controller method
		//app.get(null, ctx -> ctx.json(controller.));
		
		return status;
	}

}
