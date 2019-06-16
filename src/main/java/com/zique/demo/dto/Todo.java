package com.zique.demo.dto;

import java.util.Date;

public class Todo {
	
	private long id;
	private String description;
	private String status;
	private Date targetDate;
	
	public Todo(){}
	
	public Todo(long id, String description, String status, Date targetDate) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.targetDate = targetDate;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", status=" + status + ", targetDate=" + targetDate
				+ "]";
	}
	
	

}
