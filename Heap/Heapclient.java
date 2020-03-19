package Heap;

import java.util.ArrayList;

public class Heapclient {

	public static void main(String[] args) {
		Heap heap = new Heap();
		for (int i = 1; i < 10; i++) {
			heap.add(10 * i);
		}
		heap.display();
		heap.remove();
		heap.display();
		int arr[] = { 20, 100, 5, 2, 30, 40, 3 };
		Klargestelement(arr, 4);
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());

		lists.get(0).add(1);
		lists.get(0).add(8);
		lists.get(0).add(9);
		lists.get(0).add(10);
		lists.get(0).add(12);

		lists.get(1).add(5);
		lists.get(1).add(15);
		lists.get(1).add(20);

		lists.get(2).add(7);
		lists.get(2).add(13);
		lists.get(2).add(25);
		lists.get(2).add(30);

		lists.get(3).add(2);
		lists.get(3).add(3);
		mergeKsortedlists(lists);

	}

	public static void Klargestelement(int[] arr, int k) {
		Heap heap = new Heap();
		for (int i = 0; i < k; i++) {
			heap.add(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			int element = heap.get();
			if (arr[i] > element) {
				heap.remove();
				heap.add(arr[i]);
			}
		}
		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
		}
	}

	public static class pair implements Comparable<pair> {
		int data;
		int idx;
		int listno;

		@Override
		public int compareTo(pair o) {
			return o.data - this.data;
		}

	}

	public static void mergeKsortedlists(ArrayList<ArrayList<Integer>> lists) {
		HeapGeneric<pair> heap = new HeapGeneric<>();
		for (int i = 0; i < lists.size(); i++) {
			pair np = new pair();
			np.data = lists.get(i).get(0);
			np.idx = 0;
			np.listno = i;
			heap.add(np);

		}
		while (!heap.isEmpty()) {
			pair rp = heap.remove();
			System.out.println(rp.data);
			rp.idx++;
			if (rp.idx < lists.get(rp.listno).size()) {
				rp.data = lists.get(rp.listno).get(rp.idx);
				heap.add(rp);
			}
		}
	}

}
