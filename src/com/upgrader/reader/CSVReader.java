package com.upgrader.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.upgrader.main.Booking;
import com.upgrader.main.Booking.BookingBuilder;

public class CSVReader {

	private static final String CSV = ".csv";

	public List<Booking> read(String fileName) throws IOException {
		if (null == fileName) {
			throw new FileNotFoundException("Cannot read null file");
		}
		String fileExtension = fileName.substring(fileName.lastIndexOf("."));
		if (!CSV.equals(fileExtension)) {
			throw new UnsupportedOperationException("Can read only CSV files");
		}
//		try {
		BookingBuilder bookingBuilder = Booking.getBuilderInstance();
		List<Booking> bookingInfo = new ArrayList<Booking>();
		Files.lines(Paths.get(fileName)).forEach(line -> {
			bookingInfo.add(buildInfo(bookingBuilder, line));
		});

		/*
		 * Scanner scanner = new Scanner(new File(fileName)); while(scanner.hasNext()) {
		 * String line = scanner.nextLine(); bookingInfo.add(buildInfo(bookingBuilder,
		 * line)); }
		 */
		return bookingInfo;
//		} catch (IOException e) {
//			return new ArrayList<Booking>();
//		}
	}

	private Booking buildInfo(BookingBuilder bookingBuilder, String line) {
		line = sanitize(line);
		String[] information = line.split(",");
		return bookingBuilder.withFirstName(information[0]).withLastName(information[1]).withPNR(information[2])
				.withFare(information[3]).forTravelDate(information[4]).forPersons(information[5])
				.withBookingDate(information[6]).withEmail(information[7]).withMobileNumber(information[8])
				.withCabin(information[9]).build();
	}

	private String sanitize(String line) {
		return line.replaceAll("[\"]", "");
	}

}
