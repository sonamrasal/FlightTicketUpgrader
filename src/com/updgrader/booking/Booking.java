package com.updgrader.booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import com.upgrader.main.discount.FareRange;

public class Booking {

	private String firstName;
	private String lastName;
	private PNR pnr;
	private FareClass fare;
	private String travelDate;
	private String numberOfPersons;
	private String bookingDate;
	private Email email;
	private MobileNumber mobile;
	private String cabin;

	private Booking(String firstName, String lastName, PNR pnr, FareClass fare, String travelDate,
			String numberOfPersons, String bookingDate, Email email, MobileNumber mobile, String cabin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pnr = pnr;
		this.fare = fare;
		this.travelDate = travelDate;
		this.numberOfPersons = numberOfPersons;
		this.bookingDate = bookingDate;
		this.email = email;
		this.mobile = mobile;
		this.cabin = cabin;
	}

	public static class BookingBuilder {

		private String firstName;
		private String lastName;
		private PNR pnr;
		private FareClass fareClass;
		private String travelDate;
		private String numberOfPersons;
		private String bookingDate;
		private Email email;
		private MobileNumber mobile;
		private String cabin;

		public BookingBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public BookingBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public BookingBuilder withPNR(String pnr) {
			this.pnr = new PNR(pnr);
			return this;
		}

		public BookingBuilder withFareClass(String fareClass) {
			this.fareClass = FareClass.valueOf(fareClass);
			return this;
		}

		public BookingBuilder withTravelDate(String travelDate) {
			this.travelDate = travelDate;
			return this;
		}

		public BookingBuilder withPersons(String numberOfPersons) {
			this.numberOfPersons = numberOfPersons;
			return this;
		}

		public BookingBuilder withBookingDate(String bookingDate) {
			this.bookingDate = bookingDate;
			return this;
		}

		public BookingBuilder withEmail(String email) {
			this.email = new Email(email);
			return this;
		}

		public BookingBuilder withMobileNumber(String mobileNumber) {
			this.mobile = new MobileNumber(mobileNumber);
			return this;
		}

		public BookingBuilder withCabin(String cabin) {
			this.cabin = cabin;
			return this;
		}

		public Booking build() {
			Booking booking = new Booking(firstName, lastName, pnr, fareClass, travelDate, numberOfPersons, bookingDate,
					email, mobile, cabin);
			return booking;
		}

	}

	public static BookingBuilder getBuilderInstance() {
		return new BookingBuilder();
	}

	@Override
	public String toString() {
		return firstName + "," + lastName + "," + pnr.toString() + "," + fare.toString() + "," + travelDate + ","
				+ numberOfPersons + "," + bookingDate + "," + email.toString() + "," + mobile.toString() + "," + cabin;

	}

	public boolean isMobileNumberValid() {
		return mobile.isValid();
	}

	public boolean isPNRValid() {
		return pnr.isValid();
	}

	public boolean isEmailValid() {
		return email.isValid();
	}

	public boolean isBookingInAdvanceOfTravel() throws ParseException {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("YYYY-mm-dd");
		return dateFormatter.parse(bookingDate).before(dateFormatter.parse(travelDate));
	}

	public boolean isCabinValid() {
		return !(Stream.of(Cabin.values()).noneMatch(value -> value.isThis(this.cabin)));
	}

	public boolean isFareWithin(FareRange range) {
		return range.contains(this.fare);
	}
}
