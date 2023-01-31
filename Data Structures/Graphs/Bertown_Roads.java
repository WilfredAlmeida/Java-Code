/*

Refer: Code N Code Videos

Question Link: https://codeforces.com/problemset/problem/118/E

*/

import java.util.*;

public class Bertown_Roads {
    private static class Graph {

        static int size = 100001;
        static int[] visited = new int[size];
        static int[] intime = new int[size];
        static int[] lowtime = new int[size];
        static boolean isBirdged = false;
        static int timer = 0;

        static ArrayList<LinkedList<Integer>> ll = new ArrayList<LinkedList<Integer>>(size);

        static HashMap<Integer,Integer> pairs = new HashMap<Integer,Integer>();

        static{for(int i = 0;i<size;i++) ll.add(new LinkedList<Integer>());}

        static void clear()
        {
            visited = new int[size];
            intime = new int[size];
            lowtime = new int[size];
            isBirdged = false;
            pairs.clear();
            timer = 0;
        }

        static void dfs(int current_node, int parent)
        {
            visited[current_node] = 1;
            intime[current_node] = timer;
            lowtime[current_node] = timer;
            timer++;

            for(int connected_node:ll.get(current_node))
            {
                if(connected_node == parent) continue;

                if(visited[connected_node] == 1)
                {
                    lowtime[current_node] = Math.min(lowtime[current_node], intime[connected_node]);

                    if(intime[current_node] > intime[connected_node])
                        pairs.put(current_node,connected_node);
                }
                else
                {
                    dfs(connected_node,current_node);

                    if(lowtime[connected_node]>intime[current_node])
                    {
                        isBirdged = true;
                        return;
                    }

                    pairs.put(current_node,connected_node);

                    lowtime[current_node] = Math.min(lowtime[current_node], lowtime[connected_node]);

                }
            }
        }
    }

    public static void main(String[] args) {
        
        int n,m,vertex_1,vertex_2;

        Scanner scanner =new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        for(int i=1;i<=m;i++)
        {
            vertex_1 = scanner.nextInt();
            vertex_2 = scanner.nextInt();

            Graph.ll.get(vertex_1).add(vertex_2);
            Graph.ll.get(vertex_2).add(vertex_1);
        }

        Graph.dfs(1,-1);

        if(Graph.isBirdged)
            System.out.println(0);
        
        else
        {
            for(Map.Entry<Integer,Integer> e:Graph.pairs.entrySet())
            {
                System.out.println(e.getKey()+" "+e.getValue());
            }
        }

        scanner.close();

    }
}
