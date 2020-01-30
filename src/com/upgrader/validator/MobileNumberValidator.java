package com.upgrader.validator;

import com.updgrader.booking.Booking;

public class MobileNumberValidator implements Validator {

	@Override
	public void validate(Booking booking) throws ValidationException {
		if(!booking.isMobileNumberValid()) {
			throw new ValidationException("Mobile number invalid");
		}
	}

}
