/*
Informed Search
A Star
 
 6
 
 11
 6
 99
 1
 7
 0
 
 6
 
 1
 2
 2
 
 1
 3
 5
 
 2
 3
 1
 
 4
 6
 9
 
 5
 4
 6
 
 4
 6
 1
 
 
 */
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Exp4 {
	static LinkedList<EdgeClass> adj[];
	static int V;
	static int[] heuristic;

	static class Pair {
		int node;
		int cost;
		int f;
		String path;
	}

	public Exp4(int v) {
		this.V = v;
		heuristic = new int[v + 1];
		adj = new LinkedList[v + 1];
		for (int i = 0; i < v + 1; i++) {
			adj[i] = new LinkedList<EdgeClass>();
		}
	}

	static class EdgeClass {
		int dest;
		int weight;
	}

	public static void addEdge(int source, int destination, int weight) {
		EdgeClass temp1 = new EdgeClass();
		temp1.dest = destination;
		temp1.weight = weight;
		adj[source].add(temp1);
		EdgeClass temp2 = new EdgeClass();
		temp2.dest = source;
		temp2.weight = weight;
		adj[destination].add(temp2);
	}

	public static void PrintGraph() {
		System.out.println("Adjacency List : ");
		for (int i = 1; i < V + 1; i++) {
			System.out.print("Node " + i + "  :  ");
			for (EdgeClass x : adj[i]) {
				System.out.print(" -> (" + x.dest + ", " + x.weight + " )");
			}
			System.out.println();

		}

	}

	public static void AStarAlgorithm(int source, int goal) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.f - o2.f;
			}
		});
		System.out.println("");

		Pair p = new Pair();
		p.node = source;
		p.cost = 0;
		p.f = heuristic[source];
		p.path = source + "";
		pq.add(p);
//        System.out.println(p.node + "   " + p.f + "   " + p.f);

		while (!pq.isEmpty()) {
			Pair temp = pq.poll();
//            System.out.println(temp.node + "  " + temp.f + "  " + temp.path + "   " + pq.size());
			if (temp.node == goal) {
				System.out.println("Goal Found");
				System.out.println("Path is " + temp.path);
				System.out.println("Total cost : " + temp.cost);
				return;
			}
			for (int i = 0; i < adj[temp.node].size(); i++) {
				EdgeClass edge = adj[temp.node].get(i);
				Pair temp1 = new Pair();
				temp1.node = edge.dest;
				temp1.path = temp.path + " -> " + edge.dest;
				temp1.f = heuristic[edge.dest] + temp.cost + edge.weight;
				temp1.cost = temp.cost + edge.weight;
//                System.out.println(temp1.node + "   , " + temp1.f + "   , " + temp1.path + "   , " + +edge.dest + "   ," + edge.weight +" :");
				pq.add(temp1);

			}

		}
		System.out.println("");
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of Nodes : ");
		int v = sc.nextInt();
		Exp4 a = new Exp4(v);
		System.out.println("Enter heuristic value of Nodes  ");
		for (int i = 1; i <= v; i++) {
			heuristic[i] = sc.nextInt();
			System.out.println(i + "  : " + heuristic[i]);

		}
		System.out.println("");
		System.out.print("Enter no of edges : ");
		int e = sc.nextInt();
		System.out.println("Enter " + e + " edges  ");
		for (int i = 1; i < e + 1; i++) {
			System.out.println("Enter source ,destination and weight of edge no : " + (i) + " ");
			System.out.print("Source : ");
			int source = sc.nextInt();
			System.out.print("Destination : ");
			int destination = sc.nextInt();
			System.out.print("Weight : ");
			int weight = sc.nextInt();

			addEdge(source, destination, weight);
			System.out.println();
		}
		PrintGraph();
		AStarAlgorithm(1, 6);

	}
}