package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import de.fhkn.log.LoggerFactory;


public class StaticLoggerBinder {
	private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
	public static final String REQUESTED_API_VERSION = "1.6.4";
	private final ILoggerFactory factory = new LoggerFactory();

	private StaticLoggerBinder() {}
	
	public static final StaticLoggerBinder getSingleton() {
		return SINGLETON;
	}

	public ILoggerFactory getLoggerFactory() {
		return factory;
	}

	public String getLoggerFactoryClassStr() {
		return LoggerFactory.class.toString();
	}
}
