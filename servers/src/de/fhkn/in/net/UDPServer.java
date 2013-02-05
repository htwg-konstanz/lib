/**
 * 
 */
package de.fhkn.in.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * A simple UDP Server.
 * @author tzink
 *
 */
public class UDPServer implements Runnable {
	public static int DEFAULT_PORT = 10101;
	public static int DEFAULT_BUFFER_SIZE = 8192;
	
	private final DatagramSocket socket;
	private final DatagramHandler handler;
	
	private final int buffersize;
	
	public UDPServer (int port, int buffersize, DatagramHandler handler) throws SocketException {
		this.buffersize = buffersize;
		this.socket = new DatagramSocket(port);
		this.handler = handler;
	}

	@Override
	public void run() {
		byte[] buffer = new byte[buffersize];
		while (true) {
			DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);
			this.handler.handleDatagram(socket, datagram);
		}
	}
}
