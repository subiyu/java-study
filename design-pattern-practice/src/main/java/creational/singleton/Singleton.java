package creational.singleton;

public class Singleton {
	private static Singleton instance = null;

	private Singleton() {	
	}
	
	// synchronzied로 동시성 문제 해결
	public static synchronized Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		
		return instance;
	}
}
