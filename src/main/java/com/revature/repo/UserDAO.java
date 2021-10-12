package com.revature.repo;

import com.revature.models.Employee;

public interface UserDAO {

	public boolean addNewUser(Employee employee);
	public boolean registerUser(Employee employee);
	public String checkPassword(int id);
	
}
