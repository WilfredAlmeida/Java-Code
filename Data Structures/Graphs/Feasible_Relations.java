/*

Refer: Code N Code Videos

Question Link: https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/feasible-relations/

Idea here is, initially all variable are individual nodes. Then we'll take input from user and if the relation is '=' then we'll make an edge btwn the nodes. If the relation is '!=' then we'll add the 2 numbers into a pair(we basically need to store them as a pair so we can use Pair or HashMap and stuff). Then we DFS each node and count and store the component number each node belongs to.

Now if relation is '=', there is an edge so same component. But the input is like '1 = 2' and '1 != 2' then, we'll get those elements stored in Pair/HashMap and check their component number, if its same then we'll the relation is invalid. If its different then relation is valid.

Also, rather than calculating and comparing component cumber, we can just get the numbers from Pair/HashMap and check if they have an edge btwn them, if yes then relation is invalid. Though it might be time taking. :)

*/

import java.util.*;

public class Feasible_Relations {
    private static class Graph {
        static int size = 1000001;
        static int[] visited = new int[size];
        static int[] component = new int[size];
        static int components_count;

        static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(size);

        static HashMap<Integer, Integer> pair = new HashMap<Integer, Integer>();

        static {
            for (int i = 0; i < size; i++) {
                adjacency_list.add(new LinkedList<Integer>());
            }
        }

        static void clear() {
            visited = new int[size];
            component = new int[size];
            for (int i = 0; i < size; i++)
                adjacency_list.get(i).clear();
            pair = new HashMap<Integer, Integer>();
            components_count = 0;
        }

        static void dfs(int n) {
            visited[n] = 1;
            component[n] = components_count;

            for (int i : adjacency_list.get(n))
                if (visited[i] != 1)
                    dfs(i);
        }
    }

    public static void main(String[] args) {
        int testcases = 0, number_of_variables = -1, number_of_relations = -1, num1 = 0, num2 = 0;
        String operator = new String();

        Scanner scanner = new Scanner(System.in);
        testcases = scanner.nextInt();

        while (testcases-- != 0) {
            // Taking input from console using is a pain and below I have worked it out to
            // take input like '1 = 2' and get 1 and 2 as int's and '=' as String.
            number_of_variables = scanner.nextInt();
            number_of_relations = Integer.parseInt(scanner.nextLine().trim());

            Graph.clear();

            for (int i = 0; i < number_of_relations; i++) {
                String[] ip = scanner.nextLine().split(" ");

                num1 = Integer.parseInt(ip[0]);
                operator = ip[1].trim();
                num2 = Integer.parseInt((ip[2]));

                // Explained above, if its '=', they have an edge
                if (operator.equals("=")) {
                    Graph.adjacency_list.get(num1).add(num2);
                    Graph.adjacency_list.get(num2).add(num1);
                } else// For '!=', store numbers in pairs
                    Graph.pair.put(num1, num2);
            }

            // Checking and calculating component numbers
            for (int i = 1; i <= number_of_variables; i++) {
                if (Graph.visited[i] != 1) {
                    Graph.components_count++;
                    Graph.dfs(i);
                }
            }

            // Checkig values stored in pairs.
            boolean flag = true;// If they have edge or are in same component, it will be false
            for (Map.Entry<Integer, Integer> e : Graph.pair.entrySet())// Hashap is not iteratealbe so we'll pull out an entry from it and get values of that entry
            {
                num1 = e.getKey();
                num2 = e.getValue();

                if (Graph.component[num1] == Graph.component[num2])// If they belong to same component. The edge checking condition too goes here.
                {
                    flag = false;
                    break;
                }
            }

            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        scanner.close();
    }
}