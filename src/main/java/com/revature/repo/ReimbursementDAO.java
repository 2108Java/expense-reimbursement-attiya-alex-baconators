package com.revature.repo;

public interface ReimbursementDAO {
	
	//CREATE
	public boolean submitRequest();
	
	//READ
	public boolean checkRequestStatus();
	
	//UPDATE
	public boolean editRequest();
	
	//DELETE
	public boolean removeRequest();
}
