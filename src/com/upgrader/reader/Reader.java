package com.upgrader.reader;

import java.io.IOException;
import java.util.List;

import com.updgrader.booking.Booking;

public interface Reader {

	List<Booking> read(String fileName) throws IOException;

}