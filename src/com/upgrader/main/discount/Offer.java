package com.upgrader.main.discount;

public class Offer {

	private final FareRange fareRange;
	private final OfferCode offerCode;

	public Offer(FareRange fareRange, OfferCode offerCode) {
		this.fareRange = fareRange;
		this.offerCode = offerCode;
	}

	public FareRange range() {
		return fareRange;
	}
	
	@Override
	public String toString() {
		return offerCode.toString();
	}

}
