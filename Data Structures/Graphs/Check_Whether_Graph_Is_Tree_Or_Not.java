/*

Refer: Code N Code videos

Given an unweighted, undirected graph. Check if its a tree or not.

A graph is a tree is there are cyclic edges i.e. number of edges is != n-1 where n is number of edges, if there would be a cycle, number of edges would be more. And there aren't multiple components in the graph i.e. number of components is 1.

So we check for both these conditions.

Sample:
    I/p:
    3 2
    1 2
    2 3

    O/p:
    Yes

For comments, see "Counting_Components.java" cuz everything is same. What's unique to this code is commented below.

*/

import java.util.*;

public class Check_Whether_Graph_Is_Tree_Or_Not
{
    private static class Graph
    {
        static int size = 100;
        static int[] visited = new int[size];
        static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(size);

        static
        {
            for(int i=0;i<size;i++)
                adjacency_list.add(new LinkedList<Integer>());
        }

        static void dfs(int n)
        {
            visited[n] = 1;

            for(int i: adjacency_list.get(n))
                if(visited[i] != 1)
                    dfs(i);
        }
    }

    public static void main(String[] args) 
    {
        int number_of_edges=0, number_of_vertices=0, vertex_1=0, vertex_2=0, components_count=0;

        Scanner scanner = new Scanner(System.in);

        number_of_vertices = scanner.nextInt();
        number_of_edges = scanner.nextInt();

        for(int i=0;i<number_of_edges;i++)
        {
            vertex_1 = scanner.nextInt();
            vertex_2 = scanner.nextInt();

            Graph.adjacency_list.get(vertex_1).add(vertex_2);
            Graph.adjacency_list.get(vertex_2).add(vertex_1);
        }

        for(int i=1;i<=number_of_edges;i++)
        {
            if(Graph.visited[i] != 1)
            {
                Graph.dfs(i);
                components_count++;
            }
        }


        //As explained above
        if(number_of_edges == number_of_vertices-1 && components_count == 1)
            System.out.println("Its a Tree");
        else
            System.out.println("Its not a Tree");

        scanner.close();
    }
}