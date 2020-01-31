package com.upgrader.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.updgrader.booking.Booking;
import com.upgrader.main.discount.Discounts;
import com.upgrader.reader.Reader;
import com.upgrader.validator.ValidationException;
import com.upgrader.validator.Validator;

public class FlightInfoProcessor {

	private final Reader reader;
	private final Validator validator;
	private List<ProcessingInformation> processingInformation;

	public FlightInfoProcessor(Reader reader, Validator validator) {
		this.reader = reader;
		this.validator = validator;
		processingInformation = new ArrayList<ProcessingInformation>();
	}

	public List<ProcessingInformation> processBookingInformation(String fileName) throws IOException {
		List<Booking> bookingInformation = reader.read(fileName);
		bookingInformation.stream().forEach(booking -> {
			try {
				validator.validate(booking);
				processingInformation.add(new ValidBooking(booking, Discounts.applyDiscountTo(booking)));
			} catch (ValidationException e) {
				processingInformation.add(new FaultyBooking(booking, e.toString()));
			}
		});
		return processingInformation;
	}
}
