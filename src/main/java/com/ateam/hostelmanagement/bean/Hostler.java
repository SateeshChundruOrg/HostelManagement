package com.ateam.hostelmanagement.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hostler {
	@Id @GeneratedValue
	private long hostlerId;
	private  String name;
	private  String firstName;
	private String lastName;
	private  String age;
	private  String sex;
	private  String qualification;
	private  String dateOfJoining;
	private String mobileNumber;
	private String address;
	private boolean roomAssigned;
	private String actualDate;
	
	
	
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	 public String getActualDate() {
		return actualDate;
	}
	public void setActualDate(String actualDate) {
		this.actualDate = actualDate;
	}
	public boolean isRoomAssigned() {
		return roomAssigned;
	}
	public void setRoomAssigned(boolean roomAssigned) {
		this.roomAssigned = roomAssigned;
	}
	@Override
	public boolean equals(Object obj) {
      if(obj instanceof Hostler){
      	Hostler hostler=(Hostler)obj;
      	return hostler.getHostlerId()==this.getHostlerId();
      }else if(obj instanceof HostlerRoomMapping){
       HostlerRoomMapping hostlerRoomMapping=(HostlerRoomMapping)obj;
       return hostlerRoomMapping.getHostlerId()==this.getHostlerId();
      }
		  return false;
	}

}
