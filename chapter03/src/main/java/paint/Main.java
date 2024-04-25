package paint;

public class Main {

	public static void main(String[] args) {
		Point point = new Point(10, 20);
		/* point.setX(10);
		point.setX(20); */
		drawPoint(point);
		//point.show(true); // 그리기
		//point.show(false); // 지우기
		
		ColorPoint point2 = new ColorPoint(100, 200, "red");
		//drawColorPoint(point2);
		drawPoint(point2);
		
		//drawTriangle(new Triangle());
		//drawRectangle(new Rectangle());
		drawShape(new Triangle());
		drawShape(new Rectangle());
		drawShape(new Circle());
	}
	
	private static void drawPoint(Point point) {
		point.show();
	}
	
	/* private static void drawColorPoint(ColorPoint colorPoint) {
		colorPoint.show();
	} */
	
	private static void drawShape(Shape shape) {
		shape.draw();
	}
	
	
	/* private static void drawTriangle(Triangle triangle) {
		triangle.draw();
	}
	
	private static void drawRectangle(Rectangle rectangle) {
		rectangle.draw();
	} */
}
