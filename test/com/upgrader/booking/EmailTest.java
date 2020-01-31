package com.upgrader.booking;

import static org.junit.Assert.*;

import org.junit.Test;

import com.updgrader.booking.Email;

public class EmailTest {

	@Test
	public void malformedEmailAddressNotValid() {
		assertFalse(new Email("abc@xyz@.com").isValid());
		assertFalse(new Email("abc.xyz@.com").isValid());
		assertFalse(new Email(".abc.xyz@somedomain.com").isValid());
		assertFalse(new Email("abc*xyz@somedomain.com").isValid());
		assertFalse(new Email("abc.xyz@com").isValid());
		assertFalse(new Email("radhika@zzz").isValid());
	}
	
	@Test
	public void emailAddressWithValidCharacters() {
		assertTrue(new Email("someName@someDomain.com").isValid());
		assertTrue(new Email("some_name@someDomain.com").isValid());
	}

}
