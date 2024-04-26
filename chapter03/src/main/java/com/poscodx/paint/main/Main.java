package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rectangle;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
import com.poscodx.paint.text.GraphicText;

public class Main {

	public static void main(String[] args) {
		Point point = new Point(10, 20);
		/* point.setX(10);
		point.setX(20); */
		//drawPoint(point);
		draw(point);
		
		//point.show(true); // 그리기
		//point.show(false); // 지우기
		
		ColorPoint point2 = new ColorPoint(100, 200, "red");
		//drawColorPoint(point2);
		//drawPoint(point2);
		draw(point2);
		
		//drawTriangle(new Triangle());
		//drawRectangle(new Rectangle());
		/*drawShape(new Triangle());
		drawShape(new Rectangle());
		drawShape(new Circle());*/
		draw(new Triangle());
		draw(new Rectangle());
		draw(new Circle());
		
		draw(new GraphicText("Hello World"));
		
		//instanceof 연산자
		Circle c = new Circle();
		System.out.println(c instanceof Circle);
		System.out.println(c instanceof Shape);
		System.out.println(c instanceof Object);
		System.out.println(c instanceof Drawable); //연산자 우측항이 인터페이스인 경우 Hieracy 상관없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(c instanceof Runnable); //우측항이 인터페이스이면 기능구현에 대한 확인(Runnable 기능 사용하고 있지 않으므로 결과는 false)
		
		//error: 연산자 우측항이 클래스인 경우,
		//		 레퍼런스 하고 있는 class 타입의 hierachy 상의 상위 or 하위만
		//		 instanaceof 연산자 사용 가능
		//System.out.println(c instanceof Point);
		
		Object o = new Object();
		System.out.println(o instanceof String); //결과값은 false. 우측항이 상위클래스여야 true를 반환함.
		System.out.println(o instanceof Shape);
		System.out.println(o instanceof Circle);
	}
	
	private static void draw(Drawable drawable) {
		drawable.draw();
	}
	
	/* private static void drawPoint(Point point) {
		point.show();
	} */
	
	/* private static void drawColorPoint(ColorPoint colorPoint) {
		colorPoint.show();
	} */
	
	/* private static void drawShape(Shape shape) {
		shape.draw();
	} */
	
	
	/* private static void drawTriangle(Triangle triangle) {
		triangle.draw();
	}
	
	private static void drawRectangle(Rectangle rectangle) {
		rectangle.draw();
	} */
}
