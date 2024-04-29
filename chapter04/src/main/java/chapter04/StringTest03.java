package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		//String s1 = "Hello " + "World" + " java " + 17;
		
		String s1 = new StringBuffer("Hello ")
						.append("World")
						.append(" java")
						.append(17)
						.toString();
		
		/* String s1 = new StringBuilder("Hello ")
				.append("World")
				.append(" java")
				.append(17)
				.toString();
		*/
		
		/* 
		 * StringBuilder와 StringBuffer 의 차이
		 * StringBuffer는 동기 처리
		 * StringBUilder는 비동기 처리
		 */
		
		System.out.println(s1);
		
		/* String s2 = "";
		for(int i=0; i<1000000; i++) {
			// s2 += "h";
			s2 = new StringBuffer(s2).append("h").toString();
		} */
		
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<1000000; i++) {
			sb.append("h");
		}
		String s3 = sb.toString();
		
		/* Stromg method들 */
		
		String s4 = "aBcABCabcABc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc", 7)); 
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3, 5));
		
		String s5 = "	ab		cd	  ";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6);
		System.out.println(s7);
		System.out.println("----" + s5.trim() + "----");
		System.out.println("----" + s5.replaceAll(" ", "") + "----");
		
		String[] tokens = s6.split(",");
		for (String s: tokens) {
			System.out.println(s);
		}
		
		String[] tokens2 = s6.split(" ");
		for(String s: tokens2) {
			System.out.println(s);
		}
	} 

}