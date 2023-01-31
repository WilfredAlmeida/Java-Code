/*

Refer: Code N Code Videos

Question Link: https://www.spoj.com/problems/BUGLIFE/

Sample I/P:
2
3 3
1 2
2 3
1 3
4 2
1 2
3 4

*/

import java.util.*;

public class Bipartite_Graph_2 {

    private static class Graph {

        static int size = 2001;
        static int[] color = new int[size];
        static int[] visited = new int[size];

        static ArrayList<LinkedList<Integer>> ll = new ArrayList<LinkedList<Integer>>(size);

        static {
            for (int i = 0; i < size; i++)
                ll.add(new LinkedList<Integer>());
        }

        static boolean dfs(int n, int c) {

            visited[n] = 1;
            color[n] = c;

            for (int i : ll.get(n)) {
                if (visited[i] != 1) {
                    if (dfs(i, c ^ 1) == false)
                        return false;
                } else if (color[n] == color[i])
                    return false;
            }

            return true;
        }

        static void clear() {

            for (int i = 0; i < size; i++) {
                ll.get(i).clear();
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {

        int bugs = 0, t = 0, interactions = 0, bug_1 = 0, bug_2 = 0;

        Scanner scanner = new Scanner(System.in);

        t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            Graph.clear();

            bugs = scanner.nextInt();
            interactions = scanner.nextInt();

            for (int j = 1; j <= interactions; j++) {
                bug_1 = scanner.nextInt();
                bug_2 = scanner.nextInt();

                Graph.ll.get(bug_1).add(bug_2);
                Graph.ll.get(bug_2).add(bug_1);
            }

            boolean result = true;

            for (int j = 1; j <= bugs; j++) {
                boolean b = true;
                if (Graph.visited[j] != 1)
                    b = Graph.dfs(j, 0);

                if (b == false)
                    result = false;
            }

            if (result) {
                System.out.print("\nScenario #" + i + ":");
                System.out.print("\nNo suspicious bugs found!");
            } else {
                System.out.print("\nScenario #" + i + ":");
                System.out.print("\nSuspicious bugs found!");
            }
        }

        scanner.close();
    }
}