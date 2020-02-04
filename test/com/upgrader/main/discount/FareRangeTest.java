package com.upgrader.main.discount;

import static org.junit.Assert.*;

import org.junit.Test;

import com.updgrader.booking.FareClass;

public class FareRangeTest {

	private FareClass fareClass = FareClass.C;

	@Test
	public void rangeDoesNotContainTargetClass() {
		assertFalse(new FareRange(FareClass.D, FareClass.I).contains(fareClass));
	}

	@Test
	public void rangeContainsTargetFareClass() {
		assertTrue(new FareRange(FareClass.B, FareClass.N).contains(fareClass));
	}
}
