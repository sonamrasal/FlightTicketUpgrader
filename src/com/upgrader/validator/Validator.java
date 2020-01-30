package com.upgrader.validator;

import com.updgrader.booking.Booking;

public interface Validator {

	void validate(Booking booking) throws ValidationException;

}