package prob5;

public class MyStack02 {
	private Object[] buffer;
	private int fullIdx;
	
	public MyStack02(int i) {
		buffer = new String[i];
		fullIdx = 0;
	}

	public void push(Object s) {
		if(fullIdx >= buffer.length) {
			resize();
		}
		buffer[fullIdx] = s;
		fullIdx ++;
	}
	
	public Object pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		Object top = buffer[fullIdx-1];
		buffer[fullIdx-1] = null;
		fullIdx --;
		return top;
	}
	
	public int size() {
		return fullIdx;
	}
	
	public void resize() {
		Object[] tmp = new String[size() * 2];
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
