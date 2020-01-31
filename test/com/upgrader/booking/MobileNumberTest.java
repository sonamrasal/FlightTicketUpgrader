package com.upgrader.booking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.updgrader.booking.MobileNumber;

public class MobileNumberTest {
	@Test
	public void mobileNumberLengthIsTen() {
		assertFalse(new MobileNumber("12345").isValid());
		assertFalse(new MobileNumber("123437154027").isValid());
		assertTrue(new MobileNumber("9823014600").isValid());
	}

	@Test
	public void mobileNumberHasOnlyDigits() {
		assertFalse(new MobileNumber("notAMobile").isValid());
		assertFalse(new MobileNumber("n0tANumb3r").isValid());
		assertTrue(new MobileNumber("9823014600").isValid());
	}

	@Test
	public void mobileNumberIsTenDigitNumberOnly() {
		assertTrue(new MobileNumber("9823014600").isValid());
		assertFalse(new MobileNumber("123456789").isValid());
		assertFalse(new MobileNumber("n0tANumb3r").isValid());
	}
}
