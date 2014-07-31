package com.ateam.hostelmanagement.bean;

public class RoomSearch {
	private long roomId;
	private  String roomNumber;
	private  String noOfBeds;
	private String hostelId;
	private String hostelName;
	private String availableBeds;
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(String noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	public String getHostelId() {
		return hostelId;
	}
	public void setHostelId(String hostelId) {
		this.hostelId = hostelId;
	}
	public String getHostelName() {
		return hostelName;
	}
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}
	public String getAvailableBeds() {
		return availableBeds;
	}
	public void setAvailableBeds(String availableBeds) {
		this.availableBeds = availableBeds;
	}
	

}
