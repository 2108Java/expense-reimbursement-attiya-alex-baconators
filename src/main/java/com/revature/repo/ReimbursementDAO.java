package com.revature.repo;

public interface ReimbursementDAO {

	public boolean submitRequest();
	public boolean checkRequestStatus();
	public boolean editRequest();
	public boolean removeRequest();
}
