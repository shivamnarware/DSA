package generictree;

import java.util.*;

public class GenericTree {
	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
	}

	private Node root;

	public GenericTree() {
		root = takeinput(null, -1);
	}

	private Node takeinput(Node parent, int ith) {
		if (parent == null) {
			System.out.println("enter the data for the root node");
		} else {
			System.out.println("enter the data for the " + ith + " child of" + parent.data);
		}

		int item = scn.nextInt();
		Node nn = new Node();
		nn.data = item;
		System.out.println("Enter the no. of children of" + nn.data);
		int noc = scn.nextInt();
		for (int i = 0; i < noc; i++) {
			Node child = takeinput(nn, i);
			nn.children.add(child);

		}
		return nn;

	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		String str = node.data + "->";
		for (Node child : node.children) {
			str += child.data + ",";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		int ts = 0;
		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}
		return ts + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int tm = node.data;
		for (Node child : node.children) {
			int cm = max(child);
			if (cm > tm) {
				tm = cm;
			}
		}
		return tm;

	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int ht = -1;
		for (Node child : node.children) {
			int ch = height(child);
			if (ch > ht) {
				ht = ch;
			}
		}
		return ht + 1;
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {
		if (node.data == item) {
			return true;
		}
		for (Node child : node.children) {
			boolean cf = find(child, item);
			if (cf) {
				return true;
			}

		}
		return false;

	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);
		}

		int i = 0;
		int j = node.children.size() - 1;
		while (i < j) {
			Node ith = node.children.get(i);
			Node jth = node.children.get(j);
			node.children.set(i, jth);
			node.children.set(j, ith);
			i++;
			j--;

		}

	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}

		while (node.children.size() > 1) {
			Node firstindex = node.children.remove(1);
			Node tail = gettail(node.children.get(0));
			tail.children.add(firstindex);
		}

	}

	private Node gettail(Node node) {
		if (node.children.size() == 0) {
			return node;
		}
		return gettail(node.children.get(0));
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {
		System.out.println(node.data);
		for (Node child : node.children) {
			preorder(child);
		}

	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {
		for (Node child : node.children) {
			preorder(child);
		}
		System.out.println(node.data);

	}

	public void levelorder() {
		levelorder(root);
	}

	private void levelorder(Node node) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(node);
		while (!queue.isEmpty()) {
			Node rn = queue.remove();
			System.out.print(rn.data + " ");
			for (Node rnp : rn.children) {
				queue.addLast(rnp);
			}
		}
		System.out.println();

	}

	public void printAtlevel(int level) {
		printAtlevel(root, level, 0);
	}

	private void printAtlevel(Node node, int level, int count) {
		if (level == count) {
			System.out.println(node.data);
			return;
		}

		for (Node child : node.children) {
			printAtlevel(child, level, count + 1);
		}

	}

	public void levelorderlevelwise() {
		levelorderlevelwise(root);
	}

	private void levelorderlevelwise(Node node) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(node);
		queue.addLast(null);
		while (!queue.isEmpty()) {
			Node rn = queue.remove();
			if (rn == null) {
				System.out.println();
				if (queue.isEmpty()) // if it is the last null;
					break;
				queue.addLast(null);
				continue;
			}

			System.out.print(rn.data + " ");
			for (Node rnp : rn.children) {
				queue.addLast(rnp);
			}
		}

	}

	public void levelorderlw2() {
		levelorderlw2(root);
	}

	private void levelorderlw2(Node node) {
		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();
		primary.addLast(node);
		while (!primary.isEmpty()) {
			Node rn = primary.removeFirst();
			System.out.print(rn.data + " ");
			for (Node rnp : rn.children) {
				helper.addLast(rnp);
			}
			if (primary.isEmpty()) {
				System.out.println();
				primary = helper;
				helper = new LinkedList<>();

			}

		}

	}

	public void zigzagtraversal() {
		zigzagtraversal(root);
	}

	private void zigzagtraversal(Node node) {
		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();
		primary.addFirst(node);
		int count = 0;
		while (!primary.isEmpty()) {
			Node rn = primary.removeFirst();
			System.out.print(rn.data + " ");
			if (count % 2 == 0) {
				for (Node rnp : rn.children) {
					helper.addFirst(rnp);
				}

			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					helper.addFirst(rn.children.get(i));
				}
			}
			if (primary.isEmpty()) {
				System.out.println();
				count++;
				primary = helper;
				helper = new LinkedList<>();
			}

		}
    }

}
