package com0000;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Tomact {

	public static void main(String[] args) throws IOException {
		ServerSocket tomact = new ServerSocket(8080);
		Socket socket = tomact.accept();
		System.out.println("接收到请求");
		InputStream in = socket.getInputStream();
		byte[] buffer = new byte[1024];
		int count;
		count = in.read(buffer);
		System.out.println(new String(buffer,0,count));
		socket.close();
		tomact.close();
	}

}
