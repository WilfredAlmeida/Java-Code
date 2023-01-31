/*

Refer: Code N Code Videos

Birdge in a graph is an edge that if disconnected will increase the number of components in graph.

Watch video :)

Sample Input:
4 4
1 2
2 3
2 4
3 4

*/

import java.util.*;

public class Counting_Bridges 
{
    static class Graph
    {
        static int size = 100;
        static int[] visited = new int[size];
        static int[] lowest_time = new int[size];
        static int[] in_time = new int[size];
        static int timer = 0;

        static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(size);

        static
        {
            for(int i=0;i<size;i++)
                adjacency_list.add(new LinkedList<Integer>());
        }

        static void dfs(int node, int parent)
        {
            visited[node] = 1;
            in_time[node] = lowest_time[node] = timer++;

            for(int i:adjacency_list.get(node))
            {
                if(i == parent)
                    continue;

                if(visited[i] == 1)
                {
                    //There's a back-edge between 'n' and 'i'
                    lowest_time[node] = Math.min(lowest_time[i], in_time[node]);
                }
                else
                {
                    //There's a forward-edge btwn 'n' and 'i'
                    dfs(i,node);

                    if(lowest_time[i]>lowest_time[node])
                        System.out.println(node+" <-> "+i+" is a Bridge");
                    
                    lowest_time[node] = Math.min(lowest_time[i],lowest_time[node]);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int number_of_edges,vertex_1,vertex_2;

        Scanner scanner = new Scanner(System.in);
        
        scanner.nextInt();//From input we are taking number of vertices but not using it
        
        number_of_edges = scanner.nextInt();

        for(int i=0;i<number_of_edges;i++)
        {
            vertex_2 = scanner.nextInt();
            vertex_1 = scanner.nextInt();

            Graph.adjacency_list.get(vertex_2).add(vertex_1);
            Graph.adjacency_list.get(vertex_1).add(vertex_2);
        }

        Graph.dfs(1,-1);

        scanner.close();
    }
}
