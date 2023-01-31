/*

Refer: Code N Code Videos

As we know queue is used in BFS so we'll use LinkedList for it. Here we'll maintain an array that will store distance to all nodes from root.

So as we saw in SSSP using DFS, the distance is "my distance from my parent(obviously 1) + distance of my parent to root". So here as we are getting next element to bfs from queue, we can't immediately know its parent, the parent is the one who adds the node into queue, so we'll maintain an array of predecessor of current node and set predecessor of an element while adding it to queue.

To get the distance for current node, we'll get the distance of its predecessor and add 1 to it.

*/

import java.util.*;

public class Single_Source_Shortest_Path_Using_Bfs {
    static class Graph {
        static int size = 100;
        static int[] visited = new int[size];
        static int[] distances = new int[size];
        static int[] predecessor = new int[size];

        static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(size);

        static LinkedList<Integer> queue = new LinkedList<Integer>();

        static {
            for (int i = 0; i < size; i++)
                adjacency_list.add(new LinkedList<Integer>());
        }

        static int c = 0;// Read below

        static void bfs(int n) {
            visited[n] = 1;

            // Distance of initial node is set from calling function and it gets unwantedly
            // changed here so just for first time due to 'c' it wont be changed
            if (c != 0)
                distances[n] = distances[predecessor[n]] + 1;// As explained above, distance of current node is set
                                                             // distance of its predecessor + 1
            c++;

            for (int i : adjacency_list.get(n)) {
                if (visited[i] != 1) {
                    queue.add(i);// Adding elements to queue

                    // If one node is connected by 2 or more nodes and they are not meant to be the
                    // current node's parent but without the if condition, orignal predecessor will
                    // be overridden. So if predecessor of 'i' is visited, it means that its
                    // rightfully current node's parent.
                    if (visited[predecessor[i]] != 1)
                        predecessor[i] = n;
                }
            }

            // Pulling out elements from queue to bfs them
            while (!queue.isEmpty()) {
                int i = queue.poll();

                if (visited[i] != 1)
                    bfs(i);
            }
        }
    }

    public static void main(String[] args) {
        int number_of_vertices = 0, number_of_edges = 0, edge_1 = 0, edge_2 = 0;

        Scanner scanner = new Scanner(System.in);

        number_of_vertices = scanner.nextInt();
        number_of_edges = scanner.nextInt();

        for (int i = 0; i < number_of_edges; i++) {
            edge_1 = scanner.nextInt();
            edge_2 = scanner.nextInt();

            Graph.adjacency_list.get(edge_1).add(edge_2);
            Graph.adjacency_list.get(edge_2).add(edge_1);
        }

        Graph.distances[3] = 0;
        Graph.bfs(3);

        for (int i = 1; i <= number_of_vertices; i++) {
            System.out.print("\nDistance of " + i + " is " + Graph.distances[i]);
        }
        scanner.close();
    }
}
/*
 * 
 * 7 8 1 2 2 3 1 3 2 4 3 5 5 6 5 7 6 7
 * 
 */