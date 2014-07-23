package com.ateam.hostelmanagement.Validators;
import java.util.Date;
import java.util.concurrent.RejectedExecutionException;

import org.apache.commons.validator.routines.DateValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ateam.hostelmanagement.bean.Payments;
import com.ateam.hostelmanagement.util.Api;
@Component
public class PaymentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Payments.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		Payments payments=(Payments)arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"actualAmount","required.actualAmount","actualAmount is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"paidAmount","required.paidAmount","paidAmount is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"actualDate","required.actualDate","actualDate is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"paidDate","required.paidDate","paid date is required");
		if(!Api.isEmptyString(payments.getActualDate())){
			   Date date =DateValidator.getInstance().validate(payments.getActualDate(),"yyyy-MM-dd");
			   if(date==null){
				   errors.rejectValue("actualDate","required.actualDate","Invalid date please enter correct date");
			   }
			}
		if(!Api.isEmptyString(payments.getPaidDate())){
			   Date date =DateValidator.getInstance().validate(payments.getPaidDate(),"yyyy-MM-dd");
			   if(date==null){
				   errors.rejectValue("paidDate","required.paidDate","Invalid date please enter correct date");
			   }
			
	}
	}
}

