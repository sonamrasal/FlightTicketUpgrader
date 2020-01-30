package com.upgrader.validator;

public class MobileNumberValidator {

	public boolean validate(String mobileNumber) {
		return isNumeric(mobileNumber) && isValidLength(mobileNumber);
	}

	public boolean isNumeric(String mobileNumber) {
		return mobileNumber.matches("^[0-9]*$");
	}

	public boolean isValidLength(String mobileNumber) {
		return mobileNumber.length() == 10;
	}

}
