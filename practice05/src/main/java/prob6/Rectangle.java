package prob6;

public class Rectangle extends Shape implements Resizable {

	public Rectangle(int width, int height) {
		super(width, height);
	}

	@Override
	public void resize(double s) {
		width *= s;
		height *= s;
	}

	@Override
	double getArea() {
		return width * height;
	}

	@Override
	double getPerimeter() {
		return (width + height) * 2;
	}
	
}
