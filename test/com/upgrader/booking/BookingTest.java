package com.upgrader.booking;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import com.updgrader.booking.Booking;
import com.updgrader.booking.Booking.BookingBuilder;

public class BookingTest {
	BookingBuilder builderInstance = Booking.getBuilderInstance();

	@Test
	public void bookingMadeInAdvanceOfTravelIsValid() {
		try {
			Booking booking = builderInstance.withBookingDate("2020-01-01").withTravelDate("2020-02-27").build();
			assertTrue(booking.isBookingInAdvanceOfTravel());
		} catch (ParseException e) {
			fail("Exception not expected - valid date format provided");
		}
	}

	@Test
	public void ticketBookingDateCannotBeAfterTravelDate() {
		try {
			Booking booking = builderInstance.withBookingDate("2020-01-01").withTravelDate("2019-02-27").build();
			assertFalse(booking.isBookingInAdvanceOfTravel());
		} catch (ParseException e) {
			fail("Exception not expected - valid date format provided");
		}
	}

}
