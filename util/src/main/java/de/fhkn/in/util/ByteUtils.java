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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * Provides methods to convert data types to and from byte(s).
 * 
 * @author thomas zink
 */
public final class ByteUtils {
	
	/**
     * Serializes an Object to byte[].
     * The whole Object is serialized. This is not the same as using
     * byte buffers.
     * 
     * @param obj the object to convert
     * @return the object as byte[]
     * @throws IOException 
     */
    public static byte[] toBytes(Object obj) throws IOException {
		ByteArrayOutputStream bstream = new ByteArrayOutputStream();
		ObjectOutputStream ostream = new ObjectOutputStream(bstream);
		ostream.writeObject(obj);
		return bstream.toByteArray();
	}
    
    /**
     * Converts a Short to byte[]
     * 
     * @param val value to convert
     * @return the byte[] representation
     */
	public static byte[] toBytes(Short val) {
		ByteBuffer buffer = ByteBuffer.allocate(2);
		buffer.putShort(val);
		byte[] bytes = buffer.array();
		buffer.clear();
		return bytes;
	}
	
    /**
     * Converts an Integer to byte[]
     * 
     * @param val value to convert
     * @return the byte[] representation
     */
    public static byte[] toBytes(Integer val) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(val);
        byte[] bytes = buffer.array();
        buffer.clear();
        return bytes;
    }
    
    /**
     * Converts a Long to byte[]
     * 
     * @param val value to convert
     * @return the byte[] representation
     */
    public static byte[] toBytes(Long val) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(val);
        byte[] bytes = buffer.array();
        buffer.clear();
        return bytes;
    }
    
    /**
     * Converts a Float to byte[]
     * 
     * @param val value to convert
     * @return the byte[] representation
     */
    public static byte[] toBytes(Float val) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putFloat(val);
        byte[] bytes = buffer.array();
        buffer.clear();
        return bytes;
    }
    
    /**
     * Converts a Double to byte[]
     * 
     * @param val value to convert
     * @return the byte[] representation
     */
    public static byte[] toBytes(Double val) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putDouble(val);
        byte[] bytes = buffer.array();
        buffer.clear();
        return bytes;
    }

	/**
	 * Creates an Object from a byte[]
	 * 
	 * @param array the byte array to convert
	 * @return the converted object
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static Object toObject(byte[] array) 
			throws IOException, ClassNotFoundException {
		Object obj = null;
		obj = new ObjectInputStream(
			new ByteArrayInputStream(array)
		).readObject();
		return obj;
	}
	
	/**
	 * Creates a Short from a byte array.
	 * 
	 * @param array the byte array to convert
	 * @return the converted short or null if failed
	 */
	public static Short toShort(byte[] array) {
		if ((array.length * 8) < Short.SIZE) return null;
		ByteBuffer buffer = ByteBuffer.wrap(array);
		return buffer.getShort();
	}
	
	/**
	 * Creates an Integer from a byte array.
	 * 
	 * @param array the byte array to convert
	 * @return the converted int or null if failed
	 */
	public static Integer toInteger(byte[] array) {
		if ((array.length * 8) < Integer.SIZE) return null;
		ByteBuffer buffer = ByteBuffer.wrap(array);
		return buffer.getInt();
	}
	
	/**
	 * Creates a Long from a byte array.
	 * 
	 * @param array the byte array to convert
	 * @return the converted long or null if failed
	 */
	public static Long toLong(byte[] array) {
		if ((array.length * 8) < Long.SIZE) return null;
		ByteBuffer buffer = ByteBuffer.wrap(array);
		return buffer.getLong();
	}
	
	/**
	 * Creates a Float from a byte array.
	 * 
	 * @param array the byte array to convert
	 * @return the converted float or null if failed
	 */
	public static Float toFloat(byte[] array) {
		if ((array.length * 8) < Float.SIZE) return null;
		ByteBuffer buffer = ByteBuffer.wrap(array);
		return buffer.getFloat();
	}
	
	/**
	 * Creates a Double from a byte array.
	 * 
	 * @param array the byte array to convert
	 * @return the converted double or null if failed
	 */
	public static Double toDouble(byte[] array) {
		if ((array.length * 8) < Double.SIZE) return null;
		ByteBuffer buffer = ByteBuffer.wrap(array);
		return buffer.getDouble();
	}
	
	/**
	 * Creates a string from byte array using specified encoding.
	 * Note: in apache commons a similar method is provided in 
	 * the 'StringUtils' class. That makes sense when putting methods
	 * to utility classes corresponding to return type.
	 * 
	 * @param array the array to convert to a string
	 * @param encoding tha desired character encoding
	 * @return the converted String
	 * @throws UnsupportedEncodingException 
	 */
	public static String toString(byte[] array, String encoding) throws UnsupportedEncodingException {
		return encoding==null ? new String(array) : new String(array,encoding);
	}
	
	/**
	 * Creates a string from byte array using default encoding.
	 * Note: in apache commons a similar method is provided in 
	 * the 'StringUtils' class. That makes sense when putting methods
	 * to utility classes corresponding to return type.
	 * 
	 * @param array the array to convert to a string
	 * @return the String of the array
	 */
	public static String toString(byte[] array) {
		String ret = null;
		try {
			ret = toString(array,null);
		} catch (UnsupportedEncodingException e) {
			// ignore, this can never happen
		}
		return ret;
	}
}