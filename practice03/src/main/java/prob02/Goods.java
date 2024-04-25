package prob02;
//1121

public class Goods {
	private String name;
	private int price;
	private int countStock;
	
	public Goods(String name, int price, int countStock) {
		super();
		this.name = name;
		this.price = price;
		this.countStock = countStock;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	
	public void showGoodsListInfo() {
		System.out.println(
				this.name + "(가격: " +
				this.price + "원)이 " +
				this.countStock + "개 입고 되었습니다.");
	}
}
