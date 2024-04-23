package prob5;

public class Prob5 {

	public static void main(String[] args) {
		int idx = 100;
		for(int i=1; i<=99; i++) {
			String str = Integer.toString(i);
			if(str.contains("3") || str.contains("6") || str.contains("9")) {
				System.out.println(i + "짝");
			}
		}
	}
}
