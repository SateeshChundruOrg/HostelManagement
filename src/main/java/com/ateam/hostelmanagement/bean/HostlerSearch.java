package com.ateam.hostelmanagement.bean;

public class HostlerSearch {
	private long hostlerId;
	private  String name;
	private  String firstName;
	private String lastName;
	private String mobileNumber;
	public long getHostlerId() {
		return hostlerId;
	}
	public void setHostlerId(long hostlerId) {
		this.hostlerId = hostlerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	private  String dateOfJoining;
	}
