package prob5;
import prob5.MyStackException;

/*
 * String[] buffer
 * buffer = new String[3]
 * top는 0이나 -1이나 맘대로 구현해
 * 꽉 찼으면 늘려야해(resize() 구현: temp = new String[size*2] -> 기존꺼 복사시켜
 */
public class MyStack {
	private String[] buffer;
	private int fullIdx;
	
	public MyStack(int i) {
		buffer = new String[i];
		fullIdx = 0;
	}

	public void push(String s) {
		if(fullIdx >= buffer.length) {
			resize();
		}
		buffer[fullIdx] = s;
		fullIdx ++;
	}
	
	public String pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException();
		}
		String top = buffer[fullIdx-1];
		buffer[fullIdx-1] = null;
		fullIdx --;
		return top;
	}
	
	public int size() {
		return fullIdx;
	}
	
	public void resize() {
		String[] tmp = new String[size() * 2];
		for(int i=0; i<buffer.length; i++) {
			tmp[i] = buffer[i];
		}
		this.buffer = tmp;
	}

	public boolean isEmpty() {
		if(fullIdx == 0) {
			return true;
		} else {
			return false;			
		}
	}
}