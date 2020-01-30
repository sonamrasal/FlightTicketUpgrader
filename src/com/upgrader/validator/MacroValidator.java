package com.upgrader.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.updgrader.booking.Booking;

public class MacroValidator implements Validator {
	private List<Validator> validators;

	public MacroValidator(Validator... validators) {
		this.validators = new ArrayList<Validator>();
		for (int i = 0; i < validators.length; i++) {
			this.validators.add(validators[i]);
		}
	}

	@Override
	public void validate(Booking booking) throws ValidationException {
		Iterator<Validator> iterator = validators.iterator();
		while (iterator.hasNext()) {
			Validator validator = iterator.next();
			validator.validate(booking);
		}
	}

}
