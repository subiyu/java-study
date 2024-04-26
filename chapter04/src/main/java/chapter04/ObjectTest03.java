package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println(s1 == s2); //false
		System.err.println(s1.equals(s2)); //true 
		System.err.println(s1.hashCode() + ":" + s2.hashCode()); // 같음
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2)); //s1의 진짜 주소기반의 해쉬값 뽑기
	
		System.out.println("===============================================");
		
		String s3 = "hello";
		String s4 = "hello";
		
		System.out.println(s3 == s4); //***true***
									  //s3에서 상수풀(constant pool)(상수 저장소->테이블) 찾아봐 "hello"가 없네? -> 컴파일러가 자동으로 new String("hello") 하고 레퍼런스와 함꼐 테이블에 저장해
									  //s4는 테이블에 있네? s3의 레퍼런스 참조 => 그래서 같아지는거야
		System.out.println(s3.equals(s4)); //true
		System.err.println(s3.hashCode() + ":" + s4.hashCode());
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4));
	}

}
