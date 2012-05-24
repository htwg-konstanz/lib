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
package de.fhkn.in.rmi;

import java.rmi.RemoteException;

/**
 * Implementation of a remote object to display a user-/predefined message
 * upon call of a client.
 * 
 * @author thomas zink
 */
public class RemoteMessenger implements IRemoteMessage {
	private static final String DEFAULT_MESSAGE = "Hello World of RMI!";
	private final String message;

	/**
	 * @param msg the message to display
	 * @throws RemoteException
	 */
	public RemoteMessenger(final String msg) throws RemoteException {
		this.message = msg == null ? DEFAULT_MESSAGE : msg;
	}
	
	/**
	 * Default constructor.
	 * @throws RemoteException
	 */
	public RemoteMessenger() throws RemoteException {
		this(null);
	}
	
	/* (non-Javadoc)
	 * @see de.fhkn.in.rmi.IRemoteMessage#message()
	 */
	@Override
	public String message() throws RemoteException {
		return this.message;
	}
}
