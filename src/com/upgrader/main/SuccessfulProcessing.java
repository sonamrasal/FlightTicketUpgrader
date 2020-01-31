package com.upgrader.main;

import com.updgrader.booking.Booking;

public class SuccessfulProcessing implements ProcessingInformation {

	private Booking booking;
	private String offerCode;

	public SuccessfulProcessing(Booking booking, String offerCode) {
		this.booking = booking;
		this.offerCode = offerCode;
	}

	@Override
	public boolean isBookingFaulty() {
		return false;
	}
	
	@Override
	public String toString() {
		return booking.toString() + "," + offerCode;
	}

}
