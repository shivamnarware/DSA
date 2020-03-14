package BinarySearchTree;

public class BinarySearchTree {
	public class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinarySearchTree(int in[]) {
		root = contruct(in, 0, in.length - 1);
	}

	private Node contruct(int[] in, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node nn = new Node();
		nn.data = in[mid];
		nn.left = contruct(in, lo, mid - 1);
		nn.right = contruct(in, mid + 1, hi);

		return nn;
	}

	public void display() {
		System.out.println("--------------");
		display(root);
		System.out.println("--------------");
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left == null) {
			str = str + ".";
		} else {
			str = str + node.left.data;
		}
		str = str + "->" + node.data + "<-";
		if (node.right == null) {
			str = str + ".";
		} else {
			str = str + node.right.data;
		}
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		int lp = size(node.left);
		int rp = size(node.right);
		return lp + rp + 1;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {
		if (node == null) {
			return -1;
		}
		int lp = ht(node.left);
		int rp = ht(node.right);
		return Math.max(lp, rp) + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		}
		return max(node.right);
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}
		if (item < node.data) {
			return find(node.left, item);
		} else if (node.data > item) {
			return find(node.right, item);
		} else {
			return true;
		}

	}

	public void printinrange(int lo, int hi) {
		printinrange(root, lo, hi);
	}

	private void printinrange(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}
		if (node.data < lo) {
			printinrange(node.right, lo, hi);
		} else if (node.data > hi) {
			printinrange(node.left, lo, hi);
		} else {
			printinrange(node.left, lo, hi);
			System.out.print(node.data + " ");
			printinrange(node.right, lo, hi);
		}

	}

	public void replacewithsumlarger() {
		int sum[] = new int[1];
		replacewithsumlarger(root, sum);
	}

	private void replacewithsumlarger(Node node, int[] sum) {
		if (node == null) {
			return;
		}
		replacewithsumlarger(node.right, sum);
		int temp = node.data;
		node.data = sum[0];
		sum[0] = sum[0] + temp;
		replacewithsumlarger(node.left, sum);
	}

	public void add(int item) {
		add(root, item);
	}

	private void add(Node node, int item) {

		if (item <= node.data) {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			} else {
				add(node.left, item);
			}
		} else {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			} else {
				add(node.right, item);
			}
		}
	}
	

}
