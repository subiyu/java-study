package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i=0; i<COUNT_GOODS; i++) {
			String str = scanner.nextLine();
			String[] str2 = str.split(" ");
			String name = str2[0];
			int price = Integer.parseInt(str2[1]);
			int countStock = Integer.parseInt(str2[2]);
			goods[i] = new Goods(name, price, countStock);
		}
		

		// 상품 출력
		for(int i=0; i<goods.length; i++) {
			goods[i].showGoodsListInfo();
		}
		
		// 자원정리
		scanner.close();
	}
}
