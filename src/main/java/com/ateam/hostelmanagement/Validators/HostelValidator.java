package com.ateam.hostelmanagement.Validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ateam.hostelmanagement.bean.Hostel;

public class HostelValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Hostel.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		
		Hostel hostel=(Hostel)arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hostelNmae","required.hostelName","hostelName is mandatory" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hostelAddress","required.hostelAddress","hostelAddress is mandatory" );
	}

}
