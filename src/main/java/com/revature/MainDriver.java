package com.revature;

import com.revature.controller.RequestHandler;
import com.revature.models.Request;
import com.revature.repo.ReimbursementDAOImplimentation;

import io.javalin.Javalin;

public class MainDriver {
	
	public static void main(String[] args) {
		
		Javalin app = Javalin.create(config -> config.addStaticFiles(staticFiles -> {staticFiles.directory = "/public";})).start(9000);
 		RequestHandler.defineEndpoints(app);
		
		app.get("/", ctx -> ctx.redirect("/loginPage.html"));
		
//		ReimbursementDAOImplimentation r = new ReimbursementDAOImplimentation();
//		r.removeRequest("test", 1);
		
	}

}
