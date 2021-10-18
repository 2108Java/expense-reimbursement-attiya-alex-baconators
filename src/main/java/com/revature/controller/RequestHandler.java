package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.repo.ReimbursementDAOImplimentation;
import com.revature.repo.UserDAOImplimentation;

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
		
//		app.get("/", ctx -> {
//			HttpServletRequest request = ctx.req;
//			HttpServletResponse response = ctx.res;
//			
//			RequestDispatcher reqDispatcher = ctx.req.getRequestDispatcher("/loginPage.html");
//			
//			reqDispatcher.forward(request, response);
//		});
//		
		app.get("/login", ctx -> {
			
			String username = ctx.queryParam("username");
			String password = ctx.queryParam("password");
			
			System.out.println(username);
			System.out.println(password);
			
			boolean loggedIn = authenticator.login(username, password);
			
			if(loggedIn) {
				ctx.redirect("/RequestsMenu.html");
			} else {
				ctx.redirect("loginFailed.html");
			}
			
		});
		
		app.get("/loginManager", ctx -> {
			
			String username = ctx.queryParam("username");
			String password = ctx.queryParam("password");
			
			System.out.println(username);
			System.out.println(password);
			
			boolean loggedIn = authenticator.login(username, password);
			
			if(loggedIn) {
				ctx.redirect("/RequestsMenuManager.html");
			} else {
				ctx.redirect("preLogin.html");
			}
			
		});
		
		
//		
//		app.get("/", ctx -> ctx.req.getRequestDispatcher("/loginPage.html").forward(ctx.req, ctx.res));
//				
//		app.get("/logout", ctx -> ctx.redirect("/loginPage.html"));
//		
////		app.get("/getRequests", ctx -> ctx.json(rd.))
//		
//		app.get("/checkStatus", ctx -> {
//			
//			if(checkLogin(ctx)) {
//				ctx.json(controller.checkRequestStatus(ctx));
//				ctx.status(204);
//			}else {
//				ctx.status(403);
//				ctx.redirect("/loginPage.html");
//			}
//		});
//		
//		app.post("/invalidateSession", ctx -> {
//			
//			ctx.consumeSessionAttribute("user");
//			ctx.redirect("/loginPage");
//			
//		});
		
		app.get("/submitRequest", ctx -> {
			
			Request r = new Request();
			
			r.setEmployeeId(Integer.parseInt(ctx.queryParam("employeeId")));
			r.setRequestType(ctx.queryParam("type"));
			r.setDescription(ctx.queryParam("description"));
			r.setAmount(Integer.parseInt(ctx.queryParam("amount")));
		
			rd.submitRequest(r);	
			
			ctx.redirect("/RequestsMenu.html");
			
		});
		
		app.get("/addNewUser", ctx -> {
			
			UserDAOImplimentation ud = new UserDAOImplimentation();
			
			Employee employee = new Employee(Integer.parseInt(ctx.queryParam("employeeId")),
					ctx.queryParam("firstname"), ctx.queryParam("lastname"), 
					ctx.queryParam("department"), Float.parseFloat(ctx.queryParam("outstandingExpenses")));
			
			ud.addNewUser(employee);
			
		});
		
		app.get("/registerUser", ctx -> {
			
			UserDAOImplimentation ud = new UserDAOImplimentation();
			
			Employee employee = new Employee(Integer.parseInt(ctx.queryParam("employeeId")), 
					ctx.queryParam("firstname"), ctx.queryParam("lastname"), ctx.queryParam("address"), 
					ctx.queryParam("city"), ctx.queryParam("state"), Integer.parseInt(ctx.queryParam("zip")), 
					ctx.queryParam("username"), ctx.queryParam("password"));
			
			ud.registerUser(employee);
			
			ctx.redirect("preLogin.html");
			
		});
		
		app.get("/getRequest", ctx -> {
			
			Request r = new Request();
			
			r = rd.getRequestByType(ctx.queryParam("type"), Integer.parseInt(ctx.queryParam("employeeId")));
			
			
			//ctx.json(r);
			
			ctx.html("<head><style>table,th,tr,td { border: 1px solid black;}</style></head>"
					+ "<body>"
					+ "<table><tr>"
					+ "<th>Employee Id</th>"
					+ "<th>Request Approval</th>"
					+ "<th>Request Type</th>"
					+ "<th>Request Description</th>"
					+ "<th>Amount</th>"
					+ "</tr>"
					+ "<tr>"
					+ "<td>" + r.getEmployeeId() + "</td>"
					+ "<td>" + r.getApproval() + "</td>"
					+ "<td>" + r.getRequestType() + "</td>"
					+ "<td>" + r.getDescription() + "</td>"
					+ "<td>" + r.getAmount() + "</td>"
					+ "</tr></table>"
					+ "<div>"
					+ "<form>"
					+ "<button type='button' class='btn btn-primary' id='return'>Return to Requests Menu</button>"
					+ "</form>"
					+ "</div>"
					+ "<script src='get.js'></script>"
					+ "</body>");
				
		});
		
		app.get("/getAllRequests", ctx -> {
			
			List<Request> rl = new ArrayList<>();
			String table = "";
			
			rl = rd.getAllRequestsByType(ctx.queryParam("type"));						
			
			for(Request r : rl) {
				
				table += "</tr>"
				+ "<tr>"
				+ "<td>" + r.getEmployeeId() + "</td>"
				+ "<td>" + r.getApproval() + "</td>"
				+ "<td>" + r.getRequestType() + "</td>"
				+ "<td>" + r.getDescription() + "</td>"
				+ "<td>" + r.getAmount() + "</td>"
				+ "</tr>";
						
			}
			
			ctx.html("<head><style>table,th,tr,td { border: 1px solid black;}</style></head>"
					+ "<body>"
					+ "<table><tr>"
					+ "<th>Employee Id</th>"
					+ "<th>Request Approval</th>"
					+ "<th>Request Type</th>"
					+ "<th>Request Description</th>"
					+ "<th>Amount</th>"
					+ table
					+ "</table>"
					+ "<div>"
					+ "<form>"
					+ "<button type='button' class='btn btn-primary' id='returnAll'>Return to Requests Menu</button>"
					+ "</form>"
					+ "</div>"
					+ "<script src='getAll.js'></script>"
					+ "</body>");
			
			
			
			
			
		});
		
		app.get("/getAllRequestsStatus", ctx -> {
			
			List<Request> rl = new ArrayList<>();
			String table = "";
			
			rl = rd.getAllRequestsByStatus(ctx.queryParam("status"));						
			
			for(Request r : rl) {
				
				table += "</tr>"
				+ "<tr>"
				+ "<td>" + r.getEmployeeId() + "</td>"
				+ "<td>" + r.getApproval() + "</td>"
				+ "<td>" + r.getRequestType() + "</td>"
				+ "<td>" + r.getDescription() + "</td>"
				+ "<td>" + r.getAmount() + "</td>"
				+ "</tr>";
						
			}
			
			ctx.html("<head><style>table,th,tr,td { border: 1px solid black;}</style></head>"
					+ "<body>"
					+ "<table><tr>"
					+ "<th>Employee Id</th>"
					+ "<th>Request Approval</th>"
					+ "<th>Request Type</th>"
					+ "<th>Request Description</th>"
					+ "<th>Amount</th>"
					+ table
					+ "</table>"
					+ "<div>"
					+ "<form>"
					+ "<button type='button' class='btn btn-primary' id='returnAllStatus'>Return to Requests Menu</button>"
					+ "</form>"
					+ "</div>"
					+ "<script src='getAllStatus.js'></script>"
					+ "</body>");
			
			
			
			
			
		});
		
		app.get("/removeRequest", ctx -> {
			
			rd.removeRequest(ctx.queryParam("type"), Integer.parseInt(ctx.queryParam("employeeId")));
			
			ctx.redirect("/RequestsMenu.html");
			
		});

	}

	
}