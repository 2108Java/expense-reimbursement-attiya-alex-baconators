package com.revature;

import com.revature.controller.RequestHandler;

import io.javalin.Javalin;
import org.junit.Test;

@Test
 public class ConnectionTest(Javalin app) {
		
		Javalin app = Javalin.create(config -> config.addStaticFiles(staticFiles -> {staticFiles.directory = "/public";})).start(9000);
 		RequestHandler.defineEndpoints(app);
		
		app.get("/", ctx -> ctx.redirect("/preLogin.html"));
}
