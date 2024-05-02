package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import echo.EchoServer;

public class ChatClient {
	private static final String SERVER_IP = "192.168.0.173";
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
			//1. 키보드 연결
			scanner = new Scanner(System.in);
			
			//2. socket 생성
			socket = new Socket();
			
			//3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			//4. reader/writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); //
			
			//5. join 프로토콜 호출
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			//pw.flush();
			System.out.println("입장하였습니다. 즐거운 채팅 되세요");
			//System.out.println("률류" + ChatServer.listWriters.size());
			
			//6. ChatClientReceiveThread 시작
			new ChatClientThread(socket).start();
			
			//7. 키보드 입력 처리
			while(true) {
				String input = scanner.nextLine();
				if("quit".equals(input)) {
					//8. quit 프로토콜 처리
					pw.println("quit:");
					pw.flush();
					break;
				} else {
					//9. 메시지 처리
					System.out.println(nickname + ":" + input);
					pw.println("message:" + input);
					/* String data = br.readLine(); //blocking
					if(data == null) {
						log("suddenly closed by server");
						break;
					} */
				}
			}
		} catch(IOException ex) {
			log("error:" + ex);
		} finally {
			//10. 자원정리
			try {
				if (socket != null && !socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException ex) {
				log("error:" + ex);
			}
		}
	}

	public static void log(String message) {
		System.out.println("[chat client]" + message);
	}
}
