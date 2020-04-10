 mpackage Hash;

import java.util.HashMap;

public class Hash {

	public static void main(String[] args) {
		int arr[] = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		consecutiveseq(arr);
	}

	public static void consecutiveseq(int arr[]) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, false);
			}
			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}

		}
		int maxcount = 0;
		int start = 0;
		for (int key : map.keySet()) {
			if (map.containsKey(key)) {
				int count = 0;
				while (map.containsKey(key + count)) {
					count++;
				}
				if (count > maxcount) {
					maxcount = count;
					start = key;

				}

			}
		}
		for (int i = 0; i < maxcount; i++) {
			System.out.println(start + i);
		}

	}

}
