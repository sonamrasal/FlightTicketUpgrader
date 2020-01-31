package com.upgrader.main;

import com.updgrader.booking.Booking;

public class ProcessingFailure implements ProcessingInformation {

	private final Booking booking;
	private final String cause;

	public ProcessingFailure(Booking booking, String cause) {
		this.booking = booking;
		this.cause = cause;
	}
	
	@Override
	public String toString() {
		return booking.toString() + "," + cause;
	}

	@Override
	public boolean isBookingFaulty() {
		return true;
	}

}
