package com.portfobio.networking.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import com.portfobio.networking.Receiver;

public class DatagramReceiver implements Receiver {

	private int port;

	public DatagramReceiver(int port) {
		this.port = port;
	}

	public byte[] receive() {
		try {
			return receivePacket().getData();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private DatagramPacket receivePacket() throws IOException {
		byte[] receiveData = new byte[256];
		DatagramSocket serverSocket = new DatagramSocket(port);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

		serverSocket.receive(receivePacket);
		serverSocket.close();

		return receivePacket;
	}

}
