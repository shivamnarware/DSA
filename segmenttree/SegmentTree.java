package segmenttree;

public class SegmentTree {
	private class Node {
		int data;
		int si;
		int ei;
		Node left;
		Node right;

		public String toString() {
			return data + " ";
		}
	}

	private Node root;
	private STreeI sti;

	public SegmentTree(int arr[], STreeI sti) {
		this.sti = sti;
		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int low, int high) {
		if (low == high) {
			Node bn = new Node();
			bn.data = arr[low];
			bn.si = low;
			bn.ei = high;
			return bn;
		}
		int mid = (low + high) / 2;
		Node nn = new Node();
		nn.si = low;
		nn.ei = high;
		nn.left = construct(arr, low, mid);
		nn.right = construct(arr, mid + 1, high);
		nn.data = sti.type(nn.left.data, nn.right.data);
		return nn;
	}

	public void display() {
		System.out.println("----------------");
		display(root);
		System.out.println("----------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left;
		}

		str += " -> " + node + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int query(int qsi, int qei) {

		return query(root, qsi, qei);
	}

	private int query(Node node, int qsi, int qei) {
		if (node.si >= qsi && node.ei <= qei) {
			return node.data;
		} else if (node.ei < qsi || qei < node.si) {
			return sti.defaultValue();
		} else {
			int lq = query(node.left, qsi, qei);
			int rq = query(node.right, qsi, qei);
			return sti.type(lq, rq);
		}

	}

	public void update(int idx, int item) {
		update(root, idx, item);
	}

	private void update(Node node, int idx, int item) {

		if (idx == node.si && idx == node.ei) {
			node.data = item;
		} else if (idx >= node.si && idx <= node.ei) {
			update(node.left, idx, item);
			update(node.right, idx, item);

			node.data = sti.type(node.left.data, node.right.data);
		} else {

			// do nothing simply return
		}

	}

}
