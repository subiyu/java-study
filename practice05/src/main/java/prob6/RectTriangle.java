package prob6;

public class RectTriangle extends Shape {

	public RectTriangle(int width, int height) {
		super(width, height);
	}

	@Override
	double getArea() {
		return width * height;
	}

	@Override
	double getPerimeter() {
		double hypotenuse = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
		return width + height + hypotenuse;
	}
	
}
