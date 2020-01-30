package com.upgrader.validator;

import com.upgrader.main.Booking;

public class PNRValidator /* implements Validator */ {

	public boolean isValidLength(String pnr) {
		return pnr.length() == 6;
	}

	public boolean isAplhanumeric(String pnr) {
		return pnr.matches("^[a-zA-Z0-9]*$");
	}

	/*
	 * @Override public boolean validate(Booking booking) { return
	 * isValidLength(pnr) && isAplhanumeric(pnr); }
	 */

}
