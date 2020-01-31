package com.upgrader.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.upgrader.main.ProcessingInformation;

public class TextFileWriter implements Writer {

	private String processedBookingFile;
	private String processingFailureFile;

	public TextFileWriter(String processedBookingFile, String processingFailureFile) {
		this.processedBookingFile = processedBookingFile;
		this.processingFailureFile = processingFailureFile;
	}

	@Override
	public void write(List<ProcessingInformation> processingInformation) throws IOException {
		BufferedWriter successWriter = new BufferedWriter(new FileWriter(processedBookingFile));
		BufferedWriter failureWriter = new BufferedWriter(new FileWriter(processingFailureFile));
		Iterator<ProcessingInformation> iterator = processingInformation.iterator();
		while(iterator.hasNext()) {
			ProcessingInformation result = iterator.next();
			if(result.isBookingFaulty()) {
				failureWriter.write(result.toString());
			} else {
				successWriter.write(result.toString());
			}
		}
		successWriter.close();
		failureWriter.close();
	}

}
