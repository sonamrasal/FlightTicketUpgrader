package com.upgrader.validator;

import java.text.ParseException;

import com.updgrader.booking.Booking;

public class BookingDateValidator implements Validator {

	@Override
	public void validate(Booking booking) throws ValidationException {
		try {
			if (!booking.isBookingInAdvanceOfTravel()) {
				throw new ValidationException("Ticketing date should be before travel date");
			}
		} catch (ParseException e) {
			throw new ValidationException("Error parsing dates");
		}
	}

}
