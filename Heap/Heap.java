package Heap;

import java.util.ArrayList;

public class Heap {
	ArrayList<Integer> data = new ArrayList<Integer>();

	public void add(int item) {
		data.add(item);
		upheaify(data.size() - 1);
	}

	private void upheaify(int ci) {
		int pi = (ci - 1) / 2;
		if (data.get(ci) < data.get(pi)) {
			swap(pi, ci);
			upheaify(pi);
		}
	}

	private void swap(int ci, int pi) {
		int ith = data.get(ci);
		int jth = data.get(pi);
		data.set(ci, jth);
		data.set(pi, ith);
	}

	public void display() {
		System.out.println(data);
	}

	public int remove() {
		swap(0, data.size() - 1);
		int temp = data.remove(data.size() - 1);
		downheapify(0);
		return temp;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;
		if (lci < data.size() && data.get(lci) < data.get(mini)) {
			mini = lci;
		}
		if (rci < data.size() && data.get(rci) < data.get(mini)) {
			mini = rci;
		}
		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}
	}

	public int get() {
		return data.get(0);
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

}
