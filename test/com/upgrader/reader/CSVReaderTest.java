package com.upgrader.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.updgrader.booking.Booking;

public class CSVReaderTest {

	private Reader reader = new CSVReader();

	@Test(expected = FileNotFoundException.class)
	public void cannotReadNullFiles() throws IOException {
		reader.read(null);
		fail("Should have thrown exception for null file");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void readerCanReadOnlyCSVFiles() throws IOException {
		try {
			reader.read("dummyTextFile.txt");
		} catch (FileNotFoundException e) {
			fail("Not the expected exception!");
		}
	}

	@Test
	public void readingEmptyFileProducesNoInformation() throws IOException {
		List<Booking> bookingInfo = reader.read("testData\\reader\\emptyFile.csv");
		assertEquals(0, bookingInfo.size());
	}

	@Test
	public void readInputDataFileToProduceBookingInfo() throws IOException {
		List<Booking> bookingInfo = reader.read("testData\\reader\\sampleData.csv");
		assertNotNull(bookingInfo);
		assertEquals(2, bookingInfo.size());
		List<String> expectedBookingInfo = buildBookingInfo();
		bookingInfo.stream().forEach(booking -> assertTrue(expectedBookingInfo.contains(booking.toString())));
	}

	private List<String> buildBookingInfo() {
		return Arrays.asList("Abhishek,Kumar,ABC123,F,2019-07-31,2,2019-05-21,abhishek@zzz.com,9876543210,Economy",
				"Monin,Sankar,PQ234,C,2019-08-30,2,2019-05-22,monin@zzz.com,9876543211,Economy");
	}

}
