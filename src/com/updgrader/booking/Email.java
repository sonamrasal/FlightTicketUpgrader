package com.updgrader.booking;

public class Email {

	private String emailAddress;

	public Email(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString() {
		return emailAddress;
	}

	public boolean isValid() {
		return emailAddress.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$");
	}

}
