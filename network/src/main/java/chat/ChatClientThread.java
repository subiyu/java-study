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
	private Socket socket; //통신을 위한 스트림을 얻어오기 위함
	List<Writer> listWriters;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			this.listWriters = ChatServer.listWriters;
			//System.out.println("pppppppppppppppp");
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			String request = br.readLine();
			System.out.println("size: " + listWriters.size());
			System.out.println(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* System.out.println("gkgkgkgkkg" + listWriters);
		synchronized(listWriters) {
			String data = "hello";
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer; //PrintWriter의 메서드를 사용해야하기 때문에 명시적으로 다운 캐스팅
				printWriter.println(data);
				System.out.println(data); //xx님이 참여하였습니다.
				printWriter.flush();
			}
		} */
	}
	
}
