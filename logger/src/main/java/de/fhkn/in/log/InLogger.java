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

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.Logger;

/**
 * HTWG Logger class
 * @author tzink
 */
public class InLogger extends MarkerIgnoringBase implements Logger {

	private static final long serialVersionUID = 5418018688165135349L;

	private final String name;
	private int loglevel;
	
	public static final int OFF = 0;
	public static final int ERROR = 1;
	public static final int WARN = 2;
	public static final int INFO = 3;
	public static final int DEBUG = 4;
	public static final int TRACE = 5;
	public static final int DEFAULT_LOG_LEVEL = INFO;
	
	public InLogger(String name) {
		this.name = name;
		this.loglevel = InLogger.DEFAULT_LOG_LEVEL;
		String sprop = System.getProperty("log");
		setLoglevel(sprop);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the loglevel
	 */
	public int getLoglevel() {
		return loglevel;
	}

	/**
	 * @param loglevel the loglevel to set
	 */
	public void setLoglevel(int loglevel) {
		this.loglevel = loglevel;
	}
	
	/**
	 * @param loglevel the loglevel to set
	 */
	public void setLoglevel(String loglevel) {
		int lvl = this.loglevel;
		if (loglevel!=null) {
			loglevel = loglevel.toLowerCase();
			try {
				lvl = Integer.parseInt(loglevel);
			}
			catch (NumberFormatException e) {
				if (loglevel.equals("error")) lvl = ERROR;
				else if (loglevel.equals("warn")) lvl = WARN;
				else if (loglevel.equals("info")) lvl = INFO;
				else if (loglevel.equals("debug")) lvl = DEBUG;
				else if (loglevel.equals("trace")) lvl = TRACE;
				else if (loglevel.equals("off")) lvl = OFF;
			}
		}
		setLoglevel(lvl);
	}

	private String getTime() {	
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
		return sdf.format(new Date());
	}
	
	private String craftMessage(String loglevel, String msg) {
		return "[" + loglevel + "][" + getTime() + "][" + Thread.currentThread().getName() + "][" + name + "] " + msg;
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String)
	 */
	public void debug(String msg) {
		if (loglevel >= DEBUG) {	
			System.err.println(craftMessage("DEBUG", msg));
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object)
	 */
	public void debug(String format, Object arg) {
		debug(MessageFormatter.format(format, arg).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object[])
	 */
	public void debug(String format, Object[] argArray) {	
		debug(MessageFormatter.arrayFormat(format, argArray).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Throwable)
	 */
	public void debug(String msg, Throwable t) {
		debug(MessageFormatter.format("{}\n{}", msg, t.getMessage()).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void debug(String format, Object arg1, Object arg2) {
		debug(MessageFormatter.format(format, arg1, arg2).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String)
	 */
	public void error(String msg) {
		if (loglevel >= ERROR) {	
			System.err.println(craftMessage("ERROR", msg));
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object)
	 */
	public void error(String format, Object arg) {
		error(MessageFormatter.format(format, arg).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object[])
	 */
	public void error(String format, Object[] argArray) {	
		error(MessageFormatter.arrayFormat(format, argArray).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Throwable)
	 */
	public void error(String msg, Throwable t) {
		error(MessageFormatter.format("{}\n{}", msg, t.getMessage()).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void error(String format, Object arg1, Object arg2) {
		error(MessageFormatter.format(format, arg1, arg2).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String)
	 */
	public void info(String msg) {
		if (loglevel >= INFO) {	
			System.err.println(craftMessage("INFO", msg));
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object)
	 */
	public void info(String format, Object arg) {
		info(MessageFormatter.format(format, arg).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object[])
	 */
	public void info(String format, Object[] argArray) {	
		info(MessageFormatter.arrayFormat(format, argArray).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Throwable)
	 */
	public void info(String msg, Throwable t) {
		info(MessageFormatter.format("{}\n{}", msg, t.getMessage()).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void info(String format, Object arg1, Object arg2) {
		info(MessageFormatter.format(format, arg1, arg2).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isDebugEnabled()
	 */
	public boolean isDebugEnabled() {
		return loglevel >= DEBUG;
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isErrorEnabled()
	 */
	public boolean isErrorEnabled() {
		return loglevel >= ERROR;
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isInfoEnabled()
	 */
	public boolean isInfoEnabled() {
		return loglevel >= INFO;
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isTraceEnabled()
	 */
	public boolean isTraceEnabled() {
		return loglevel >= TRACE;
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isWarnEnabled()
	 */
	public boolean isWarnEnabled() {
		return loglevel >= WARN;
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#trace(java.lang.String)
	 */
	public void trace(String msg) {
		if (loglevel >= TRACE) {	
			System.err.println(craftMessage("TRACE", msg));
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Object)
	 */
	public void trace(String format, Object arg) {
		trace(MessageFormatter.format(format, arg).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Object[])
	 */
	public void trace(String format, Object[] argArray) {	
		trace(MessageFormatter.arrayFormat(format, argArray).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Throwable)
	 */
	public void trace(String msg, Throwable t) {
		trace(MessageFormatter.format("{}\n{}", msg, t.getMessage()).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void trace(String format, Object arg1, Object arg2) {
		trace(MessageFormatter.format(format, arg1, arg2).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String)
	 */
	public void warn(String msg) {
		if (loglevel >= WARN) {	
			System.err.println(craftMessage("WARN", msg));
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object)
	 */
	public void warn(String format, Object arg) {
		warn(MessageFormatter.format(format, arg).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object[])
	 */
	public void warn(String format, Object[] argArray) {	
		warn(MessageFormatter.arrayFormat(format, argArray).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Throwable)
	 */
	public void warn(String msg, Throwable t) {
		warn(MessageFormatter.format("{}\n{}", msg, t.getMessage()).getMessage());
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void warn(String format, Object arg1, Object arg2) {
		warn(MessageFormatter.format(format, arg1, arg2).getMessage());
	}

}
