package com.ateam.hostelmanagement.Validators;
import java.util.Date;

import org.apache.commons.validator.routines.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ateam.hostelmanagement.bean.Hostler;
import com.ateam.hostelmanagement.util.Api;
@Component
public class HostlerValidator implements Validator 
{

	@Override
	public boolean supports(Class<?> arg0) {
			return Hostler.class.isAssignableFrom(arg0);
	}

	
	@Override
	public void validate(Object arg0, Errors errors) {
	Hostler hostler=(Hostler)arg0;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","required.name","name is mandatory");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfJoining","required.dateOfJoining","date is required");	
	ValidationUtils.rejectIfEmptyOrWhitespace(errors,"mobileNumber","required.mobileNumber","number is required");
	if(!Api.isEmptyString(hostler.getDateOfJoining())){
	   Date date =DateValidator.getInstance().validate(hostler.getDateOfJoining(),"yyyy-MM-dd");
	   if(date==null){
		   errors.rejectValue("dateOfJoining","required.dateOfJoining","Invalid date please enter correct date");
	   }
	   if(!Api.isEmptyString(hostler.getMobileNumber())){
		   if(hostler.getMobileNumber().length()!=10){
			   errors.rejectValue("mobileNumber","required.mobileNumber","must be 10 digit");
		   }
	   }
	}
	}
}
