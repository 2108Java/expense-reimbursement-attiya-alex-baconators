package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class UserDAOImplimentation implements UserDAO {

	public UserDAOImplimentation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addNewUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String checkPassword(int id) {
		
		String password = "";

		try(Connection connection = ConnectionFactory.getConnection()){
			
			String query = "SELECT password_emp FROM employee_login WHERE employee_id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				password = rs.getString("password_emp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

}
