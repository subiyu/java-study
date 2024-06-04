package behavioral.templatemethod;

public class Client {

	public static void main(String[] args) {
		new Calculator().add();
		new Calculator().subtract();		
		
		AbstractCalculator ac = new MultiplyCalculate();
		ac.templateMethod();
	
		ac = new DivideCalculate();
		ac.templateMethod();
	}

}
