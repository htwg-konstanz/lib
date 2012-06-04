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
package de.fhkn.in.util;

import java.util.Iterator;

/**
 * Provides some useful String utilities that are missing in the standard API.
 * Inspired by apache's and google's StringUtils classes but much simpler and
 * less powerful.
 * 
 * @author thomas zink
 *
 */
public final class StringUtils {
    private StringUtils() {
    	// there are no instances of this class
    }
	
	/**
     * Joins elements of the defined array to a single string. This is the
     * reverse to {@code String.split()}
     * 
     * Nulls or empty strings ("") will become "".
     *
     * @param array  the values to join, may be null
     * @param delimiter  the delimiter used between array elements
     * @return the joined String, {@code null} if null input
     */
	public static String join(Object[] array, String delimiter) {
		if (array == null) {
			return null;
		}
		
		return join(array, delimiter, 0, array.length);
	}

    /**
     * Joins elements of the defined array to a single string. This is the
     * reverse to {@code String.split()}
     * 
     * Nulls or empty strings ("") will become "".
     *
     * @param array  the values to join, may be null
     * @param delimiter  the delimiter used between array elements
     * @param start  index to start joining from
     * @param stop  index to stop joining (exclusive)
     * @return the joined String, {@code null} if null input
     */
	public static String join(Object[] array, String separator, int start, int stop) {
		if (array == null) {
			return null;
		}
		int num;
		if (((num=(stop - start)) <= 0) || (start < 0) || (stop > array.length)) {
			return "";
		}
		
		StringBuilder buf = new StringBuilder(num + num*separator.length());
		
		int i = start;
		buf.append(array[i++]);
		for (; i < stop; i++) {
			buf.append(separator);
			if (array[i] != null) {
				buf.append(array[i]);
			}
		}
		
		return buf.toString();
	}

    /**
     * Joins elements of the defined {@code Iterable} to a single string.
     * This is the reverse to {@code String.split()}.
     *
     * Nulls or empty strings ("") will become "".
     * 
     * @param iterable  the {@code Iterable} to join, may be null
     * @param delimiter  the delimiter used between array elements
     * @return the joined String, {@code null} if null input
     */
	public static String join(Iterable<?> iterable, String separator) {
		if (iterable==null) {
			return null;
		}
		return join(iterable.iterator(), separator);
	}

	/**
     * Joins elements of the defined {@code Iterable} to a single string.
     * This is the reverse to {@code String.split()}.
     *
     * Nulls or empty strings ("") will become "".
     * 
     * @param iterator  the {@code Iterator} to join, may be null
     * @param delimiter  the delimiter used between array elements
     * @return the joined String, {@code null} if null input
     */
	public static String join(Iterator<?> iterator, String separator) {
        if (iterator == null) {
            return null;
        }
        if (!iterator.hasNext()) {
            return "";
        }
        
        StringBuilder buf = new StringBuilder(128);
        
        Object next = iterator.next();
        if (next != null) {
        	buf.append(next);
        }
        
        while (iterator.hasNext()) {
        	next = iterator.next();
        	if (separator != null) {
        		buf.append(separator);
        	}
        	if (next != null) {
        		buf.append(next);
        	}
        }
        
        return buf.toString();
    }
}
