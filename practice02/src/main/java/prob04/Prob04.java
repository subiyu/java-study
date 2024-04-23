package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		int length = str.length();
		char[] before = new char[length];
		char[] after = new char[length];
		before = str.toCharArray();
		
		for(int i=0; i<length; i++) {
			after[i] = before[length-(i+1)];
		}
		return after;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		//System.out.println(array.toString());
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println("");
	}
}