package com.revature.repo;

import java.util.ArrayList;

public interface ReimbursementDAO {
	
	//CREATE
	public boolean submitRequest(ArrayList<Object> values);
	
	//READ
	public boolean checkRequestStatus(String type, int employeeId);
	
	//UPDATE
	public boolean editRequestType(String typeOrigin, String typeTarget, int employeeId);
	
	public boolean editRequestDescription(String newDescription, String type, int employeeId);
	
	//DELETE
	public boolean removeRequest(String type, int employeeId);
}
