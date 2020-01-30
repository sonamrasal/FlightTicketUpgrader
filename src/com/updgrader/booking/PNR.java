package com.updgrader.booking;

public class PNR {

	private String value;

	public PNR(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	public boolean isValid() {
		return value.length() == 6 && value.matches("^[a-zA-Z0-9]*$");
	}
}
