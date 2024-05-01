package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. Server Socket 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩(binding)
			// 	  Socket에 InetSocketAddress[InetAddressIpAddress + Port)]를 바인딩한다.
			//	  IPAddress: 0.0.0.0: 특정 호스트 IP(=특정 네트워크 대역)를 바인딩 하지 않는다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10); //포트만 일치하면 다 받겠다															   //10: 백로그(c1과 accept 처리중에 c2가 연결시도하면 백로그라는 queue를 size "10"으로 해놓고 대기시켜
			
			// 3. accept
			Socket socket = serverSocket.accept(); //blocking
			
			System.out.println("연결!!!");
		} catch (IOException e) {
			System.out.println("[server] error: " + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
