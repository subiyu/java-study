package chapter04;

public class StringTest02 {

	public static void main(String[] args) {
		// 자바에서 String은 contant pool에 저장되고 이는 immutability(불변성)
		
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		
		s2 = s1.toUpperCase();
		System.out.println(s2);
		
		String s4 = s2.concat("??"); //String("??")를 생성해서 s2랑 concat -> String("ABC??")가 새로 만들어지고 리턴해 -> 이걸 s4가 참조
		System.out.println(s4);
		
		String s5 = "!".concat(s2).concat("@");
		System.out.println(s5);
		
		System.out.println(equalsHello("hello"));
		System.out.println(equalsHello(null));
	}
	
	private static boolean equalsHello(String s) {
		//return s.equals("hello");
		return "hello".equals(s); //권장(매개변수가 null이 들어왔을때도 no error)
	}

}
