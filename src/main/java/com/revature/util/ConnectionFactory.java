package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private String username = "postgres";
	private String password = "Sixfourteen614";
	private String url = "reimbursementdatabase.cxsi6hkq9t16.us-east-2.rds.amazonaws.com";
	
	public Connection getConnection() throws SQLException{
		Connection connection = DriverManager.getConnection(url,username,password);
		return connection;
	}
}
