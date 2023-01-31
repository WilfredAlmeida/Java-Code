/*

Refer: Code N Code Videos

Bipartite graph is a special graph also known as Bigraph such that you can divide the vertex set into 2 disjoint sets such that:
1. Each vertex belongs to exactly one of 2 sets.
2. Each edge connects vertices of 2 different sets.

Watch video, its better explained there rather than been written here. :)

*/

import java.util.*;

public class Bipartite_Graph 
{
    private static class Graph
    {
        static int size = 100;
        static int[] visited = new int[size];
        static int[] color = new int[size];

        static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(size);

        static
        {
            for(int i=0;i<size;i++)
            adjacency_list.add(new LinkedList<Integer>());
        }

        static boolean dfs(int n, int c)
        {
            visited[n] = 1;
            color[n] = c;

            for(int child: adjacency_list.get(n))
            {
                if(visited[child] != 1)
                {
                    if(dfs(child, c^1) == false)
                        return false;
                }
                else if(color[n] == color[child])
                    return false;
            }

            return true;
        }
    }

    public static void main(String[] args) 
    {
        int number_of_edges=0, number_of_vertices=0, edge_1 =0, edge_2=0;

        Scanner scanner = new Scanner(System.in);

        number_of_vertices = scanner.nextInt();
        number_of_edges = scanner.nextInt();

        for(int i=0;i<number_of_edges;i++)
        {
            edge_1 = scanner.nextInt();
            edge_2 = scanner.nextInt();

            Graph.adjacency_list.get(edge_1).add(edge_2);
            Graph.adjacency_list.get(edge_2).add(edge_1);
        }

        boolean result = true;
        for(int j=1;j<=number_of_vertices;j++)
        {
            boolean b=true;
            if(Graph.visited[j] != 1)
                b = Graph.dfs(j,0);

            if(b==false)
                result = false;
        }

        System.out.println("Is Bipartite: "+result);

        scanner.close();
    }
}