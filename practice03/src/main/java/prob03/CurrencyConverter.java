package prob03;

public class CurrencyConverter {
	private static int rate;

	public static void setRate(int i) {
		rate = i;
	}

	public static double toDollar(double d) {
		return 1.0 / rate * d;
	}

	public static double toKRW(double d) {
		return d * rate;
	}

}
