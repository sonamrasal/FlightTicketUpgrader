package com.upgrader.validator;

import com.updgrader.booking.Booking;

public class BookedCabinValidator implements Validator {

	@Override
	public void validate(Booking booking) throws ValidationException {
		if(!booking.isCabinValid()) {
			throw new ValidationException("Invalid cabin category");
		}
	}

}
