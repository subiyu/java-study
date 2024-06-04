package behavioral.templatemethod;

import java.util.Scanner;

@SuppressWarnings("resource")
public class Calculator {
	public void add() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("(val1, val2) > ");
		
		int val1 = scanner.nextInt();
		int val2 = scanner.nextInt();

		int result = val1 + val2;
		
		System.out.println(result);
	}
	
	public void subtract() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("(val1, val2) > ");
		
		int val1 = scanner.nextInt();
		int val2 = scanner.nextInt();
		
		// 체크섬(안 변하는거)
		int result = val1 - val2;
		
		System.out.println(result);
	}
}
