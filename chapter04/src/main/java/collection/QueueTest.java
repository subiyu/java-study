package collection;

import java.util.LinkedList;
import java.util.Queue;

/** LinkedList가 Queue를 구현하고 있음 **/
public class QueueTest {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		
		q.offer("마이콜");
		q.offer("둘리");
		q.offer("또치");
		
		while(!q.isEmpty()) {
			String s = q.poll();
			System.out.println(s);
		}
		
		// Stack과 다르게 비어있는 경우 null을 반환한다.
		System.out.println(q.poll());
		
		q.offer("마이콜");
		q.offer("둘리");
		q.offer("또치");
		
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
		
	}
}
