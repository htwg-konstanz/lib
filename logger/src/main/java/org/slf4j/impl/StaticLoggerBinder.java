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
package org.slf4j.impl;

import org.slf4j.ILoggerFactory;

import de.fhkn.in.log.InLoggerFactory;


public class StaticLoggerBinder {
	private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
	public static final String REQUESTED_API_VERSION = "1.6.4";
	private final ILoggerFactory factory = new InLoggerFactory();

	private StaticLoggerBinder() {}
	
	public static final StaticLoggerBinder getSingleton() {
		return SINGLETON;
	}

	public ILoggerFactory getLoggerFactory() {
		return factory;
	}

	public String getLoggerFactoryClassStr() {
		return InLoggerFactory.class.toString();
	}
}
