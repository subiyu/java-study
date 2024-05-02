package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoRequestHandler extends Thread {
	private Socket socket;
	
	public EchoRequestHandler(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();
		try {				
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			EchoServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
			
			//System.out.println("연결!!!");
			//4. IO Stream 받아오기
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); //
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			while(true) {
				String data = br.readLine(); //blocking
				
				if(data == null) {
					EchoServer.log("closed by client");
					break;
				}
				
				EchoServer.log("received: " + data);
				pw.println(data);
			}
			
		} catch (SocketException e) {
			EchoServer.log("[server] Socket Exception");
		} catch (IOException e) {
			EchoServer.log("[server] error: " + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {						
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
