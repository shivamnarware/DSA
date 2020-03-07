package linkedlist;

import java.util.Stack;

public class Linkedlist {
	private class Node {
		int data;
		Node nxt;

		Node(int d) {
			data = d;
			nxt = null;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
 

	public int getFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("LL is empty");
		}
		return head.data;
	}

	public int getLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("LL is empty");
		}
		return tail.data;
	}

	public int GetAt(int k) throws Exception {
		if (isEmpty()) {
			throw new Exception("LL is empty");
		}
		if (k < 0 || k >= size) {
			throw new Exception("Invalid index");
		}
		Node temp = head;
		for (int i = 0; i < k; i++) {
			temp = temp.nxt;
		}
		return temp.data;
	}

	public Node GetNodeAt(int k) throws Exception {
		if (isEmpty()) {
			throw new Exception("LL is empty");
		}
		if (k < 0 || k >= size) {
			throw new Exception("Invalid index");
		}
		Node temp = head;
		for (int i = 0; i < k; i++) {
			temp = temp.nxt;
		}
		return temp;
	}

	public void display() {
		Node temp = head;
		System.out.println("--------------");
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.nxt;
		}
		System.out.println();
		System.out.println("--------------");

	}

	public void addLast(int item) throws Exception {
		Node nn = new Node(item);
//		nn.data = item;
		nn.nxt = null;
		if (!isEmpty()) {
			tail.nxt = nn;
		}
		if (isEmpty()) {
			head = nn;
			tail = nn;
			size++;
		} else {
			tail = nn;
			size++;
		}

	}

	public void addFirst(int item) throws Exception {
		Node nn = new Node(item);
		nn.data = item;
		nn.nxt = null;

		nn.nxt = head;

		if (isEmpty()) {
			head = nn;
			tail = nn;
			size++;
		} else {
			head = nn;
			size++;
		}

	}

	public void addAt(int item, int k) throws Exception {
		Node nn = new Node(item);
		nn.data = item;
		nn.nxt = null;

		if (k == 0) {
			addFirst(item);
		}
		if (k == size - 1) {
			addLast(item);
		}
		if (k < 0 || k >= size) {
			throw new Exception("Invalid index");
		} else {
			Node pn = GetNodeAt(k - 1);
			Node nextnn = pn.nxt;
			pn.nxt = nn;
			nn.nxt = nextnn;
			size++;
		}
	}

	public int removeFirst() throws Exception {
		if (size == 0) {
			throw new Exception("LL is empty");
		}
		int rv = head.data;
		if (size == 1) {
			head = null;
			tail = null;
			size--;
		} else {
			head = head.nxt;
			size--;
		}
		return rv;

	}

	public int removeLast() throws Exception {
		if (size == 0) {
			throw new Exception("LL is empty");
		}
		int rv = tail.data;
		if (size == 1) {
			head = null;
			tail = null;
			size = 0;
		} else {
			Node nn = GetNodeAt(size - 2);
			nn.nxt = null;
			tail = nn;
			size--;

		}
		return rv;
	}

	public int removeAt(int k) throws Exception {
		if (k == 0) {
			removeFirst();
		}
		if (k == size - 1) {
			removeLast();
		}
		if (k < 0 || k >= size) {
			throw new Exception("Invalid index");
		} else {
			Node pn = GetNodeAt(k - 1);
			Node cn = GetNodeAt(k);
			pn.nxt = cn.nxt;
			size--;
			return cn.data;
		}
	}

	public void reverseDI() throws Exception {
		if (size == 0) {
			throw new Exception("LL is empty");
		}
		int left = 0;
		int right = size() - 1;
		while (left < right) {
			Node ln = GetNodeAt(left);
			Node rn = GetNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;
		}

	}

	public void reversePI() throws Exception {
		if (size == 0) {
			throw new Exception("LL is empty");
		}
		Node p = head;
		Node c = head.nxt;
		while (c != null) {
			Node a = c.nxt;
			c.nxt = p;
			p = c;
			c = a;

		}
		Node temp = head;
		head = tail;
		tail = temp;

		tail.nxt = null;

	}

	public void reversePR() {
		reversePR(head, head.nxt);
		Node temp = head;
		head = tail;
		tail = temp;

		tail.nxt = null;

	}

	private void reversePR(Node prev, Node curr) {

		if (curr == null) {
			return;
		}
		reversePR(curr, curr.nxt);
		curr.nxt = prev;
	}

	public int midnode() {
		Node slow = head;
		Node fast = head;
		while (fast.nxt != null && fast.nxt.nxt != null) {
			slow = slow.nxt;
			fast = fast.nxt.nxt;
		}
		return slow.data;
	}

	public int kthfromlast(int k) {
		Node slow = head;
		Node fast = head;
		for (int i = 1; i <= k; i++)
			fast = fast.nxt;

		while (fast != null) {
			slow = slow.nxt;
			fast = fast.nxt;

		}
		return slow.data;

	}

	public void createDummyListLoop() {
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		n1.nxt = n2;
		n2.nxt = n3;
		n3.nxt = n4;
		n4.nxt = n5;
		n5.nxt = n6;
		n6.nxt = n7;
		n7.nxt = n8;
		n8.nxt = n9;
		n9.nxt = n4;
		this.head = n1;
	}

	public boolean detectloop() {
		Node slow = head;
		Node fast = head;
		int flag = 0;
		while (slow.nxt != null && fast.nxt != null && fast.nxt.nxt != null) {
			slow = slow.nxt;
			fast = fast.nxt.nxt;
			if (slow == fast) {
				flag = 1;
				break;
			}
		}

		if (flag == 1) {
			return true;
		} else {
			return false;
		}

	}


         

	public void removeduplicate() {
		Node fakehead = new Node(0);
		fakehead.nxt = head;
		Node prev = fakehead;
		Node curr = head;
		while (curr != null) {
			while (curr.nxt != null && curr.data == curr.nxt.data) {
				curr = curr.nxt;
			}
			if (prev.nxt == curr) {// initiators
				prev = curr;
			} else {
				prev.nxt = curr.nxt;
			}
			curr = curr.nxt;
		}
		head = fakehead.nxt;

	}

	public void Kreverse(int k) throws Exception {
		Linkedlist prev = null;
		while (size != 0) {
			Linkedlist curr = new Linkedlist();
			for (int i = 1; i <= k; i++) {
				curr.addFirst(removeFirst());
			}
			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.nxt = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}
			this.head = prev.head;
			this.tail = prev.tail;
			this.size = prev.size;

		}
		prev.display();
	}

}
