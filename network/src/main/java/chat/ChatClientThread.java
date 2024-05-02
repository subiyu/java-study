package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatClientThread extends Thread {
	private BufferedReader br;
	private Socket socket; //통신을 위한 스트림을 얻어오기 위함

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			String request = null;
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			while(true) {
				request = br.readLine();
				System.out.println(request);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
