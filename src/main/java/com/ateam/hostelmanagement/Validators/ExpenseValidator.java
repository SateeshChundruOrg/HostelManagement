package com.ateam.hostelmanagement.Validators;

import java.util.Date;

import org.apache.commons.validator.routines.DateValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ateam.hostelmanagement.bean.Expense;
import com.ateam.hostelmanagement.util.Api;
@Component
public class ExpenseValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Expense.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		Expense expense=(Expense)arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"expense","required.expense","expense  is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"amount","required.amount","amount  is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"date","required.date","date  is required");
		if(!Api.isEmptyString(expense.getDate())){
			   Date date =DateValidator.getInstance().validate(expense.getDate(),"yyyy-MM-dd");
			   if(date==null){
				   errors.rejectValue("dateOfJoining","required.dateOfJoining","Invalid date please enter correct date");
			   }
	}

	}}
