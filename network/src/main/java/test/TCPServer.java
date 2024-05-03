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
			
			// 1-1. FIN-WAIT2 -> TIME_WAIT 상태에서도 소켓 포트 할당이 가능하도록 하기 위해
			serverSocket.setReuseAddress(true);
						
			// 2. 바인딩(binding)
			// 	  Socket에 InetSocketAddress[InetAddressIpAddress + Port)]를 바인딩한다.
			//	  IPAddress: 0.0.0.0: 특정 호스트 IP(=특정 네트워크 대역)를 바인딩 하지 않는다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10); //포트만 일치하면 다 받겠다															   //10: 백로그(c1과 accept 처리중에 c2가 연결시도하면 백로그라는 queue를 size "10"으로 해놓고 대기시켜
			
			// 3. accept
			Socket socket = serverSocket.accept(); //blocking
			
			
			/* data socket */
			try {				
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress(); //inetRemoteSocketAddress.getAddress()는 InetSocketAddress 객체를 반환
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
														 //read()함수는 주어진 버퍼에 최대 256바이트의 데이터를 읽고 실제로 읽은 바이트 수를 반환한다.
					if(readByteCount == -1) {
						//클라이언트가 정상적으로 종료(close() 호출)
						System.out.println("[server] closed by client");
						break;
					}
					
					String data = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[server] received: " + data);
					
					// 6. 데이터 쓰기
					/* try {
						Thread.sleep(3000); // SO_TIMEOUT 테스트
					} catch (InterruptedException e) {
						 e.printStackTrace();
					} */
					
					os.write(data.getBytes("utf-8"));
				}
				
			} catch (SocketException e) {
				System.out.println("[server] Socket Exception"); //상대방 연결 끊어짐(보통 read 할 때 발생)
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
