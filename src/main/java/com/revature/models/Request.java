package com.revature.models;

public class Request {
	
	private int employeeId;
	private String approval;
	private String requestType;
	private String description;
	private int amount;
//	private String time;
	
	

	public Request(int employeeId, String approval, String requestType, String description, int amount) {
		super();
		this.employeeId = employeeId;
		this.approval = approval;
		this.requestType = requestType;
		this.description = description;
		this.amount = amount;
		//this.time = time;
	}
	
	public Request() {
	super();
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
//	public String getTime() {
//		return time;
//	}
//	public void setTime(String time) {
//		this.time = time;
//	}
	
	@Override
	public String toString() {
		return "Request [employeeId=" + employeeId + ", requestType=" + requestType + ", description=" + description
				+ ", amount=" + amount + "]";
	}
	
	
	
	

}
