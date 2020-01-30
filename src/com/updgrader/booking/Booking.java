package com.updgrader.booking;

public class Booking {

	private String firstName;
	private String lastName;
	private PNR pnr;
	private Fare fare;
	private String travelDate;
	private int numberOfPersons;
	private String bookingDate;
	private Email email;
	private MobileNumber mobile;
	private Cabin cabin;

	private Booking(String firstName, String lastName, PNR pnr, Fare fare, String travelDate, int numberOfPersons,
			String bookingDate, Email email, MobileNumber mobile, Cabin cabin) {
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
		private Fare fare;
		private String travelDate;
		private Integer numberOfPersons;
		private String bookingDate;
		private Email email;
		private MobileNumber mobile;
		private Cabin cabin;

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

		public BookingBuilder withFare(String fare) {
			this.fare = Fare.valueOf(fare);
			return this;
		}

		public BookingBuilder forTravelDate(String travelDate) {
			this.travelDate = travelDate;
			return this;
		}

		public BookingBuilder forPersons(String numberOfPersons) {
			this.numberOfPersons = Integer.valueOf(numberOfPersons);
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
			this.cabin = Cabin.valueOf(cabin.toUpperCase());
			return this;
		}

		public Booking build() {
			Booking booking = new Booking(firstName, lastName, pnr, fare, travelDate, numberOfPersons, bookingDate,
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
				+ numberOfPersons + "," + bookingDate + "," + email.toString() + "," + mobile.toString() + ","
				+ cabin.toString();

	}

	public boolean isMobileNumberValid() {
		return mobile.isValid();
	}

	public boolean isPNRValid() {
		return pnr.isValid();
	}
}
