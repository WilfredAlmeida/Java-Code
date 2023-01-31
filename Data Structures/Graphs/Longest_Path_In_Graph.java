/*

Refer: Code N Code Videos

Longest path in a graph is the longest distance possible in the graph.

To get that, we'll first dfs from any node and find the farthest node from it and then from that node we'll find the farthest node.

Another approach to this problem is find longest distance from every node to every node. That's O(n^2), the one we used is linear, O(2n) cuz dfs is O(n) and we do it twice.

*/

import java.util.*;

public class Longest_Path_In_Graph {
    private static class Graph {
        static int size = 100;
        static int[] visited = new int[size];
        static int maxNode = -1, maxDistance = -1;

        static ArrayList<LinkedList<Integer>> ll = new ArrayList<LinkedList<Integer>>(size);

        static {
            for (int i = 0; i < size; i++)
                ll.add(new LinkedList<Integer>());
        }

        static void dfs(int node, int distance)
        {
            //Distance stuff is similar to shortst pah, read that.

            //Here if the distance of the current node is greater than the max distance we have then we'll update max distance and max node.
            if (distance > maxDistance)
            {
                maxDistance = distance;
                maxNode = node;
            }

            visited[node] = 1;

            for (int child : ll.get(node)) {
                if (visited[child] != 1)
                    dfs(child, distance + 1);
            }
        }
    }

    public static void main(String[] args) {

        int number_of_nodes = 0, node_1 = 0, node_2 = 0;

        Scanner scanner = new Scanner(System.in);

        number_of_nodes = scanner.nextInt();

        for (int i = 0; i < number_of_nodes - 1; i++) {
            node_1 = scanner.nextInt();
            node_2 = scanner.nextInt();

            Graph.ll.get(node_2).add(node_1);
            Graph.ll.get(node_1).add(node_2);
        }

        Graph.dfs(1, 0);//Dfs'ing from first node to find node farthest from it.

        //Clearing visited array for second round.
        for (int i = 0; i < Graph.size; i++)
            Graph.visited[i] = 0;

        Graph.maxDistance = -1;//Resetting max distance for second round

        //Dfs'ing from the farthest node found to get the true farthest node and distance to it.
        Graph.dfs(Graph.maxNode, 0);

        System.out.println("Longest Path: " + Graph.maxDistance);

        scanner.close();

    }
}