package com.upgrader.validator;

import com.updgrader.booking.Booking;

public class EmailValidator implements Validator {

	@Override
	public void validate(Booking booking) throws ValidationException {
		if (!booking.isEmailValid()) {
			throw new ValidationException("Email invalid");
		}
	}

}
