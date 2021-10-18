package com.revature;

import junit.framework.TestCase;
import org.junit.Test;

import com.revature.repo.UserDAOImplimentation;
import com.revature.service.Service;

import io.javalin.http.Context;

public class AuthenticatorTest extends TestCase {

	@Test
	public void testLogin(Context ctx) {
		UserDAOImplimentation ud = new UserDAOImplimentation();
		Service s = new Service();
		String destination = "";
		int id = s.validate(ctx.formParam("username"));
		String pass = ctx.formParam("password");
		
		if(id != 0 && pass.equals(ud.checkPassword(id))) {
			
			ctx.sessionAttribute("loggedIn", true);
			ctx.sessionAttribute("id", id);
			destination = "/RequestsMenu.html";
			
		}else {
			
			ctx.sessionAttribute("loggedIn", false);
			destination = "/loginFailed.html";
			
	}
		return destination;
	
}	
