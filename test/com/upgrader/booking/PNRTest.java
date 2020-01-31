package com.upgrader.booking;

import static org.junit.Assert.*;

import org.junit.Test;

import com.updgrader.booking.PNR;

public class PNRTest {

	@Test
	public void lengthOfPNRIsSix() {
		assertFalse(new PNR("thisIsALongPNR").isValid());
		assertFalse(new PNR("short").isValid());
		assertTrue(new PNR("SL1NRR").isValid());
	}

	@Test
	public void pnrIsAlphanumeric() {
		assertTrue(new PNR("SL1NRR").isValid());
		assertFalse(new PNR("SL!NRR").isValid());
	}

	@Test
	public void pnrIsSixCharactersAndAplhanumeric() {
		assertTrue(new PNR("SL1NRR").isValid());
		assertFalse(new PNR("SL1NRRa2").isValid());
		assertFalse(new PNR("SL@N3W").isValid());
	}

}
