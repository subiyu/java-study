package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
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
				//System.out.println(request);
				if(request == null) {
					System.out.println("서버로 부터 연결 끊김");
					break;
				}
				String[] tokens = request.split(":");
				
				if("JOIN".equals(tokens[0])) { //tokens[0]: command
											   //tokens[1]: status
											   //tokens[2]: message
					System.out.println(tokens[2]); //다른 스레드의 IO Stream을 사용해야하므로, printWirter 객체를 전달
				}
				else if("MESSAGE".equals(tokens[0])) { //tokens[0]: command
					   								   //tokens[1]: status
													   //tokens[2]: nickname
													   //tokens[3]: message
					System.out.println(tokens[2] + ":" + tokens[3]);
				}
				else if("Q".equals(tokens[0])) { //tokens[0]: command
					   								//tokens[1]: status
					   								//tokens[2]: message
					System.out.println(tokens[2]);
				} else {
					System.out.println("에러:알 수 없는 요청(" + tokens[0] + ")");
				}
				//System.out.println(request);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
