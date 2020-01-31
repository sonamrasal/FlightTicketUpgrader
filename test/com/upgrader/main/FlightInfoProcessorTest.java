package com.upgrader.main;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.upgrader.reader.CSVReader;
import com.upgrader.validator.EmailValidator;
import com.upgrader.validator.PNRValidator;

public class FlightInfoProcessorTest {

	@Test
	public void bookingMadeWithInvalidPNR() throws IOException {
		FlightInfoProcessor flightInfoProcessor = new FlightInfoProcessor(new CSVReader(), new PNRValidator());
		List<ProcessingInformation> result = flightInfoProcessor.processBookingInformation("C:\\faultyPNRBooking.csv");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertTrue("Monin,Sankar,PQ234,C,2019-08-30,2,2019-05-22,monin@zzz.com,9876543211,Economy,PNR Invalid"
				.equals(result.get(0).toString()));
	}

	@Test
	public void bookingMadeWithInvalidEmail() throws IOException {
		FlightInfoProcessor flightInfoProcessor = new FlightInfoProcessor(new CSVReader(), new EmailValidator());
		List<ProcessingInformation> result = flightInfoProcessor
				.processBookingInformation("C:\\faultyEmailBooking.csv");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertTrue("Radhika,Suresh,ZZZ345,T,2019-05-31,4,2019-05-21,radhika@zzz,9876543212,Business,Email Invalid"
				.equals(result.get(0).toString()));
	}

	@Test
	public void allBookingsAreInvalid() {

	}

	@Test
	public void allBookingsAreValid() throws IOException {
		FlightInfoProcessor flightInfoProcessor = new FlightInfoProcessor(new CSVReader(), new EmailValidator());
		List<ProcessingInformation> result = flightInfoProcessor
				.processBookingInformation("C:\\allValidBookings.csv");
		assertNotNull(result);
		assertEquals(3, result.size());
		assertTrue("Abhishek,Kumar,ABC123,F,2019-07-31,2,2019-05-21,abhishek@zzz.com,9876543210,Economy,OFFER_30"
				.equals(result.get(0).toString()));
		assertTrue("Kalyani ,Ben,A1B2C3,M,2019-04-30,1,2019-05-21,kben@zzz.com,9876543213,Premium Economy,OFFER_25"
				.equals(result.get(1).toString()));
		assertTrue("Somnath,Batra,X1Y2Z4,Z,2019-07-25,3,2019-05-23,sbatra@zzz.com,9876543214,Economy,"
				.equals(result.get(2).toString()));
	}

}
