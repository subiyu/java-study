package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 6000;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. Server Socket 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩(binding)
			// 	  Socket에 InetSocketAddress[InetAddressIpAddress + Port)]를 바인딩한다.
			//	  IPAddress: 0.0.0.0: 특정 호스트 IP(=특정 네트워크 대역)를 바인딩 하지 않는다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10); //포트만 일치하면 다 받겠다															   //10: 백로그(c1과 accept 처리중에 c2가 연결시도하면 백로그라는 queue를 size "10"으로 해놓고 대기시켜
			
			// 3. accept
			Socket socket = serverSocket.accept(); //blocking
			
			/* data socket */
			try {				
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
				
				//System.out.println("연결!!!");
				//4. IO Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); //
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				
				while(true) {
					String data = br.readLine(); //blocking
					
					if(data == null) {
						log("closed by client");
						break;
					}
					
					log("received: " + data);
					pw.println(data);
				}
				
			} catch (SocketException e) {
				log("[server] suddenly closed by client");
			} catch (IOException e) {
				log("[server] error: " + e);
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
			log("[server] error: " + e);
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
	
	private static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}
}
