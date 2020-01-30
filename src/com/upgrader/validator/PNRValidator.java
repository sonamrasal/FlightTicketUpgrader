package com.upgrader.validator;

import com.updgrader.booking.Booking;

public class PNRValidator implements Validator {

	@Override
	public void validate(Booking booking) throws ValidationException {
		if(!booking.isPNRValid()) {
			throw new ValidationException("PNR Invalid");
		}
	}

}
