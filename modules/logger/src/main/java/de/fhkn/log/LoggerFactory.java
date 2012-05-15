package de.fhkn.log;

import org.slf4j.ILoggerFactory;

public class LoggerFactory implements ILoggerFactory {

	public Logger getLogger(String name) {
		return new Logger(name);
	}

}
