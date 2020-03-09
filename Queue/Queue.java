package Queue;

public class Queue {
	protected int[] data;
	private int size;
	private int front;

	public Queue() {
		this.data = new int[5];
		this.size = 0;
		this.front = 0;
	}

	public Queue(int cap) {
		this.data = new int[cap];
		this.size = 0;
		this.front = 0;
	}

	public void enqueue(int item) throws Exception {
		if (isFull()) {
			throw new Exception("Queue is Full");
		}
		int idx = (front + size) % data.length;
		data[idx] = item;
		size++;
	}

	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		int rv = data[front];
		data[front] = 0;
		front = (front + 1) % data.length;
		size--;
		return rv;
	}

	public int getFront() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		int rv = data[front];
		return rv;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {

		return size == data.length;

	}

	public void display() {
		for (int i = 0; i < size; i++) {
			int idx = (front + i) % data.length;
			System.out.print(data[idx] + " ");
		}
		System.out.println();
	}

}
