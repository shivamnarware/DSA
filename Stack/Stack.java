package Stack;

public class Stack {
	protected int[] data;
	private int tos;

	public Stack() {
		this.data = new int[5]; // default constructor;
		this.tos = -1;
	}

	public Stack(int capacity) {
		this.data = new int[capacity];
		this.tos = -1;
	}

	public void push(int item) throws Exception {
		if (isFull()) {
			throw new Exception("stack is FULL");
		}
		this.tos++;
		this.data[this.tos] = item;

	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("stack is EMPTY");
		}
		int temp = this.data[this.tos];
		this.data[this.tos] = 0;
		this.tos--;
		return temp;
	}

	public int peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is EMPTY");
		}
		int rv = this.data[this.tos];
		return rv;
	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == this.data.length;
	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.println(data[i] + " ");
		}
		System.out.println();
	}

}
