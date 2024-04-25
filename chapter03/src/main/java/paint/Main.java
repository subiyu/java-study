package paint;

public class Main {

	public static void main(String[] args) {
		Point point = new Point(10, 20);
		/* point.setX(10);
		point.setX(20); */
		drawPoint(point);
		point.show(true); // 그리기
		point.show(false); // 지우기
	}
	
	private static void drawPoint(Point point) {
		point.show();
	}
}
