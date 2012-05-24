/*
    Copyright (c) 2012 Thomas Zink, 

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.fhkn.in.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InLoggerTest {
	private final ByteArrayOutputStream errStream = new ByteArrayOutputStream();
	private final Logger log = LoggerFactory.getLogger(InLoggerTest.class);
	private final String msg = "testString";

	@Before
	public void setUpStreams() {
		System.setErr(new PrintStream(errStream));
	}

	@After
	public void cleanUpStreams() {
		System.setErr(null);
	}
	
	private final void assertLoglevel(int loglvl) {
		assertEquals(((InLogger) log).getLoglevel(), loglvl);
		((InLogger) log).setLoglevel(Integer.toString(loglvl));
		assertEquals(((InLogger) log).getLoglevel(), loglvl);
	}
		
	@Test
	public void testSetLogLevel() {
		// ERROR
		int loglvl = InLogger.ERROR;
		((InLogger) log).setLoglevel("Error");
		assertLoglevel(loglvl);
		
		// WARN
		loglvl = InLogger.WARN;
		((InLogger) log).setLoglevel("Warn");
		assertLoglevel(loglvl);
		
		// INFO
		loglvl = InLogger.INFO;
		((InLogger) log).setLoglevel("Info");
		assertLoglevel(loglvl);
		
		// DEBUG
		loglvl = InLogger.DEBUG;
		((InLogger) log).setLoglevel("Debug");
		assertLoglevel(loglvl);
		
		// TRACE
		loglvl = InLogger.TRACE;
		((InLogger) log).setLoglevel("Trace");
		assertLoglevel(loglvl);
		
		// OFF
		loglvl = InLogger.OFF;
		((InLogger) log).setLoglevel("Off");
		assertLoglevel(loglvl);
	}
	
	@Test
	public void testDebugString() {
		((InLogger) log).setLoglevel(InLogger.DEBUG);
		log.debug(msg);
		assertTrue(errStream.toString().contains(msg));
	}

	@Test
	public void testErrorString() {
		((InLogger) log).setLoglevel(InLogger.ERROR);
		log.error(msg);
		assertTrue(errStream.toString().contains(msg));
	}

	@Test
	public void testInfoString() {
		((InLogger) log).setLoglevel(InLogger.INFO);
		log.info(msg);
		assertTrue(errStream.toString().contains(msg));
	}

	@Test
	public void testTraceString() {
		((InLogger) log).setLoglevel(InLogger.TRACE);
		log.trace(msg);
		assertTrue(errStream.toString().contains(msg));
	}

	@Test
	public void testWarnString() {
		((InLogger) log).setLoglevel(InLogger.WARN);
		log.warn(msg);
		assertTrue(errStream.toString().contains(msg));
	}
}
