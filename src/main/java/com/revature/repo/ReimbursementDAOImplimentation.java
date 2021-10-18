package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Request;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAOImplimentation implements ReimbursementDAO{
	
	
	
	public ReimbursementDAOImplimentation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean submitRequest(Request request) {
		
		boolean status = true;		
		
		try(Connection connection = ConnectionFactory.getConnection()){
			
			String query = "INSERT INTO requests_table(employee_id, request_type, description, amount) VALUES(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, request.getEmployeeId());
			ps.setString(2, request.getRequestType());
			ps.setString(3, request.getDescription());
			ps.setInt(4, request.getAmount());
			
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

		try(Connection connection = ConnectionFactory.getConnection()){
			
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
		
		try(Connection connection = ConnectionFactory.getConnection()){
			
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
		
		try(Connection connection = ConnectionFactory.getConnection()){
			
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
		
		try(Connection connection = ConnectionFactory.getConnection()){
			
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

	@Override
	public List<Request> getAllRequestsByType(String type) {

		List<Request> requestList = new ArrayList<>();

		try(Connection connection = ConnectionFactory.getConnection()){
			
			String query = "SELECT * FROM requests_table WHERE request_type = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, type);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Request r = new Request(rs.getInt("employee_id"), rs.getString("request_approval"), type, rs.getString("description"), rs.getInt("amount"));
				
				requestList.add(r);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return requestList;
	}
	
	
	@Override
	public Request getRequestByType(String type, int employeeId) {

		Request request = new Request();

		try(Connection connection = ConnectionFactory.getConnection()){
			
			String query = "SELECT * FROM requests_table WHERE request_type = ? AND employee_Id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, type);
			ps.setInt(2, employeeId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				request.setEmployeeId(rs.getInt("employee_id")); 
				request.setApproval(rs.getString("request_approval")); 
				request.setRequestType(type);
				request.setDescription(rs.getString("description"));
				request.setAmount(rs.getInt("amount"));
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return request;
	}

	@Override
	public List<Request> getAllRequestsByStatus(String approval) {
		
		List<Request> requestList = new ArrayList<>();

		try(Connection connection = ConnectionFactory.getConnection()){
			
			String query = "SELECT * FROM requests_table WHERE request_approval = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, approval);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Request r = new Request(rs.getInt("employee_id"), approval, rs.getString("request_type"), rs.getString("description"), rs.getInt("amount"));
				
				requestList.add(r);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return requestList;
	}

	

}
