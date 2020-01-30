package com.upgrader.main;

public class Email {

	private String emailAddress;

	public Email(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString() {
		return emailAddress;
	}

}
