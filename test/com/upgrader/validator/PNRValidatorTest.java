package com.upgrader.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.updgrader.booking.Booking;

public class PNRValidatorTest {

	private PNRValidator validator = new PNRValidator();
	private Booking.BookingBuilder builder = Booking.getBuilderInstance();

	@Test
	public void lengthOfPNRIsSix() {
		try {
			validator.validate(builder.withPNR("thisIsALongPNR").build());
			fail("Exception expected");
		} catch (ValidationException e) {
		}
		try {
			validator.validate(builder.withPNR("short").build());
			fail("Exception expected");
		} catch (ValidationException e) {
		}
		try {
			validator.validate(builder.withPNR("SL1NRR").build());
		} catch (ValidationException e) {
			fail("Exception not expected");
		}
	}

	@Test
	public void pnrIsAlphanumeric() {
		try {
			validator.validate(builder.withPNR("SL1NRR").build());
		} catch (ValidationException e) {
			fail("Exception not expected");
		}
		try {
			validator.validate(builder.withPNR("SL!NRR").build());
			fail("Exception expected");
		} catch (ValidationException e) {
		}
	}

	@Test
	public void pnrIsSixCharactersAndAplhanumeric() {
		try {
			validator.validate(builder.withPNR("SL1NRR").build());
		} catch (ValidationException e) {
			fail("Exception not expected");
		}
		try {
			validator.validate(builder.withPNR("SL1NRRa2").build());
			fail("Exception expected");
		} catch (ValidationException e) {
		}
		try {
			validator.validate(builder.withPNR("SL@N3W").build());
			fail("Exception expected");
		} catch (ValidationException e) {
		}
	}

}
