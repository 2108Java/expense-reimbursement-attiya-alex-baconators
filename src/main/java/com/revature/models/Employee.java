package com.revature.models;

public class Employee {
	
	private int employeeId;
	private String firstname;
	private String lastname;
	private String department;
	private float outstandingExpenses;
	
	private String address;
	private String city;
	private String state;
	private int zip;
	private String username;
	private String password;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String firstname, String lastname, String department, float outstandingExpenses) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		this.outstandingExpenses = outstandingExpenses;
	}

	public Employee(int employeeId, String firstname, String lastname, String address, String city, String state,
			int zip, String username, String password) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.username = username;
		this.password = password;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public float getOutstandingExpenses() {
		return outstandingExpenses;
	}
	public void setOutstandingExpenses(float outstandingExpenses) {
		this.outstandingExpenses = outstandingExpenses;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", department=" + department + ", outstandingExpenses=" + outstandingExpenses + ", address=" 
				+ address + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", username=" + username + ", password=" + password + "]";
	}
	
	

}