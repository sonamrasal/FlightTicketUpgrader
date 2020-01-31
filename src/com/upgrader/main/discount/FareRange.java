package com.upgrader.main.discount;

import com.updgrader.booking.FareClass;

public class FareRange {
	private final FareClass start;
	private final FareClass end;
	
	public FareRange(FareClass start, FareClass end) {
		this.start = start;
		this.end = end;
	}

	public boolean contains(FareClass fare) {
		return this.start.compareTo(fare) <= 0 && this.end.compareTo(fare) >= 0;
	}
}
