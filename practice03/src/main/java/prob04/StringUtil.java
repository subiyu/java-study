package prob04;

public class StringUtil {
	public static String concatenate(String[] strArr) {
		String result = "";
		
		for(int i=0; i<strArr.length; i++) {
			result = result.concat(strArr[i]);
		}
		
		return result;
	}
}
