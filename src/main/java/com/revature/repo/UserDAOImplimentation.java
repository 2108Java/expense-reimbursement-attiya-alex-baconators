package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

public class UserDAOImplimentation implements UserDAO {

	public UserDAOImplimentation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addNewUser(Employee employee) {
		
		Boolean status = false;

		try(Connection connection = ConnectionFactory.getConnection()){
			
			String query = "INSERT INTO employee_table(firstname, lastname, department, outstanding_expenses) VALUES (?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, employee.getFirstname());
			ps.setString(2, employee.getLastname());
			ps.setString(3, employee.getDepartment());
			ps.setFloat(4, employee.getOutstandingExpenses());
			
			status = ps.execute();
			
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
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

	@Override
	public boolean registerUser(Employee employee) {
		
		Boolean status = false;

		try(Connection connection = ConnectionFactory.getConnection()){
			
			String query = "INSERT INTO employee_table(firstname, lastname, address, city, state, zip, username, password) VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, employee.getFirstname());
			ps.setString(2, employee.getLastname());
			ps.setString(3, employee.getAddress());
			ps.setString(4, employee.getDepartment());//added department
			ps.setString(5, employee.getCity());
			ps.setString(6, employee.getState());
			ps.setInt(7, employee.getZip());
			ps.setString(8, employee.getUsername());
			ps.setString(9, employee.getPassword());
			
			status = ps.execute();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
