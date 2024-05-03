package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
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
		BufferedReader br = null;
		PrintWriter pw = null;
		
		/* Remote Host Information */
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketAddress.getPort();
		ChatServer.log("connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");
		
		try {
			/* 스트림 얻기 */
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			/* 요청 처리 */
			while(true) {
				String request = br.readLine();
				if(request == null) {
					log("클라이언트로 부터 연결 끊김");
					break;
				}
				
				/* 프로토콜 분석 */
				String[] tokens = request.split(":"); //token[0]: command
													  //token[1]: message
		
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], pw); //다른 스레드의 IO Stream을 사용해야하므로, printWirter 객체를 전달
				}
				else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}
				else if("quit".equals(tokens[0])) {
					doQuit(pw);
				} else {
					log("에러:알 수 없는 요청(" + tokens[0] + ")");
				}
			}
		
		} catch (SocketException e) { 
			doQuit(pw);
			log("socket exception"); //클라이언트가 quit 종료가 아닌, 강제종료 했을 때 에러 표시
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
		
		/* writer pool 에 저장(writer pool 에 현재 스레드의 writer를 저장) */
		addWriter(writer);		
		broadcast(data);
		
		// ACK 전송(ack를 보내 방 참여가 성공했다는 것을 클라이언트에게 알려주기)
		PrintWriter printWriter = (PrintWriter)writer;
		printWriter.println("입장하였습니다. 즐거운 채팅 되세요");
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
//			Writer w1 = listWriters.get(0);
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer; //PrintWriter의 메서드를 사용해야하기 때문에 명시적으로 다운 캐스팅
				printWriter.println(data);
				//System.out.println(data); //서버 콘솔에서 확인
				printWriter.flush();
			}
		}
	}

	private void doMessage(String msg) {
		broadcast(nickname + ":" + msg);
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
