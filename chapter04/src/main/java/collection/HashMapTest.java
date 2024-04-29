package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// ** Map의 key는 불변객체로 ! ** //
public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
		
		m.put("one", 1); //auto boxing(int 인 1을 Integer로 변환)
		m.put("two", 2);
		m.put("three", 3);
		
		int i = m.get("one"); //auto unboxing(Integer -> int)
		int j = m.get(new String("one"));
		System.out.println(i + ":" + j);
		
		m.put("three", 3333);
		System.out.println(m.get("three"));
		
		// 순회
		Set<String> s = m.keySet();
		for(String key : s) {
			System.out.println(m.get(key));
		}
	}

}
