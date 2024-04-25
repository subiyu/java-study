package chapter03;

public class GoodsApp {
	public static void main(String[] args) {
		Goods camera = new Goods("nikon", 400000, 10, 20);
		/* camera.setName("nikon");
		camera.setPrice(400000);
		camera.setCountStock(10);
		camera.setCountSold(20); */
		
		//System.out.println("상품이름: " + camera.getName());
		camera.showInfo();

		// 정보은닉(데이터보호) => 필드를 보호하는거야 캡슐화(사용자가 구현체를 몰라도 됨)랑 다름
		//camera.setPrice(-400000);
		
		//static 변수(클래스 변수)
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
		
		System.out.println(camera.calcDiscountPrice(0.5f));
		
		System.out.println(camera.toString());
	}
}
