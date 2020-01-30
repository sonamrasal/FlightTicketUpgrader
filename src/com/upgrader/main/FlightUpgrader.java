package com.upgrader.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.updgrader.booking.Booking;
import com.upgrader.reader.Reader;
import com.upgrader.validator.ValidationException;
import com.upgrader.validator.Validator;

public class FlightUpgrader {
	
	private Reader reader;
	private Validator validator;
	List<Booking> processedBookings;
	List<Booking> faultyBookings;

	public FlightUpgrader(Reader reader, Validator validator) {
		this.reader = reader;
		this.validator = validator;
		processedBookings = new ArrayList<Booking>();
		faultyBookings = new ArrayList<Booking>();
	}
	
	public void processBookingInformation(String fileName) throws IOException {
		List<Booking> bookingInformation = reader.read(fileName);
		bookingInformation.stream().forEach(booking -> {
			try {
				validator.validate(booking);
				processedBookings.add(booking);
			} catch (ValidationException e) {
				faultyBookings.add(booking);
			}
		});
	}
}
