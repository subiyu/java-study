package behavioral.iterator;

/* 
 * 연관: 타 클래스가 직접적인 객체로 활동하는 경우 ex)생성자 호출
 * 의존: 타 클래스의 메서드만 사용
 *  */
public class Client {

	public static void main(String[] args) {
		Aggregate<String> fruits = new AggregateImpl<>(new String[] {"Mango", "Banana", "Apple"});
		Iterator<String> it = fruits.createIterator();
		
		while(it.hasNext()) {
			String fruit = it.next();
			System.out.println(fruit);
		}
	}

}
