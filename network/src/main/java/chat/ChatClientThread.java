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
	//private BufferedReader bufferdReader;
	/* private Socket socket; //통신을 위한 스트림을 얻어오기 위함
	List<Writer> listWriters;

	public ChatClientThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = ChatServer.listWriters;
	}

	@Override
	public void run() {
		synchronized(listWriters) {
			String data = "hello";
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer; //PrintWriter의 메서드를 사용해야하기 때문에 명시적으로 다운 캐스팅
				printWriter.println(data);
				System.out.println(data); //xx님이 참여하였습니다.
				printWriter.flush();
			}
		}
	} */
	
}
