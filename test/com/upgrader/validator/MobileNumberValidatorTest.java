package com.upgrader.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class MobileNumberValidatorTest {

	private MobileNumberValidator validator = new MobileNumberValidator();

	@Test
	public void mobileNumberLengthIsTen() {
		assertFalse(validator.isValidLength("123456789"));
		assertTrue(validator.isValidLength("1234567890"));
		assertTrue(validator.isValidLength("9823014600"));
	}

	@Test
	public void mobileNumberIsDigitsOnly() {
		assertFalse(validator.isNumeric("notAMobile"));
		assertFalse(validator.isNumeric("n0tANumb3r"));
		assertTrue(validator.isNumeric("9823014600"));
	}
	
	/*
	 * @Test public void mobileNumberIsTenDigitNumberOnly() {
	 * assertTrue(validator.validate("9823014600"));
	 * assertFalse(validator.validate("123456789"));
	 * assertFalse(validator.validate("n0tANumb3r")); }
	 */

}
