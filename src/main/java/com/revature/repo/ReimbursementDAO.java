package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Request;

public interface ReimbursementDAO {
	
	public boolean submitRequest(Request request);
	
	public boolean checkRequestStatus(String type, int employeeId);

	public boolean editRequestType(String typeOrigin, String typeTarget, int employeeId);
	
	public boolean editRequestDescription(String newDescription, String type, int employeeId);
	
	public boolean removeRequest(String type, int employeeId);
	
	public List<Request> getAllRequestsByType(String type);
}
