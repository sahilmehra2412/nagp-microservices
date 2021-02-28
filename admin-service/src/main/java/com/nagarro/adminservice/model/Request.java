package com.nagarro.adminservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Request {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String service_requested;
	
	@Column
	private String requested_by;
	
	@Column 
	private Date requested_on;
	
	@Column
	private Date completed_on;
	
	@Column
	private Date completed_by;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getService_requested() {
		return service_requested;
	}

	public void setService_requested(String service_requested) {
		this.service_requested = service_requested;
	}

	public String getRequested_by() {
		return requested_by;
	}

	public void setRequested_by(String requested_by) {
		this.requested_by = requested_by;
	}

	public Date getRequested_on() {
		return requested_on;
	}

	public void setRequested_on(Date requested_on) {
		this.requested_on = requested_on;
	}

	public Date getCompleted_on() {
		return completed_on;
	}

	public void setCompleted_on(Date completed_on) {
		this.completed_on = completed_on;
	}

	public Date getCompleted_by() {
		return completed_by;
	}

	public void setCompleted_by(Date completed_by) {
		this.completed_by = completed_by;
	}

}
