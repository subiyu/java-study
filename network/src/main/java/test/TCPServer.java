package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

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
			
			
			/* data socket */
			try {				
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");
				
				//System.out.println("연결!!!");
				//4. IO Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					// 5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); //blocking					
					
					if(readByteCount == -1) {
						//클라이언트가 정상적으로 종료(close() 호출)
						System.out.println("[server] closed by client");
						break;
					}
					
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server] received: " + data);

					// 6. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
				}
				
			} catch (SocketException e) {
				System.out.println("[server] suddenly closed by client");
			} catch (IOException e) {
				System.out.println("[server] error: " + e);
			} finally {
				try {
					if(socket != null && !socket.isClosed()) {						
						socket.close();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
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
