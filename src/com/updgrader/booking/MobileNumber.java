package com.updgrader.booking;

public class MobileNumber {

	private String value;

	public MobileNumber(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}

	public boolean isValid() {
		return value.matches("^[0-9]*$") && value.length() == 10;
	}

}
