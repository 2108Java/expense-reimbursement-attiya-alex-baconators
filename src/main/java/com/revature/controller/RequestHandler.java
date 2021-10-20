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
		
		
		app.get("/login", ctx -> {
			
			ctx.redirect(authenticator.login(ctx));
			
		});
		
		app.get("/loginManager", ctx -> {
			
			ctx.redirect(authenticator.loginManager(ctx));
			
		});
		
		app.get("/submitRequest", ctx -> {
			
			if(ctx.sessionAttribute("id") != null) {
				if(ctx.sessionAttribute("loggedIn").equals(true)) {
			
					Request r = new Request();
					
					r.setEmployeeId(Integer.parseInt(ctx.queryParam("employeeId")));
					r.setRequestType(ctx.queryParam("type"));
					r.setDescription(ctx.queryParam("description"));
					r.setAmount(Integer.parseInt(ctx.queryParam("amount")));
					
					if((int) ctx.sessionAttribute("id") == Integer.parseInt(ctx.queryParam("employeeId"))) {
						
						rd.submitRequest(r);
						
						ctx.redirect("/RequestsMenu.html");
					} else {
						
						ctx.redirect("/RequestsMenu.html");
						
					}
						
					
			
				}else {
					ctx.redirect("preLogin.html");
				}
			}else {
				ctx.redirect("preLogin.html");
			}
			
			
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
			
			if(ctx.sessionAttribute("id") != null) {
				if(ctx.sessionAttribute("loggedIn").equals(true)) {
			
				Request r = new Request();
				
				r = rd.getRequestByType(ctx.queryParam("type"), Integer.parseInt(ctx.queryParam("employeeId")));
				
				ctx.html("<head><link rel=\"stylesheet\" href=\"reimbursement.css\">\r\n"
						+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n"
						+ "</head>"
						+ "<body>"
						+ "<div>"
				        + "<h1 class=\"titleBar\">Corporate Reimbursement Services</h1>"
				        + "</div>"
				        + "<div class=\"container\">"
				        + "<div>"
						+ "<table class='table'><thead><tr>"
				        + "<th scope=\"col\">#</th>"
						+ "<th scope=\"col\">Employee Id</th>"
						+ "<th scope=\"col\">Request Approval</th>"
						+ "<th scope=\"col\">Request Type</th>"
						+ "<th scope=\"col\">Request Description</th>"
						+ "<th scope=\"col\">Amount</th></tr></thead>"
						+ "<tbody>"
						+ "<tr><th scope=\"row\">1</th>\""
						+ "<td>" + r.getEmployeeId() + "</td>"
						+ "<td>" + r.getApproval() + "</td>"
						+ "<td>" + r.getRequestType() + "</td>"
						+ "<td>" + r.getDescription() + "</td>"
						+ "<td>" + r.getAmount() + "</td>"
						+ "</tr></table>"
						+ "</tbody>"
						+ "</table>"
						+ "<br>"
						+ "<div>"
						+ "<form>"
						+ "<button type='button' class='btn btn-dark' id='returnAllStatus'>Return to Requests Menu</button>"
						+ "</form>"
						+ "</div>"
						+ "</div></div>"
						+ "<script src=\"Request.js\"></script>"
						+ "</body>");
				}else {
					ctx.redirect("preLogin.html");
				}
			}else {
				ctx.redirect("preLogin.html");
			}
			
				
		});
		
		app.get("/getAllRequestsType", ctx -> {
			
			if(ctx.sessionAttribute("id") != null) {
				if(ctx.sessionAttribute("loggedIn").equals(true)) {
			
					List<Request> rl = new ArrayList<>();
					
					String table = "";
					
					rl = rd.getAllRequestsByType(ctx.queryParam("type"));						
					
					Request r = new Request();
					
					
					for(int i=0; i<rl.size(); i++) {
						
						r = rl.get(i);
						
						table += "<tr><th scope=\"row\">" + (i+1) + "</th>"
						+ "<td>" + r.getEmployeeId() + "</td>"
						+ "<td>" + r.getApproval() + "</td>"
						+ "<td>" + r.getRequestType() + "</td>"
						+ "<td>" + r.getDescription() + "</td>"
						+ "<td>" + r.getAmount() + "</td>"
						+ "</tr>";
					
								
					}
					
					ctx.html("<head><link rel=\"stylesheet\" href=\"reimbursement.css\">\r\n"
							+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n"
							+ "</head>"
							+ "<body>"
							+ "<div>"
					        + "<h1 class=\"titleBar\">Corporate Reimbursement Services</h1>"
					        + "</div>"
					        + "<div class=\"container\">"
					        + "<div>"
							+ "<table class='table'><thead><tr>"
					        + "<th scope=\"col\">#</th>"
							+ "<th scope=\"col\">Employee Id</th>"
							+ "<th scope=\"col\">Request Approval</th>"
							+ "<th scope=\"col\">Request Type</th>"
							+ "<th scope=\"col\">Request Description</th>"
							+ "<th scope=\"col\">Amount</th></tr></thead>"
							+ "<tbody>"
							+ table
							+ "</tbody>"
							+ "</table>"
							+ "<br>"
							+ "<div>"
							+ "<form>"
							+ "<button type='button' class='btn btn-dark' id='returnAllStatus'>Return to Requests Menu</button>"
							+ "</form>"
							+ "</div>"
							+ "</div></div>"
							+ "<script src=\"getAllStatus.js\"></script>"
							+ "</body>");
					
				}else {
					ctx.redirect("preLogin.html");
				}
			}else {
				ctx.redirect("preLogin.html");
			}
			
			
		});
		
		app.get("/getAllRequestsStatus", ctx -> {
			
			if(ctx.sessionAttribute("id") != null) {
				if(ctx.sessionAttribute("loggedIn").equals(true)) {
			
					List<Request> rl = new ArrayList<>();
					
					String table = "";
					
					rl = rd.getAllRequestsByStatus(ctx.queryParam("status"));
					
					Request r = new Request();
					
					
					for(int i=0; i<rl.size(); i++) {
						
						r = rl.get(i);
						
						table += "<tr><th scope=\"row\">" + (i+1) + "</th>"
						+ "<td>" + r.getEmployeeId() + "</td>"
						+ "<td>" + r.getApproval() + "</td>"
						+ "<td>" + r.getRequestType() + "</td>"
						+ "<td>" + r.getDescription() + "</td>"
						+ "<td>" + r.getAmount() + "</td>"
						+ "</tr>";
					
								
					}
					
					ctx.html("<head><link rel=\"stylesheet\" href=\"reimbursement.css\">\r\n"
							+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n"
							+ "</head>"
							+ "<body>"
							+ "<div>"
					        + "<h1 class=\"titleBar\">Corporate Reimbursement Services</h1>"
					        + "</div>"
					        + "<div class=\"container\">"
					        + "<div>"
							+ "<table class='table'><thead><tr>"
					        + "<th scope=\"col\">#</th>"
							+ "<th scope=\"col\">Employee Id</th>"
							+ "<th scope=\"col\">Request Approval</th>"
							+ "<th scope=\"col\">Request Type</th>"
							+ "<th scope=\"col\">Request Description</th>"
							+ "<th scope=\"col\">Amount</th></tr></thead>"
							+ "<tbody>"
							+ table
							+ "</tbody>"
							+ "</table>"
							+ "<br>"
							+ "<div>"
							+ "<form>"
							+ "<button type='button' class='btn btn-dark' id='returnAllStatus'>Return to Requests Menu</button>"
							+ "</form>"
							+ "</div>"
							+ "</div></div>"
							+ "<script src=\"getAllStatus.js\"></script>"
							+ "</body>");
			
				}else {
					ctx.redirect("preLogin.html");
				}
			}else {
				ctx.redirect("preLogin.html");
			}
			
		});
		
		app.get("/removeRequest", ctx -> {
						
			if(ctx.sessionAttribute("id") != null) {
				if(ctx.sessionAttribute("loggedIn").equals(true)) {
					if((int) ctx.sessionAttribute("id") == Integer.parseInt(ctx.queryParam("employeeId"))) {
						
						rd.removeRequest(ctx.queryParam("type"), Integer.parseInt(ctx.queryParam("employeeId")));
			
						ctx.redirect("/RequestsMenu.html");


					} else {
						
						ctx.redirect("/RequestsMenu.html");
						
					}
					
				}else {
					ctx.redirect("preLogin.html");
				}
			}else {
				ctx.redirect("preLogin.html");
			}
			

		});
		
		app.get("/approveRequest", ctx -> {
			if(ctx.sessionAttribute("id") != null) {
				if(ctx.sessionAttribute("loggedIn").equals(true)) {
					
					rd.approveRequest(ctx.queryParam("type"), Integer.parseInt(ctx.queryParam("employeeId")));
		
					ctx.redirect("/RequestsMenuManager.html");
					
				}else {
					ctx.redirect("preLogin.html");
				}
			}else {
				ctx.redirect("preLogin.html");
			}
			
			
		});
		
		app.get("/rejectRequest", ctx -> {
			if(ctx.sessionAttribute("id") != null) {
				if(ctx.sessionAttribute("loggedIn").equals(true)) {
					
					rd.rejectRequest(ctx.queryParam("type"), Integer.parseInt(ctx.queryParam("employeeId")));
		
					ctx.redirect("/RequestsMenuManager.html");
					
				}else {
					ctx.redirect("preLogin.html");
				}
			}else {
				ctx.redirect("preLogin.html");
			}
			
			
		});
		
		app.get("/logout", ctx -> {
			
			ctx.consumeSessionAttribute("loggedIn");
		
			ctx.redirect("preLogin.html");
			
		});

	}

	
}