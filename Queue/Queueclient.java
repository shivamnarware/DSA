package Queue;

public class Queueclient {

	public static void main(String[] args) throws Exception {
		DynamicQueue queue = new DynamicQueue();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(10 * i);
		}
		queue.display();
		queue.dequeue();
		queue.display();
//		actualreverse(queue);
//		queue.display();
		displayreverse(queue, 0);
		int arr[] = { 2, -3, 5, 6, -2, -9, -4, 10, 15 };
		firstnegativeinteger(arr, 4);

	}

	public static void actualreverse(DynamicQueue queue) throws Exception {
		if (queue.isEmpty()) {
			return;
		}
		int temp = queue.dequeue();
		actualreverse(queue);
		queue.enqueue(temp);

	}

	public static void displayreverse(DynamicQueue queue, int c) throws Exception {
		if (c == queue.size()) {
			return;
		}
		int temp = queue.dequeue();
		queue.enqueue(temp);
		displayreverse(queue, c + 1);
		System.out.print(temp + " ");

	}

	public static void firstnegativeinteger(int arr[], int k) throws Exception {
		DynamicQueue queue = new DynamicQueue();
		for (int i = 0; i < k; i++) {
			if (arr[i] < 0) {
				queue.enqueue(i);
			}
		}
		for (int i = 1; i <= arr.length - k; i++) {
			if (queue.isEmpty()) {
				System.out.println("0");
			} else {
				System.out.print(arr[queue.getFront()] + " ");
			}
			if (!queue.isEmpty() && queue.getFront() < i) {
				queue.dequeue();
			}
			if (arr[i + k - 1] < 0) {
				queue.enqueue(i + k - 1);
			}
		}

	}

}
