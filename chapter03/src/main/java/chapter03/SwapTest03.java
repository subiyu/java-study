package chapter03;

import mypackage.Value;

public class SwapTest03 {

	public static void main(String[] args) {
		Value i = new Value(10);
		Value j = new Value(20);
		//int i = 10;
		//int j = 20;
		
		System.out.println(i.val + ", " + j.val);
		swap(i, j);
		System.out.println(i.val + ", " + j.val);
		/* System.out.println(i + ", " + j);
		swap(i, j);
		System.out.println(i + ", " + j); */
	}

	private static void swap(Value m, Value n) {
		int tmp = m.val; //tmp 값을 m.val 값으로 바꿔
		m.val = n.val; //m이 가리키고 있는 값은 n.val의 값으로 바꿔
		n.val = tmp;
	}
	/* private static void swap(int m, int n) {
		int tmp = m;
		m = n;
		n = tmp;
	} */
}
