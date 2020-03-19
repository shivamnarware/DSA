package Heap;

import java.util.ArrayList;

import Graph.Graph.dijkstrapair;
import Graph.Graph.primspair;

public class HeapGeneric<T extends Comparable<T>> {
	ArrayList<T> data = new ArrayList<T>();

	public void add(T item) {
		data.add(item);
		upheaify(data.size() - 1);
	}

	private void upheaify(int ci) {
		int pi = (ci - 1) / 2;
		if (data.get(ci).compareTo(data.get(pi)) > 0) {
			swap(pi, ci);
			upheaify(pi);
		}
	}

	private void swap(int ci, int pi) {
		T ith = data.get(ci);
		T jth = data.get(pi);
		data.set(ci, jth);
		data.set(pi, ith);
	}

	public void display() {
		System.out.println(data);
	}

	public T remove() {
		swap(0, data.size()-1);
		T temp=data.remove(data.size()-1);
		downheapify(0);
		return temp;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;
		if (lci < data.size() && data.get(lci).compareTo(data.get(mini)) > 0) {
			mini = lci;
		}
		if (rci < data.size() && data.get(rci).compareTo(data.get(mini)) > 0) {
			mini = rci;
		}
		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}
	}

	public T get() {
		return data.get(0);
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void updatepriority(dijkstrapair cp) {
		int idx = 0;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i) == cp) {
				idx = i;
				break;
			}
		}
		upheaify(idx);

	}

}
