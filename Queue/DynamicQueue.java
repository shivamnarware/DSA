package Queue;

public class DynamicQueue extends Queue {
	@Override
	public void enqueue(int item) throws Exception {
		if (isFull()) {
			int na[] = new int[2 * data.length];
			for (int i = 0; i < data.length; i++) {
				na[i] = data[i];
			}
			data = na;
		}

		super.enqueue(item);
	}

}
