package Graph;

import java.util.*;

import Heap.HeapGeneric;
import linkedlist.Linkedlist;

public class Graph {
	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();

	}

	private static final int HashMap = 0;

	HashMap<String, Vertex> vtces = new HashMap<>();

	public int numVertex() {
		return vtces.size();
	}

	public boolean containsVertex(String vname) {
		return vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {
		Vertex vtx = vtces.get(vname);
		for (String key : vtx.nbrs.keySet()) {
			vtces.get(key).nbrs.remove(vname);
		}
		vtces.remove(vname);
	}

	public int numEdge() {
		int sum = 0;
		for (String key : vtces.keySet()) {
			Vertex vtx = vtces.get(key);
			sum += vtx.nbrs.size();
		}
		return sum / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {
		Vertex v1 = vtces.get(vname1);
		Vertex v2 = vtces.get(vname2);
		if (v1 == null || v2 == null || !v1.nbrs.containsKey(vname2)) {
			return false;
		}
		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {
		Vertex v1 = vtces.get(vname1);
		Vertex v2 = vtces.get(vname2);
		if (v1 == null || v2 == null || v1.nbrs.containsKey(vname2)) {
			return;
		}
		v1.nbrs.put(vname2, cost);
		v2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {
		Vertex v1 = vtces.get(vname1);
		Vertex v2 = vtces.get(vname2);
		if (v1 == null || v2 == null || !v1.nbrs.containsKey(vname2)) {
			return;
		}
		v1.nbrs.remove(vname2);
		v2.nbrs.remove(vname1);
	}

	public void display() {
		System.out.println("---------------------------");
		for (String key : vtces.keySet()) {
			Vertex vtx = vtces.get(key);
			System.out.println(key + " -> " + vtx.nbrs);
		}
		System.out.println("---------------------------");
	}

	@Override
	public String toString() {
		String str = "";
		str += "---------------------------\n";
		for (String key : vtces.keySet()) {
			Vertex vtx = vtces.get(key);
			str += key + " -> " + vtx.nbrs;
			str += "\n";
		}
		str += "---------------------------\n";
		return str;
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {
		processed.put(src, true);
		if (containsEdge(src, dst)) {
			return true;
		}
		for (String nbr : vtces.get(src).nbrs.keySet()) {
			if (!processed.containsKey(nbr) && hasPath(nbr, dst, processed)) {
				return true;
			}
		}
		return false;
	}

	public void printAllpath(String src, String dst, HashMap<String, Boolean> processed, String asf) {
		processed.put(src, true);
		if (src.equals(dst)) {
			System.out.println(asf);
			processed.remove(src);
			return;
		}
		for (String nbr : vtces.get(src).nbrs.keySet()) {
			if (!processed.containsKey(nbr)) {
				printAllpath(nbr, dst, processed, asf + nbr);
			}
		}
		processed.remove(src);
	}

	private class pair {
		String vname;
		String psf;
		String color;
	}

	public boolean bfs(String src, String dst) {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		pair sp = new pair();
		sp.vname = src;
		sp.psf = src;
		queue.addLast(sp);
		while (!queue.isEmpty()) {
			pair rp = queue.removeLast();
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}
			if (processed.containsKey(rp.vname)) {// second C
				continue;
			}
			processed.put(rp.vname, true);
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
				if (!processed.containsKey(nbr)) {
					pair np = new pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					queue.addLast(np);
				}
			}
		}
		return false;
	}

	public boolean dfs(String src, String dst) {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<pair> stack = new LinkedList<>();
		pair sp = new pair();
		sp.vname = src;
		sp.psf = src;
		stack.addFirst(sp);
		while (!stack.isEmpty()) {
			pair rp = stack.removeFirst();
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}
			if (processed.containsKey(rp.vname)) {// second C
				continue;
			}
			processed.put(rp.vname, true);
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
				if (!processed.containsKey(nbr)) {
					pair np = new pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					stack.addFirst(np);
				}
			}
		}
		return false;
	}

	public void bft() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		{
			for (String key : vtces.keySet()) {
				if (processed.containsKey(key)) {
					continue;
				}
				pair sp = new pair();
				sp.vname = key;
				sp.psf = key;
				queue.addLast(sp);
				while (!queue.isEmpty()) {
					pair rp = queue.removeFirst();
					if (processed.containsKey(rp.vname)) {// second C
						continue;
					}
					System.out.println(rp.vname + " via" + rp.psf);

					processed.put(rp.vname, true);
					for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
						if (!processed.containsKey(nbr)) {
							pair np = new pair();
							np.vname = nbr;
							np.psf = rp.psf + nbr;
							queue.addLast(np);
						}
					}
				}
			}
		}

	}

	public void dft() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<pair> stack = new LinkedList<>();
		{
			for (String key : vtces.keySet()) {
				if (processed.containsKey(key)) {
					continue;
				}
				pair sp = new pair();
				sp.vname = key;
				sp.psf = key;
				stack.addFirst(sp);
				while (!stack.isEmpty()) {
					pair rp = stack.removeFirst();
					if (processed.containsKey(rp.vname)) {// second C
						continue;
					}
					System.out.println(rp.vname + " via" + rp.psf);

					processed.put(rp.vname, true);
					for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
						if (!processed.containsKey(nbr)) {
							pair np = new pair();
							np.vname = nbr;
							np.psf = rp.psf + nbr;
							stack.addFirst(np);
						}
					}
				}
			}
		}
	}

	public boolean iscyclic() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		{
			for (String key : vtces.keySet()) {
				if (processed.containsKey(key)) {
					continue;
				}
				pair sp = new pair();
				sp.vname = key;
				sp.psf = key;
				queue.addLast(sp);
				while (!queue.isEmpty()) {
					pair rp = queue.removeFirst();
					if (processed.containsKey(rp.vname)) {// second C
						return true;
					}
					System.out.println(rp.vname + " via" + rp.psf);

					processed.put(rp.vname, true);
					for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
						if (!processed.containsKey(nbr)) {
							pair np = new pair();
							np.vname = nbr;
							np.psf = rp.psf + nbr;
							queue.addLast(np);
						}
					}
				}
			}
		}
		return false;

	}

	public boolean isconnected() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		int count = 0;
		{
			for (String key : vtces.keySet()) {
				if (processed.containsKey(key)) {
					continue;
				}
				count++;
				pair sp = new pair();
				sp.vname = key;
				sp.psf = key;
				queue.addLast(sp);
				while (!queue.isEmpty()) {
					pair rp = queue.removeFirst();
					if (processed.containsKey(rp.vname)) {// second C
						continue;
					}
//					System.out.println(rp.vname + " via" + rp.psf);

					processed.put(rp.vname, true);
					for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
						if (!processed.containsKey(nbr)) {
							pair np = new pair();
							np.vname = nbr;
							np.psf = rp.psf + nbr;
							queue.addLast(np);
						}
					}
				}
			}
		}
		return count == 1;

	}

	public boolean isTree() {
		return !iscyclic() && isconnected();
	}

	public ArrayList<ArrayList<String>> getCC() {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		{
			for (String key : vtces.keySet()) {
				if (processed.containsKey(key)) {
					continue;
				}
				ArrayList<String> subans = new ArrayList<>();
				pair sp = new pair();
				sp.vname = key;
				sp.psf = key;
				queue.addLast(sp);
				while (!queue.isEmpty()) {
					pair rp = queue.removeFirst();
					if (processed.containsKey(rp.vname)) {// second C
						continue;
					}
					subans.add(rp.vname);
					processed.put(rp.vname, true);
					for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
						if (!processed.containsKey(nbr)) {
							pair np = new pair();
							np.vname = nbr;
							np.psf = rp.psf + nbr;
							queue.addLast(np);
						}
					}
				}
				ans.add(subans);
			}

		}
		return ans;
	}

	public boolean isbipartite() {
		HashMap<String, String> processed = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		for (String key : vtces.keySet()) {
			if (processed.containsKey(key)) {
				continue;
			}
			pair sp = new pair();
			sp.vname = key;
			sp.psf = key;
			sp.color = "r";
			queue.add(sp);
			while (!queue.isEmpty()) {
				pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					String oc = rp.color;
					String nc = processed.get(rp.vname);
					if (!nc.equals(oc)) {
						return false;
					}
					continue;
				}
				processed.put(rp.vname, rp.color);
				for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						pair np = new pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.color = rp.color.equals("r") ? "g" : "r";
						queue.add(np);
					}
				}
			}
		}
		return true;
	}

	public class primspair implements Comparable<primspair> {
		String vname;
		String acqname;
		int cost = Integer.MAX_VALUE;

		@Override
		public int compareTo(primspair o) {

			return o.cost - this.cost;
		}

	}

	public Graph prims() {
		Graph mst = new Graph();
		HashMap<String, primspair> map = new HashMap<>();
		HeapGeneric<primspair> heap = new HeapGeneric<>();
		for (String key : vtces.keySet()) {
			primspair sp = new primspair();
			sp.vname = key;
			map.put(key, sp);
			heap.add(sp);
		}
		while (!heap.isEmpty()) {
			primspair rp = heap.remove();
			map.remove(rp.vname);

			if (rp.acqname == null) {
				mst.addVertex(rp.vname);
			} else {
				mst.addVertex(rp.vname);
				mst.addEdge(rp.vname, rp.acqname, rp.cost);
			}
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
				if (map.containsKey(nbr)) {
					primspair cp = map.get(nbr);
					int oc = cp.cost;
					int nc = vtces.get(rp.vname).nbrs.get(nbr);
					if (oc > nc) {
						cp.cost = nc;
						cp.acqname = rp.vname;
//						heap.updatepriority(cp);

					}

				}
			}

		}
		return mst;
	}

	public class dijkstrapair implements Comparable<dijkstrapair> {
		String vname;
		String psf;
		int cost = Integer.MAX_VALUE;

		@Override
		public int compareTo(dijkstrapair o) {
			return o.cost - this.cost;
		}
	}

	public HashMap<String, Integer> dijkstra(String src) {
		HashMap<String, Integer> ans = new HashMap<>();
		HashMap<String, dijkstrapair> map = new HashMap<>();
		HeapGeneric<dijkstrapair> heap = new HeapGeneric<>();
		for (String key : vtces.keySet()) {
			dijkstrapair sp = new dijkstrapair();
			sp.vname = key;
			if (key.equals(src)) {
				sp.cost = 0;
				sp.psf = key;
			}
			heap.add(sp);
			map.put(key, sp);
		}
		while (!heap.isEmpty()) {
			dijkstrapair rp = heap.remove();
			map.remove(rp.vname);
			ans.put(rp.vname, rp.cost);
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
				if (map.containsKey(nbr)) {
					dijkstrapair cp = map.get(nbr);
					int oc = cp.cost;
					int nc = rp.cost + vtces.get(rp.vname).nbrs.get(nbr);
					if (oc > nc) {
						cp.cost = nc;
						cp.psf = rp.psf + nbr;
						heap.updatepriority(cp);
					}

				}

			}

		}
		return ans;

	}

}
