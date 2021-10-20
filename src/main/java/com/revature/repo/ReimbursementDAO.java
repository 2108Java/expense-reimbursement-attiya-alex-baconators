package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Request;

public interface ReimbursementDAO {
	
	public boolean submitRequest(Request request);
	
	public boolean checkRequestStatus(String type, int employeeId);
	
	public boolean removeRequest(String type, int employeeId);
	
	public List<Request> getAllRequestsByType(String type);
	
	public List<Request> getAllRequestsByStatus(String approval);

	public Request getRequestByType(String type, int employeeId);

	boolean approveRequest(String type, int employeeId);

	boolean rejectRequest(String type, int employeeId);
}
