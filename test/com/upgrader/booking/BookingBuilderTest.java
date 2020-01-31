package com.upgrader.booking;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.updgrader.booking.Booking;
import com.updgrader.booking.Booking.BookingBuilder;

public class BookingBuilderTest {

	@Test
	public void buildBookingFromData() {
		BookingBuilder builder = Booking.getBuilderInstance();
		Booking booking = builder.withFirstName("SomeFirstName")
			.withLastName("SomeLastName")
			.withPNR("PNR123")
			.withFareClass("B")
			.forTravelDate("2020-01-01")
			.forPersons("1")
			.withBookingDate("2020-01-01")
			.withMobileNumber("1234567890")
			.withEmail("abc@xyz.com")
			.withCabin("first")
			.build();
		assertTrue("SomeFirstName,SomeLastName,PNR123,B,2020-01-01,1,2020-01-01,abc@xyz.com,1234567890,FIRST"
				.equals(booking.toString()));
			
	}

}
