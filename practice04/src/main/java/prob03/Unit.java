package prob03;

public abstract class Unit {
	// 현재 위치
	private int x;
	private int y;
	
	public abstract void move(int x, int y);
	public abstract void stop();
}
