package prob5;

/** 제너릭 클래스 
 * @param <T> **/
public class MyStack03<T> {
	private T[] buffer;
	private int fullIdx;
	
	@SuppressWarnings("unchecked")
	public MyStack03(int i) {
		buffer = (T[])new Object[i];
		fullIdx = 0;
	}

	public void push(T s) {
		if(fullIdx >= buffer.length) {
			resize();
		}
		buffer[fullIdx] = s;
		fullIdx ++;
	}
	
	public T pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		T top = buffer[fullIdx-1];
		buffer[fullIdx-1] = null;
		fullIdx --;
		return top;
	}
	
	public int size() {
		return fullIdx;
	}
	
	@SuppressWarnings("unchecked")
	public void resize() {
		T[] tmp = (T[])new Object[size() * 2];
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
