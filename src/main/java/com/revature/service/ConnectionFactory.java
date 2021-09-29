package com.revature.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.presentation.Controller;

import io.javalin.Javalin;

public class ConnectionFactory {
	
	String server = null;
	String url = null;
	String username = null;
	String password = null;
	
	public static boolean getConnection(String query) {
		
		boolean status = false;
		
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			status = ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}
	
	public static boolean getConnection(Javalin app) {
		
		boolean status = false;
		
		//put in controller method
		//app.get(null, ctx -> ctx.json(Controller.));
		
		return status;
	}
	
	

}
