/*

Refer: Code N Code Graph videos.

Components are groups of vertices in a graph. If there are 4 vertices say 1,2,3,4
and 1,2 and 3,4 are connected but no connection exists btwn 1<->3,1<->4,2<->3,2<->4
than we say there are 2 components in the graph.

In the count function below, we dfs a vertex, so that vertex and its connected
vertices get added into visited vertices list and so we increment count by one.
Now we dfs all vertices similarly and if any vertex is not pre-dfs'd or not traversed previously would mean that that vertex belongs to different component. So we dfs it and increment count.

*/

import java.util.*;


class Graph
{
    static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(100);
    public static int[] visited = new int[100];

    static//Initialization is needed or we get errors :)
    {
        for(int i=0;i<100;i++)
            adjacency_list.add(new LinkedList<Integer>());
    }

    static void dfs(int a)
    {
        visited[a] = 1;
        for(int i:adjacency_list.get(a))
        {
            if(visited[i] != 1)
                dfs(i);
        }
    }
}

public class Counting_Components
{
    public static void main(String[] args) 
    {
        int edges=0, vertices=0, vertex_1=0, vertex_2=0, components_count=0;

        Scanner scanner = new Scanner(System.in);//Getting number of vertices and edges
        vertices = scanner.nextInt();
        edges = scanner.nextInt();

        for(int i=0;i<edges;i++)
        {
            //These vertices will have an edge between them.
            vertex_1 = scanner.nextInt();
            vertex_2 = scanner.nextInt();

            //Since we are implementing adjacency list, we will add vertex_1 to adj list of vertex_2 and vice versa
            Graph.adjacency_list.get(vertex_1).add(vertex_2);
            Graph.adjacency_list.get(vertex_2).add(vertex_1);
        }

        //Check visited vertices and if any vertex is unvisited, dfs it and increase count as explained above. Note that we start from 1 here and not 0 cuz we have vertices from 1.
        for(int i=1;i<=vertices;i++)
        {
            if(Graph.visited[i] != 1)
            {
                Graph.dfs(i);
                components_count++;
            }
        }

        System.out.println(components_count);

        scanner.close();
    }
}