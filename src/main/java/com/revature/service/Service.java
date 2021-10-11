package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class Service implements UserService{

	@Override
	public int validate(String username) {
		
		int id = 0;
		
		try(Connection connection = ConnectionFactory.getConnection()){
			
			String query = "SELECT employee_id FROM employee_login WHERE username_emp = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, username);
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt("employee_id");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

}
