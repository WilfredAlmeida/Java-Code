/*

Refer: Code N Code Graph videos.

Single Source Shortest Path is the shortest distance/number of edges to travel to reach from one node to another node.

To do this, we will maintain an array which will hold distance from a vertex to all other vertices. To to this, we will dfs every node and when we do that, we will calculate the distance only from a vertex to its parent vertex. We wont calculate the whole distance, just the distance btwn "Me and vertex above me". That will obviously be 1 and the total distance from lets say the root node to desired node will be sum of "My distance from my parent + distance btwn my parent and the root node". Thats recursion :-)

Sample Input:
6 5
1 2
2 3
4 5
4 6
2 4

For syntax comments, see "Counting_Components.java". Rest is easy, just as explained above.
*/

import java.util.*;

public class Single_Source_Shortest_Path {

    private static class Graph {
        static int initial_size_of_lists_and_arrays = 10;

        static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(
                initial_size_of_lists_and_arrays);

        static int[] visited = new int[initial_size_of_lists_and_arrays];

        static int[] distance = new int[initial_size_of_lists_and_arrays];

        static {
            for (int i = 0; i < initial_size_of_lists_and_arrays; i++)
                adjacency_list.add(new LinkedList<Integer>());
        }

        static void dfs(int n, int d) {
            visited[n] = 1;
            distance[n] = d;
            for (int i : adjacency_list.get(n)) {
                if (visited[i] != 1)
                    dfs(i, d + 1);
            }
        }

        static int getDistance(int n) {
            dfs(1, 0);
            return distance[n];
        }

    }

    public static void main(String[] args) {
        @SuppressWarnings("all") // Timepass
        int number_of_edges = 0, number_of_vertices = 0, vertex_1 = 0, vertex_2 = 0;

        Scanner scanner = new Scanner(System.in);

        number_of_vertices = scanner.nextInt();
        number_of_edges = scanner.nextInt();

        for (int i = 0; i < number_of_edges; i++) {
            vertex_2 = scanner.nextInt();
            vertex_1 = scanner.nextInt();

            Graph.adjacency_list.get(vertex_2).add(vertex_1);
            Graph.adjacency_list.get(vertex_1).add(vertex_2);
        }

        System.out.println(Graph.getDistance(6));

        scanner.close();
    }
}
