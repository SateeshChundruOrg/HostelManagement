package com.ateam.hostelmanagement.bean;

public class Payments {
	
	private long paymentId;
	private String actualAmount;
	private String paidAmount;
	private String actualDate;
	private String paidDate;
	private long hostlerId;
	private String hostlerName;
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getActualDate() {
		return actualDate;
	}
	public void setActualDate(String actualDate) {
		this.actualDate = actualDate;
	}
	
	public long getHostlerId() {
		return hostlerId;
	}
	public void setHostlerId(long hostlerId) {
		this.hostlerId = hostlerId;
	}
	public String getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}
	public String getHostlerName() {
		return hostlerName;
	}
	public void setHostlerName(String hostlerName) {
		this.hostlerName = hostlerName;
	}

}
