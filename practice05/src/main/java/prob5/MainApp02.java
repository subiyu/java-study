package prob5;

public class MainApp02 {

	public static void main(String[] args) {
		try {
			MyStack02 stack = new MyStack02(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			//stack.push(111); //error line: 11
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {
				//Object s = stack.pop(); //여러가지 자료형 관리하는것은 지양
				String s = (String)stack.pop(); //다운 캐스팅으로 하나의 자료형 관리 강제
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack02(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());
			
		} catch ( MyStackException ex) {
			System.out.print( ex );
		}
	}

}
