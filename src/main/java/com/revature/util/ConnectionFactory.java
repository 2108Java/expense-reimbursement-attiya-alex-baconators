package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private String username = "postgres";
	private String password = "@kljeo88";
	private String url = "jdbc:postgresql://localhost/postgres";
	
	public Connection getConnection() throws SQLException{
		Connection connection = DriverManager.getConnection(url,username,password);
		return connection;
	}
}
