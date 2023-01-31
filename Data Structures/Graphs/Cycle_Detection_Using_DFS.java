/*

Refer: Code N Code Videos

To detect a cycle, we can use bipartite graph. Also along with that to check is a cycle exists, while we dfs, we'll pass the parent of the node. This is simple, we'll be calling dfs on children nodes of a node so we'll just pass the calling node as parent.

Now as the edges will be indicated in adjacency list, if we find that a node is visited already and it's not the parent of our node then there exists a cycle.

Sample:

I/p:

1.
5 5
1 2
2 3
2 4
4 5
3 4
-> Cycle exists

2. 
5 4
1 2
2 3
2 4
4 5
-> Cycle does not exists

*/

import java.util.*;

public class Cycle_Detection_Using_DFS {
    private static class Graph {
        static int size = 100;
        static int[] visited = new int[size];

        static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(size);

        static {
            for (int i = 0; i < size; i++) {
                adjacency_list.add(new LinkedList<Integer>());
            }
        }

        // Will return boolean indicating wheher cycle exists or not
        static boolean dfs(int node, int parent) {
            visited[node] = 1;

            for (int child : adjacency_list.get(node)) {
                if (visited[child] != 1)// If its not visited, dfs it
                {
                    if (dfs(child, node) == true)// If cycle exists in child, tell it to parent
                        return true;
                }

                else if (child != parent)// Node is visited but its not parent then cycle exists, return true
                    return true;
            }

            return false;// Cycle does not exist
        }
    }

    public static void main(String[] args) {

        int vertices = 0, edges = 0, vertex_1 = 0, vertex_2 = 0;

        Scanner scanner = new Scanner(System.in);

        vertices = scanner.nextInt();
        edges = scanner.nextInt();

        for (int i = 0; i < edges; i++) {
            vertex_1 = scanner.nextInt();
            vertex_2 = scanner.nextInt();

            Graph.adjacency_list.get(vertex_1).add(vertex_2);
            Graph.adjacency_list.get(vertex_2).add(vertex_1);
        }

        boolean res = true;
        for (int i = 1; i <= vertices; i++) {
            boolean b = Graph.dfs(i, i);

            if (b == false)
                res = false;
        }

        System.out.println("Cycle Exists: " + res);

        scanner.close();
    }
}