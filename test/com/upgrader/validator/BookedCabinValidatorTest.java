package com.upgrader.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.updgrader.booking.Booking;

public class BookedCabinValidatorTest {

	private Validator validator = new BookedCabinValidator();

	@Test
	public void bookedCabinAmongTheAllowedCategories() {
		try {
			validator.validate(bookTicketForFirstClass());
		} catch (ValidationException e) {
			fail("First class is a valid category - should not throw validation exception");
		}
	}

	@Test(expected = ValidationException.class)
	public void bookedCabinNotAmongThePermissibleCategories() throws ValidationException {
		validator.validate(bookTicketForDiamondClass());
		fail("Should have thrown exception since cabin is not amoing the permissible cabin category");
	}

	private Booking bookTicketForDiamondClass() {
		return Booking.getBuilderInstance().withCabin("DIAMOND").build();
	}

	private Booking bookTicketForFirstClass() {
		return Booking.getBuilderInstance().withCabin("first").build();
	}

}
