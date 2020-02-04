package com.upgrader.main.discount;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.updgrader.booking.Booking;
import com.updgrader.booking.Booking.BookingBuilder;

public class DiscountsTest {
	private final BookingBuilder builderInstance = Booking.getBuilderInstance();

	@Test
	public void noDiscountApplicableToBooking() {
		Booking booking = builderInstance.withFareClass("T").build();
		assertTrue(OfferCode.NONE.toString().equals(Discounts.applyDiscountTo(booking)));
	}

	@Test
	public void twentyPercentOffOnBookingInClassD() {
		Booking booking = builderInstance.withFareClass("D").build();
		assertTrue(OfferCode.OFFER_20.toString().equals(Discounts.applyDiscountTo(booking)));
	}

}
