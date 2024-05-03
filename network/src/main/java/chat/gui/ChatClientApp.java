package chat.gui;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import chat.ChatServer;

public class ChatClientApp {
	private static final String SERVER_IP = "192.168.0.173";

	public static void main(String[] args) {		
		String name = null;
		Scanner scanner = null;
		Socket socket = null;
		
		try {
			scanner = new Scanner(System.in);
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			while( true ) {
				//소켓 다 열고 조인 진행 여기서 하고 완성되면 채팅 열어
				System.out.println("대화명을 입력하세요.");
				System.out.print(">> ");
				name = scanner.nextLine();
				pw.println("join:" + name);

				if (!name.isEmpty()) {
					break;
				}
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
			
			new ChatWindow(name, socket).show(); //채팅창 띄우기 
			
			scanner.close();
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
