package structural.decorator;

public class Client {
	public static void main(String[] args) {
		System.out.println(new ConcretComponent("Hello World").operation());
		
		// ConcretComponent -> BracesDecorator
		System.out.println(new BracesDecorator(new ConcretComponent("Hello World")).operation());
		
		// ConcretComponent -> ParenthesesDecorator
		System.out.println(new ParenthesesDecorator(new ConcretComponent("Hello World")).operation());
		
		// ConcretComponent(주 스트림) -> ParenthesesDecorator(보조 스트림: 데코 1) -> BracesDecorator(보조 스트림: 데코 2)
		System.out.println(new ParenthesesDecorator(new BracesDecorator(new ConcretComponent("Hello World"))).operation());
		
		// ConcretComponent -> BracesDecorator(데코 2) -> ParenthesesDecorator(데코 1)
		System.out.println(new BracesDecorator(new ParenthesesDecorator(new ConcretComponent("Hello World"))).operation());
		
	}
}
