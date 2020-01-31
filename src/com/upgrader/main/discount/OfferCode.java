package com.upgrader.main.discount;

public enum OfferCode {
	OFFER_20("OFFER_20"), OFFER_25("OFFER_25"), OFFER_30("OFFER_30"), NONE("");
	
	private final String code;
	
	private OfferCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return code;
	}
}
