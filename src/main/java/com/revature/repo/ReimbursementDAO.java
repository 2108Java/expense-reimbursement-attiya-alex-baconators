package com.revature.repo;

import java.util.ArrayList;

public interface ReimbursementDAO {
	
	public boolean submitRequest(ArrayList<Object> values);
	
	public boolean checkRequestStatus(String type, int employeeId);

	public boolean editRequestType(String typeOrigin, String typeTarget, int employeeId);
	
	public boolean editRequestDescription(String newDescription, String type, int employeeId);
	
	public boolean removeRequest(String type, int employeeId);
}
