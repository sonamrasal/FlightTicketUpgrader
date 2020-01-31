package com.upgrader.writer;

import java.io.IOException;
import java.util.List;

import com.upgrader.main.ProcessingInformation;

public interface Writer {
	void write(List<ProcessingInformation> processingInformation) throws IOException;
}
