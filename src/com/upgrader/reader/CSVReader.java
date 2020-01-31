package com.upgrader.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.updgrader.booking.Booking;
import com.updgrader.booking.Booking.BookingBuilder;

public class CSVReader implements Reader {

	private static final String CSV = ".csv";

	@Override
	public List<Booking> read(String fileName) throws IOException {
		if (null == fileName) {
			throw new FileNotFoundException("Cannot read null file");
		}
		String fileExtension = fileName.substring(fileName.lastIndexOf("."));
		if (!CSV.equals(fileExtension)) {
			throw new UnsupportedOperationException("Can read only CSV files");
		}
		BookingBuilder bookingBuilder = Booking.getBuilderInstance();
		List<Booking> bookingInfo = new ArrayList<Booking>();
		Files.lines(Paths.get(fileName)).forEach(line -> {
			if (!"".equals(line)) {
				try {
					bookingInfo.add(buildInfo(bookingBuilder, line));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});

		return bookingInfo;
	}

	private Booking buildInfo(BookingBuilder bookingBuilder, String line) throws ParseException {
		line = sanitize(line);
		String[] information = line.split(",");
		return bookingBuilder.withFirstName(information[0]).withLastName(information[1]).withPNR(information[2])
				.withFareClass(information[3]).withTravelDate(information[4]).withPersons(information[5])
				.withBookingDate(information[6]).withEmail(information[7]).withMobileNumber(information[8])
				.withCabin(information[9]).build();
	}

	private String sanitize(String line) {
		return line.replaceAll("[\"]", "");
	}

}
