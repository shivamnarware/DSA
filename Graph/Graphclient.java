package Graph;

import java.util.HashMap;

public class Graphclient {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 6);
		graph.addEdge("B", "C", 3);
		graph.addEdge("C", "D", 1);
		graph.addEdge("D", "E", 8);
		graph.addEdge("E", "F", 5);
		graph.addEdge("F", "G", 1);
		graph.addEdge("F", "G", 4);
		graph.addEdge("E", "G", 7);
//		System.out.println(graph);
//		graph.removeEdge("D", "E");
//		System.out.println(graph.hasPath("A", "F", new HashMap<String, Boolean>()));
//		graph.printAllpath("A", "F", new HashMap<String, Boolean>(), "A");
//		graph.bfs("A", "F");
//		System.out.println(graph.dfs("A","F"));
//		graph.bft();
//		graph.bft();
//		System.out.println(graph.iscyclic());
//		graph.removeEdge("D", "E");
//		System.out.println(graph.isconnected());
//		System.out.println(graph.isbipartite());
		System.out.println(graph.prims());
		System.out.println(graph.dijkstra("A"));
//		System.out.println(graph.getCC());
	}

}
