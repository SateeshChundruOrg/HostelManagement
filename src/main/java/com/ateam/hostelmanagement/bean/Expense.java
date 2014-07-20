package com.ateam.hostelmanagement.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class Expense {

	
	private long expenseId;
	@NotEmpty(message = "Expence should not be blank.") 
	private String expense;
	@NotEmpty(message = "amount should not be blank.")
	private String amount;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
