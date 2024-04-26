package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		System.out.println(" Some Code 1 ...");
		try {
			System.out.println(" Some Code 2 ...");
			System.out.println(" Some Code 3 ...");
			
			int result = (1 + 2 + 3) / b;		
			
			System.out.println(" Some Code 4 ...");
			System.out.println(" Some Code 5 ...");
			
		} catch(ArithmeticException ex) {
			/* 예외 처리 */
			//ex.printStackTrace(); //예외 처리 어떻게 하는 ㅣ지 모를 때
			// 로깅
			System.out.println("erorr: " + ex);
			
			// 2. 사과
			
			// 3. 정상종료
			//System.exit(0)
			return;
		} finally {
			
			System.out.println("자원 정리: ex) closeFoile, socket, ");
		}
		
		System.out.println(" Some Code 6 ...");
		System.out.println(" Some Code 7 ...");
	}

}
