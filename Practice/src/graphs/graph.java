package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class graph {

	static class Edge {
		int src; // source
		int nbr; // neighbor
		int wt; // weight

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int vtces = scn.nextInt(); // No. of vertices : 0,1,2,3,4,5,6
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<Edge>();
		}

//		int numOfEdges = scn.nextInt();
//		for (int i = 0; i < numOfEdges; i++) {
//			int v1 = scn.nextInt();
//			int v2 = scn.nextInt();
//			int w = scn.nextInt();
//			graph[v1].add(new Edge(v1, v2, w));
//			graph[v2].add(new Edge(v2, v1, w));
//		}

//		graph[0].add(new Edge(0, 3, 40));
//		graph[0].add(new Edge(0, 1, 10));
//		graph[1].add(new Edge(1, 0, 10));
//		graph[1].add(new Edge(1, 2, 10));
//		graph[2].add(new Edge(2, 1, 10));
//		graph[2].add(new Edge(2, 3, 10));
//		graph[3].add(new Edge(3, 0, 40));
//		graph[3].add(new Edge(3, 2, 10));
//		graph[3].add(new Edge(3, 4, 2));
//		graph[4].add(new Edge(4, 3, 2));
//		graph[4].add(new Edge(4, 5, 3));
//		graph[4].add(new Edge(4, 6, 8));
//		graph[5].add(new Edge(5, 4, 3));
//		graph[5].add(new Edge(5, 6, 3));
//		graph[6].add(new Edge(6, 4, 8));
//		graph[6].add(new Edge(6, 5, 3));

//		graph[2].add(new Edge(2, 5, 3));
//		graph[5].add(new Edge(5, 2, 3));

		// Has Path
//		boolean[] visited = new boolean[vtces];
//		System.out.println(hasPath(graph, 0, 6, visited));

		// Print All Paths
//		visited = new boolean[vtces];
//		printAllPaths(graph, 0, 6, visited, "0");

		// Smallest, Largest, kth largest, just larger & smaller path than criteria
//		multisolver(graph, 0, 6, visited, 40, 3, "0", 0);
//		System.out.println(spath + "@" + spathwt); // smallest path
//		System.out.println(lpath + "@" + lpathwt); // largest path
//		System.out.println(cpath + "@" + cpathwt); // path just larger then 40
//		System.out.println(fpath + "@" + fpathwt); // path just smaller than 40
//		System.out.println(pq.peek().psf +"@"+pq.peek().wsf); // 3rd largest path

		// Get Connected Components of graph
//		graph[0].add(new Edge(0, 1, 10));
//		graph[1].add(new Edge(1, 0, 10));
//		graph[2].add(new Edge(2, 3, 10));
//		graph[3].add(new Edge(3, 2, 10));
//		graph[4].add(new Edge(4, 5, 10));
//		graph[4].add(new Edge(4, 6, 10));
//		graph[5].add(new Edge(5, 4, 10));
//		graph[5].add(new Edge(5, 6, 10));
//		graph[6].add(new Edge(6, 4, 10));
//		graph[6].add(new Edge(6, 5, 10));
//		ArrayList<List<Integer>> components = new ArrayList<List<Integer>>();
//		boolean[] vstd = new boolean[vtces];
//		for (int v = 0; v < vtces; v++) {
//			if (!vstd[v]) { // visit only those vertices which are not already visited
//				ArrayList<Integer> comp = new ArrayList<>();
//				getConnectedComp(graph, v, vstd, comp);
//				components.add(comp);
//			}
//		}
//		System.out.println(components);

		// isConnected
//		System.out.println(components.size() == 1);

		// Hamiltonian Paths
//		HashSet<Integer> visited = new HashSet<Integer>();
//		int src = 0;
//		hamiltonianPath(graph, src, visited, src + "", src);

		// BFS
//		bfs(graph, 2);

		// is Graph Bipartite
//		System.out.println(isGraphBipartite(graph));

		// Dijkstra Algorithm
//		dijkstraAlgorithm(graph, 0);

		// Prim's Algorithm
//		primsAlgorithm(graph);

		// Topological Sort : Directed Acyclic graph
		graph[0].add(new Edge(0, 3, 10));
		graph[0].add(new Edge(0, 1, 10));
		graph[1].add(new Edge(1, 2, 10));
		graph[2].add(new Edge(2, 3, 10));
		graph[4].add(new Edge(4, 3, 10));
		graph[4].add(new Edge(4, 5, 10));
		graph[4].add(new Edge(4, 6, 10));
		graph[5].add(new Edge(5, 6, 10));
		boolean[] visited = new boolean[graph.length];
		Stack<Integer> st = new Stack<>();
		for (int v = 0; v < visited.length; v++) {
			if (!visited[v]) {
				topologicalSort(graph, v, st, visited);
			}
		}
		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}

	public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
		if (src == dest) {
			return true;
		}

		visited[src] = true;

		// Check if any of the nbr of src has path to destination
		for (Edge edge : graph[src]) {
			if (!visited[edge.nbr]) {
				boolean nbrHasPath = hasPath(graph, edge.nbr, dest, visited);
				if (nbrHasPath) {
					return true;
				}
			}
		}
		return false;
	}

	public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String pathSoFar) {
		if (src == dest) {
			System.out.println(pathSoFar);
			return;
		}

		visited[src] = true;
		for (Edge edge : graph[src]) {
			if (!visited[edge.nbr]) {
				printAllPaths(graph, edge.nbr, dest, visited, pathSoFar + edge.nbr);
			}
		}
		visited[src] = false;
	}

	// Smallest path
	static String spath = "";
	static Integer spathwt = Integer.MAX_VALUE;
	// Largest path
	static String lpath = "";
	static Integer lpathwt = Integer.MIN_VALUE;
	// Ceil: just larger path than criteria(40)
	static String cpath = "";
	static Integer cpathwt = Integer.MAX_VALUE;
	// Floor: just smaller path than criteria(40)
	static String fpath = "";
	static Integer fpathwt = Integer.MIN_VALUE;
	// Kth largest path : 3rd argest path
	static PriorityQueue<Pair> pq = new PriorityQueue<>();

	static class Pair implements Comparable<Pair> {
		int wsf;
		String psf;

		Pair(int wsf, String psf) {
			this.wsf = wsf;
			this.psf = psf;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}

	public static void multisolver(ArrayList<Edge>[] graph, int src, int dstn, boolean[] vstd, int criteria, int k,
			String psf, int wsf) {
		if (src == dstn) {
			if (wsf < spathwt) {
				spathwt = wsf;
				spath = psf;
			}
			if (wsf > lpathwt) {
				lpathwt = wsf;
				lpath = psf;
			}
			if (wsf < cpathwt && wsf > criteria) {
				cpathwt = wsf;
				cpath = psf;
			}
			if (wsf > fpathwt && wsf < criteria) {
				fpathwt = wsf;
				fpath = psf;
			}

			pq.add(new Pair(wsf, psf));
			if (pq.size() > k) {
				pq.remove();
			}
			return;
		}

		vstd[src] = true;
		for (Edge e : graph[src]) {
			if (!vstd[e.nbr]) {
				multisolver(graph, e.nbr, dstn, vstd, criteria, k, psf + e.nbr, wsf + e.wt);
			}
		}
		vstd[src] = false;

	}

	public static void getConnectedComp(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {
		visited[src] = true;
		comp.add(src);
		for (Edge e : graph[src]) {
			if (!visited[e.nbr]) {
				getConnectedComp(graph, e.nbr, visited, comp);
			}
		}
	}

	public static void hamiltonianPath(ArrayList<Edge>[] graph, int src, HashSet<Integer> vstd, String psf,
			int originalSrc) {

		if (vstd.size() == graph.length - 1) {

			for (Edge e : graph[src]) {
				if (e.nbr == originalSrc) {
					System.out.println("Cycle -> " + psf);
					return;
				}
			}

			System.out.println("H.P. -> " + psf);
			return;
		}

		vstd.add(src);

		for (Edge e : graph[src]) {
			if (!vstd.contains(e.nbr)) {
				hamiltonianPath(graph, e.nbr, vstd, psf + e.nbr, originalSrc);
			}
		}
		vstd.remove(src);
	}

	static class BfsPair {
		int v; // vertex
		String psf; // path so far vertex

		public BfsPair(int v, String psf) {
			this.v = v;
			this.psf = psf;
		}
	}

	public static void bfs(ArrayList<Edge>[] graph, int src) {

		ArrayDeque<BfsPair> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[graph.length];
		queue.addLast(new BfsPair(src, src + ""));

		while (!queue.isEmpty()) {
			// remove
			BfsPair rp = queue.removeFirst();
			// mark*
			if (visited[rp.v]) {
				continue;
			}
			visited[rp.v] = true; // If not already marked(visited)
			// work
			System.out.print(rp.v + " ");
			// add*
			for (Edge e : graph[rp.v]) {
				if (!visited[e.nbr]) // Add unvisited neighbors in queue
					queue.addLast(new BfsPair(e.nbr, rp.psf + " " + e.nbr));
			}
		}
	}

	static class bptPair {
		int v;
		int level;

		bptPair(int v, int level) {
			this.v = v;
			this.level = level;
		}
	}

	public static boolean isGraphBipartite(ArrayList<Edge>[] graph) {
		int[] visited = new int[graph.length]; // This array will store the level
		Arrays.fill(visited, -1); // Put -1 at each index

		for (int v = 0; v < visited.length; v++) {
			if (visited[v] == -1) { // Visit only unvisited vertices
				boolean isCompBip = isComponentBipartite(graph, v, visited);
				if (isCompBip == false) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isComponentBipartite(ArrayList<Edge>[] graph, int src, int[] visited) {
		ArrayDeque<bptPair> queue = new ArrayDeque<>();
		queue.addLast(new bptPair(src, 0));
		while (!queue.isEmpty()) {
			// r
			bptPair rp = queue.removeFirst();
			// m*
			if (visited[rp.v] != -1) { // If removed vertex is already visited, cycle exists
				if (rp.level != visited[rp.v]) {
					return false;
				}
			}
			visited[rp.v] = rp.level;
			// a*
			for (Edge e : graph[rp.v]) {
				if (visited[e.nbr] == -1) {
					queue.addLast(new bptPair(e.nbr, rp.level + 1));
				}
			}
		}
		return true;
	}

	public static class djkPair implements Comparable<djkPair> {
		int v;
		String psf;
		int wsf;

		djkPair(int v, String psf, int wsf) {
			this.v = v;
			this.psf = psf;
			this.wsf = wsf;
		}

		@Override
		public int compareTo(djkPair o) {
			return this.wsf - o.wsf;
		}
	}

	public static void dijkstraAlgorithm(ArrayList<Edge>[] graph, int src) {

		boolean[] visited = new boolean[graph.length];
		PriorityQueue<djkPair> pq = new PriorityQueue<>();
		pq.add(new djkPair(src, src + "", 0));

		while (!pq.isEmpty()) {
			// r
			djkPair rp = pq.remove();
			// m*
			if (visited[rp.v]) {
				continue;
			}
			visited[rp.v] = true;
			// w
			System.out.println(rp.v + " via " + rp.psf + " @ " + rp.wsf);
			// a*
			for (Edge e : graph[rp.v]) {
				if (!visited[e.nbr]) {
					pq.add(new djkPair(e.nbr, rp.psf + e.nbr, e.wt + rp.wsf));
				}
			}
		}

	}

	static class PrimsPair implements Comparable<PrimsPair> {
		int v; // current vertex
		int acqVertex; // acquiring vertex
		int wt; // Edge wt of v and acqVertex

		PrimsPair(int v, int acqVertex, int wt) {
			this.v = v;
			this.acqVertex = acqVertex;
			this.wt = wt;
		}

		@Override
		public int compareTo(PrimsPair o) {
			return this.wt - o.wt;
		}

	}

	public static void primsAlgorithm(ArrayList<Edge>[] graph) {

		boolean[] visited = new boolean[graph.length];
		PriorityQueue<PrimsPair> pq = new PriorityQueue<graph.PrimsPair>();
		pq.add(new PrimsPair(0, -1, 0)); // Add first vertex

		while (!pq.isEmpty()) {
			// r
			PrimsPair rn = pq.remove();
			// m*
			if (visited[rn.v]) {
				continue;
			}
			visited[rn.v] = true;
			// w
			System.out.println(rn.v + " via " + rn.acqVertex + " @ " + rn.wt);
			// a*
			for (Edge e : graph[rn.v]) {
				if (!visited[e.nbr]) {
					pq.add(new PrimsPair(e.nbr, rn.v, e.wt));
				}
			}
		}
	}

	private static void topologicalSort(ArrayList<Edge>[] graph, int src, Stack<Integer> st, boolean[] visited) {
		visited[src] = true;
		for (Edge e : graph[src]) {
			if (!visited[e.nbr]) {
				topologicalSort(graph, e.nbr, st, visited);
			}
		}
		st.push(src);
	}
}
