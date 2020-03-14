package BinaryTree;

import java.util.*;

public class BinaryTree {
	static Scanner scn = new Scanner(System.in);

	class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		root = contruct(null, false);
	}

	private Node contruct(Node parent, boolean ilc) {
		if (parent == null) {
			System.out.println("enter the data for the parent");
		} else {
			if (ilc) {
				System.out.println("enter the data for the left child  of" + parent.data);
			} else {
				System.out.println("enter the data for the right child  of" + parent.data);
			}
		}
		int item = scn.nextInt();
		Node nn = new Node();
		nn.data = item;
		System.out.println(nn.data + "has left child?");
		boolean hlc = scn.nextBoolean();
		if (hlc) {
			nn.left = contruct(nn, true);
		}
		System.out.println(nn.data + "has rigth child?");
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			nn.right = contruct(nn, false);
		}

		return nn;
	}

	public void display() {
		display(root);
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

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return 0;
		}
		int lp = max(node.left);
		int rp = max(node.right);

		return Math.max(node.data, Math.max(lp, rp));
	}

	public int heigth() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		int lp = height(node.left);
		int rp = height(node.right);
		return Math.max(lp, rp) + 1;

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}
		if (node.data == item) {
			return true;
		}
		return find(node.left, item) || find(node.right, item);

	}

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int ld = diameter(node.left);
		int rd = diameter(node.right);
		int ht = height(node.left) + height(node.right) + 2;
		return Math.max(ht, Math.max(ld, rd));

	}

	public class diapair {
		int diameter = 0;
		int ht = -1;

		@Override
		public String toString() {
			return "Dia: " + diameter + " Ht:" + ht;
		}
	}

	public diapair diameter2() {
		return diameter2(root);
	}

	private diapair diameter2(Node node) {
		if (node == null) {
			return new diapair();
		}
		diapair ldp = diameter2(node.left);
		diapair rdp = diameter2(node.right);

		diapair sdp = new diapair();
		int np = ldp.ht + rdp.ht + 2;
		sdp.diameter = Math.max(np, Math.max(ldp.ht, rdp.ht));
		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		return sdp;
	}

	public boolean isbalanced() {
		return isbalanced(root);
	}

	private boolean isbalanced(Node node) {
		if (node == null) {
			return true;
		}
		boolean lp = isbalanced(node.left);
		boolean rp = isbalanced(node.right);

		int ht = height(node.left) - height(node.right);
		if ((ht == 1 || ht == -1 || ht == 0) && lp && rp) {
			return true;
		}
		return false;

	}

	public class balpair {
		int ht = -1;
		boolean isbal = true;
	}

	public balpair isbalanced2() {
		return isbalanced2(root);
	}

	private balpair isbalanced2(Node node) {
		if (node == null) {
			return new balpair();
		}
		balpair lp = isbalanced2(node.left);
		balpair rp = isbalanced2(node.right);

		balpair nn = new balpair();
		int bf = lp.ht - rp.ht;
		if ((bf == 0 || bf == -1 || bf == 1) && lp.isbal && rp.isbal) {
			nn.isbal = true;
		} else {
			nn.isbal = false;
		}
		nn.ht = Math.max(lp.ht, rp.ht) + 1;
		return nn;

	}

	public class depthpair {
		int ht = -1;
		Node temp;
	}

	public depthpair deepestdepth() {
		return deepestdepth(root);
	}

	private depthpair deepestdepth(Node node) {
		if (node == null) {
			return new depthpair();
		}
		depthpair lp = deepestdepth(node.left);
		depthpair rp = deepestdepth(node.right);

		depthpair sdp = new depthpair();
		if (lp.ht > rp.ht) {
			sdp.temp = lp.temp;
		} else if (rp.ht > lp.ht) {
			sdp.temp = rp.temp;
		} else {
			sdp.temp = node;
		}
		sdp.ht = Math.max(lp.ht, rp.ht) + 1;
		return sdp;

	}

	public boolean flipequivalent(BinaryTree other) {
		return flipequivalent(this.root, other.root);
	}

	private boolean flipequivalent(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		if (node1.data != node2.data) {
			return true;
		}
		boolean r1 = flipequivalent(node1.left, node2.left);
		boolean r2 = flipequivalent(node1.right, node2.right);
		boolean r3 = flipequivalent(node1.left, node2.right);
		boolean r4 = flipequivalent(node1.right, node2.left);

		return (r1 && r2) || (r3 && r4);

	}

	public BinaryTree(int pre[], int in[]) {
		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
		if (plo > phi || ilo > ihi) {
			return null;
		}
		Node nn = new Node();
		nn.data = pre[plo];
		int si = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (in[i] == pre[plo]) {
				si = i;
				break;
			}
		}
		int nel = si - ilo;
		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);

		return nn;
	}

	private int ans[] = new int[1];

	public int maxsumpath() {
		return maxsumpath(root, ans);
	}

	private int maxsumpath(Node node, int ans[]) {
		if (node == null) {
			return 0;
		}
		int lp = maxsumpath(node.left, ans);
		int rp = maxsumpath(node.right, ans);
		int sp = lp + rp + node.data;
		if (sp > ans[0]) {
			ans[0] = sp;
		}
		return Math.max(lp, rp) + node.data;

	}

	public int subtreesum() {
		int ans[] = new int[1];
		subtreesum(root, ans);
		return ans[0];
	}

	private int subtreesum(Node node, int[] ans) {
		if (node == null) {
			return 0;
		}
		int lp = subtreesum(node.left, ans);
		int rp = subtreesum(node.right, ans);

		int sp = lp + rp + node.data;
		if (sp > ans[0]) {
			ans[0] = sp;
		}
		return sp;

	}

	public class VOpair {
		int data;
		int vl;
		int hl;

		@Override
		public String toString() {

			return this.data + " ";
		}

	}

	public void verticalorder() {
		HashMap<Integer, ArrayList<VOpair>> map = new HashMap<Integer, ArrayList<VOpair>>();
		verticalorder(root, 0, 0, map);
		ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
		Collections.sort(keys);
		System.out.println(keys);
		for (int key : keys) {
			Collections.sort(map.get(key), new VOcomaparator());
			System.out.println(key + "->" + map.get(key));
		}

	}

	private class VOcomaparator implements Comparator<VOpair> {

		public int compare(VOpair o1, VOpair o2) {

			return o1.hl - o2.hl;
		}

	}

	private void verticalorder(Node node, int vlevel, int hlevel, HashMap<Integer, ArrayList<VOpair>> map) {
		if (node == null) {
			return;
		}
		if (!map.containsKey(vlevel)) {
			map.put(vlevel, new ArrayList<VOpair>());
		}
		VOpair np = new VOpair();
		np.data = node.data;
		np.vl = vlevel;
		np.hl = hlevel;
		map.get(vlevel).add(np);
		verticalorder(node.left, vlevel - 1, hlevel + 1, map);
		verticalorder(node.right, vlevel + 1, hlevel + 1, map);

	}

}
