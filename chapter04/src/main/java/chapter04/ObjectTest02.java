package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20); //레퍼런스 변수를 1000으로 가정
		Point p2 = new Point(10, 20); //레퍼런스 변수를 2000으로 가정
		Point p3 = p2; 				  //2000
		
		// == : 두 객체의 동일성
		System.out.println(p1 == p2); //false
		System.out.println(p2 == p3); //true
		
		// equals() : 두 객체의 동질성(내용 비교)
		//			  부모 클래스 Object의 기본 구현은 동일성(==) 비교와 같다.
		System.out.println(p1.equals(p2)); //**false!!** equals() 까보면 객체 동일성 비교하고 있음
										   //true 반환하고 싶다면? equals()를 오버라이딩 해
		System.out.println(p2.equals(p3)); //true
	}

}
