package com.upgrader.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.updgrader.booking.Booking;

public class MobileNumberValidatorTest {

	private MobileNumberValidator validator = new MobileNumberValidator();
	private Booking.BookingBuilder builder = Booking.getBuilderInstance();

	@Test
	public void mobileNumberLengthIsTen() {
		try {
			validator.validate(builder.withMobileNumber("123456789").build());
			fail("Mobile number invalid - exception expected");
		} catch (ValidationException e) {
		}
		try {
			validator.validate(builder.withMobileNumber("1234567890").build());
			validator.validate(builder.withMobileNumber("9823014600").build());
		} catch (ValidationException e) {
			fail("Valid mobile number provided - excpetion should not be thrown");
		}
	}

	@Test
	public void mobileNumberIsDigitsOnly() {
		try {
			validator.validate(builder.withMobileNumber("notAMobile").build());
			fail("Mobile number invalid - exception expected");
		} catch (ValidationException e) {
		}
		try {
			validator.validate(builder.withMobileNumber("n0tANumb3r").build());
			fail("Mobile number invalid - exception expected");
		} catch (ValidationException e) {
		}
		try {
			validator.validate(builder.withMobileNumber("9823014600").build());
		} catch (ValidationException e) {
			fail("Valid mobile number provided - excpetion should not be thrown");
		}
	}
	
	@Test
	public void mobileNumberIsTenDigitNumberOnly() {
		try {
			validator.validate(builder.withMobileNumber("123456789").build());
			fail("Mobile number invalid - exception expected");
		} catch (ValidationException e) {
		}
		try {
			validator.validate(builder.withMobileNumber("n0tANumb3r").build());
			fail("Mobile number invalid - exception expected");
		} catch (ValidationException e) {
		}
		try {
			validator.validate(builder.withMobileNumber("9823014600").build());
		} catch (ValidationException e) {
			fail("Valid mobile number provided - excpetion should not be thrown");
		}
	}
	
}
