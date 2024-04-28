package prob05;

public class Prob05 {

	//메인 건들지마!(오버라이드 여러개 받든 어떻게든 출력만 나오면댕)
	public static void main(String[] args) {
		Base base = new MyBase();

		base.service("낮");
		base.service("밤");
		base.service("오후"); 
	}
}
