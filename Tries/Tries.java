package Tries;

import java.util.HashMap;

public class Tries {
	private class Node {
		char ch;
		boolean eow;
		HashMap<Character, Node> map = new HashMap<>();

		public Node(char ch) {
			this.ch = ch;
		}
	}

	private Node root;

	public Tries() {
		root = new Node('*');
	}

	public void addString(String word) {
		addString(root, word);
	}

	private void addString(Node node, String word) {
		if (word.length() == 0) {
			node.eow = true;
			return;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		if (node.map.containsKey(ch)) {
			addString(node.map.get(ch), ros);
		} else {
			Node child = new Node(ch);
			node.map.put(ch, child);
			addString(child, ros);
		}
	}

	public boolean Searchword(String word) {
		return Searchword(root, word);
	}

	private boolean Searchword(Node node, String word) {
		if (word.length() == 0) {
			return node.eow;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		if (node.map.containsKey(ch)) {
			return Searchword(node.map.get(ch), ros);
		} else {
			return false;
		}
	}

	public void display() {
		display(root, "");
	}

	private void display(Node node, String ans) {
		if (node.eow == true) {
			System.out.println(ans);
		}
		for (char ch : node.map.keySet()) {
			display(node.map.get(ch), ans + ch);
		}
	}

	public void delete(String word) {
		delete(root, word);
	}

	private void delete(Node node, String word) {
		if (word.length() == 0) {
			node.eow = false;
			return;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		if (node.map.containsKey(ch)) {
			Node child = node.map.get(ch);
			delete(node.map.get(ch), ros);
			if (child.eow == false && child.map.size() == 0) {
				node.map.remove(ch);
			}
		} else {
			// do nothing
		}
	}

	public boolean startswith(String word) {
		return startswith(root, word);
	}

	private boolean startswith(Node node, String word) {
		if (word.length() == 0) {
			return true;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		if (node.map.containsKey(ch)) {
			return startswith(node.map.get(ch), ros);
		} else {
			return false;
		}
	}

}
