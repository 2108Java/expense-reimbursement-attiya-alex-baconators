package com.revature.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.presentation.Controller;

import io.javalin.Javalin;

public class ConnectionFactory {
	
	private static String server = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
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

}
