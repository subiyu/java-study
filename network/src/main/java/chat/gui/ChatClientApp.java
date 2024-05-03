package chat.gui;
import java.util.Scanner;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			//소켓 다 열고 조인 진행 여기서 하고 완성되면 채팅 열어
			System.out.println("대화명을 입력하세요.");
			System.out.print(">> ");
			name = scanner.nextLine();
			
			if (!name.isEmpty()) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();

		new ChatWindow(name).show(); //채팅창 띄우기(socket도 넘겨야해) 
	}

}
