package prob6;

public abstract class Shape {
	protected double width;
	protected double height;
	
	abstract double getArea(); //넓이
	abstract double getPerimeter(); //둘레 길이
	
	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
}
