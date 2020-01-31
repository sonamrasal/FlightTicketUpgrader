package com.updgrader.booking;

public enum Cabin {
	ECONOMY, PREMIUM_ECONOMY, BUSINESS, FIRST;
	
	public boolean isThis(String category) {
		return this.toString().equals(category.toUpperCase());
	}
}
