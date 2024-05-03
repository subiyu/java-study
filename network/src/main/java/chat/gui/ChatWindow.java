package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	//printWriter랑 ,br 를 변수로 가지고 있던가, socket을 갖던가

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				//System.out.println("click!!!");
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		/* enter 눌렀을 때도 send 보내기 */
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
	
		});		

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		//IOStream 받아오기
		//ChatClientThread 생성
	}
	
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메세지 보내는 프로토콜 구현!: " + message);
		
		textField.setText(""); //send 후 텍스트 창 비우기
		textField.requestFocus(); //포커스 텍스트 입력창으로 되돌리기
	
		// ChatClientThread 에서 서버로부터 받은 메세지가 있다고 치고!!!
		updateTextArea("마이콜:밥먹으러 가자");
		//updateTextArea("마이콜:" + message);
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	/* TextArea에 접근해야하므로 ChatClientThread를 inner class로 정의 */
	private class ChatClientThread extends Thread {
		public void run() {
			// String message = br.readline();
			//TextArea에 message TextArea에 뿌려야해
		}
	}
	
	private void finish() {
		// quit protocol 구현
		
		
		// exit java application
		System.exit(0);
	}
}
