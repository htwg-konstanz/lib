package de.fhkn.in.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Handles a Datagram request and creates a response if applicable.
 * @author tzink
 *
 */
public interface DatagramHandler {
	public void handleDatagram(DatagramSocket socket, DatagramPacket packet); 
}
