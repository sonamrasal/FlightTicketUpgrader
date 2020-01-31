package com.upgrader.main.discount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.updgrader.booking.Booking;
import com.updgrader.booking.FareClass;

public class Discounts {

	private static List<Offer> allDiscounts = new ArrayList<Offer>() {
		{
			add(new Offer(new FareRange(FareClass.A, FareClass.E), OfferCode.OFFER_20));
			add(new Offer(new FareRange(FareClass.F, FareClass.K), OfferCode.OFFER_30));
			add(new Offer(new FareRange(FareClass.L, FareClass.R), OfferCode.OFFER_25));
			add(new Offer(new FareRange(FareClass.S, FareClass.Z), OfferCode.NONE));
		}
	};

	public static String applyDiscountTo(Booking booking) {
		Optional<Offer> matchingRange = allDiscounts.stream().filter(offer -> booking.isFareWithin(offer.range()))
				.findFirst();
		return matchingRange.isPresent() ? matchingRange.get().toString() : OfferCode.NONE.toString();
	}

}
