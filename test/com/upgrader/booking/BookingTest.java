package com.upgrader.booking;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import com.updgrader.booking.Booking;
import com.updgrader.booking.Booking.BookingBuilder;
import com.updgrader.booking.FareClass;
import com.upgrader.main.discount.FareRange;

public class BookingTest {
	private final BookingBuilder builderInstance = Booking.getBuilderInstance();
	private final FareRange targetFareRange = new FareRange(FareClass.H, FareClass.Z);

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
	
	@Test
	public void fareClassIsWithinGivenFareClassRange() {
		Booking booking = builderInstance.withFareClass("Z").build();
		assertTrue(booking.isFareWithin(targetFareRange));
	}
	
	@Test
	public void fareClassIsNotWithinGivenRange() {
		Booking booking = builderInstance.withFareClass("A").build();
		assertFalse(booking.isFareWithin(targetFareRange));
	}
	
	@Test
	public void ticketBookedForValidCabinClass() {
		Booking booking = builderInstance.withCabin("business").build();
		assertTrue(booking.isCabinValid());
	}
	
	@Test
	public void ticketForForInvalidCabinClass() {
		Booking booking = builderInstance.withCabin("someCabin").build();
		assertFalse(booking.isCabinValid());
	}

}
