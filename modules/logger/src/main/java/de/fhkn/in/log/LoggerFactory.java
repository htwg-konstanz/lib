package de.fhkn.in.log;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class LoggerFactory implements ILoggerFactory {

	public Logger getLogger(String name) {
		return new InLogger(name);
	}

}
