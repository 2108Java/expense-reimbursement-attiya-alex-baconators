package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReimbursementDAOImplimentation implements ReimbursementDAO{

	private static String server = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	public ReimbursementDAOImplimentation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean submitRequest(ArrayList<Object> values) {
		
		boolean status = true;
		int employeeId = (int) values.get(0);
		String requestType = (String) values.get(1);
		String description = (String) values.get(2);
		int amount = (int) values.get(3);
		
		
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			String query = "INSERT INTO requests_table(employee_id, request_type, description, amount) VALUES(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, employeeId);
			ps.setString(2, requestType);
			ps.setString(3, description);
			ps.setInt(4, amount);
			
			status = ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public boolean checkRequestStatus(String type, int employeeId) {
		
		boolean status = false;

		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			String query = "SELECT request_approval FROM requests_table WHERE employee_id = ? AND request_type = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, employeeId);
			ps.setString(2, type);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				status = rs.getBoolean("request_approval");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public boolean editRequestType(String typeOrigin, String typeTarget, int employeeId) {
		
		boolean status = false;
		
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			String query = "UPDATE requests_table SET request_type = ? WHERE employee_id = ? AND request_type = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, typeTarget);
			ps.setInt(2, employeeId);
			ps.setString(3, typeOrigin);
			
			status = ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	@Override
	public boolean editRequestDescription(String newDescription, String type, int employeeId) {

		boolean status = false;
		
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			String query = "UPDATE requests_table SET description = ? WHERE employee_id = ? AND request_type = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, newDescription);
			ps.setInt(2, employeeId);
			ps.setString(3, type);
			
			status = ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	@Override
	public boolean removeRequest(String type, int employeeId) {

		boolean status = false;
		
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			String query = "DELETE FROM requests_table WHERE employee_id = ? AND request_type = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, employeeId);
			ps.setString(2, type);
			
			status = ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	

}
