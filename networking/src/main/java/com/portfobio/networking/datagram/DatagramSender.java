package com.portfobio.networking.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.portfobio.networking.Sender;

public class DatagramSender implements Sender {

	private int port;
	private InetAddress address;

	public DatagramSender(int port, String address) throws UnknownHostException {
		this.port = 9999;
		this.address = InetAddress.getByName(address);
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setAddress(String address) throws UnknownHostException {
		this.address = InetAddress.getByName(address);
	}

	public void send(byte[] data) {
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);

		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			datagramSocket.send(packet);
			datagramSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
