package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {
	//run
	private String nickname; //연결된 클라이언트의 닉네임
	private Socket socket; //통신을 위한 스트림을 얻어오기 위함
	List<Writer> listWriters;
	
	public ChatServerThread(Socket socket) { 
		this.socket = socket;
	}
	
	public ChatServerThread(Socket socket, List<Writer> listWriters) { 
		this.socket = socket;
		this.listWriters = listWriters;
	}
	
	@Override
	public void run() {
		try {
			/* 스트림 얻기 */
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			/* 요청 처리 */
			while(true) {
				String request = br.readLine();
				if(request == null) {
					log("클라이언트로 부터 연결 끊김");
					break;
				}
				
				/* 프로토콜 분석 */
				String[] tokens = request.split(":"); //token[0]: nickname
													  //token[1]: message
				String cmd = tokens[0]; String content = tokens[1];
	
				if("join".equals(cmd)) {
					doJoin(content, pw); //다른 스레드의 IO Stream을 사용해야하므로, printWirter 객체를 전달
				}
				else if("message".equals(cmd)) {
					doMessage(content);
				}
				else if("quit".equals(cmd)) {
					doQuit(pw);
				} else {
					log("에러:알 수 없는 요청(" + cmd + ")");
				}
			}
		
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			//자원 정리
			try{
				if( socket != null && !socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				log( "error:" + ex );
			}
		}
	}
	
	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName; //nickname 을 thread 객체 변수로 저장
		
		String data = nickName + "님이 참여하였습니다.";
		
		/* writer pool 에 저장(writer pool 에 현재 스레드의 writer 인 printWriter를 저장) */
		//WriterPool.addWriter(nickName, writer);
		addWriter(writer);
		
		broadcast(data);
		PrintWriter printWriter = (PrintWriter)writer;
		
		// ACK 전송(ack를 보내 방 참여가 성공했다는 것을 클라이언트에게 알려주기)
		printWriter.println("join:ok");
	}
	
	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}
	
	/* 서버에 연결된 모든 클라이언트에 메시지를 보내는(브로드캐스트)메소드 */
	private void broadcast(String data) {
		// 스레드간 공유 객체인 listWriters 에 접근하기 때문에 동기화 처리 필요
		synchronized(listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer; //PrintWriter의 메서드를 사용해야하기 때문에 명시적으로 다운 캐스팅
				printWriter.println(data);
				System.out.println(data); //xx님이 참여하였습니다.
				printWriter.flush();
			}
		}
	}

	private void doMessage(String msg) {
		broadcast(msg);
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.remove(writer);
		}
	}

	public static void log(String message) {
		System.out.println("[chat server]" + message);
	}
}
