/*

Refer: Code N Code Videos

Size of a subtree would be 1 for itself + size of its subtree. Thats recursion :)

Sample I/P:
7 6
1 2
2 3
3 7
2 4
4 5
4 6

*/

import java.util.*;

public class Size_Of_Subtree {

    private static class Graph
    {
        static int size = 100;
        static int[] visited = new int[size];
        static int[] subsize = new int[size];

        static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(size);

        static
        {
            for(int i=0;i<size;i++)
                adjacency_list.add(new LinkedList<Integer>());
        }

        static int dfs(int node)
        {
            visited[node] = 1;
            int sub_size = 1;

            for(int child:adjacency_list.get(node))
            {
                if(visited[child] != 1)
                    sub_size += dfs(child);
            }

            subsize[node] = sub_size;
            return sub_size;
        }

    }

    public static void main(String[] args) {

        int vertices=0,edges=0,vertex_1=0,vertex_2=0;

        Scanner scanner = new Scanner(System.in);

        vertices = scanner.nextInt();
        edges = scanner.nextInt();

        for(int i=0;i<edges;i++)
        {
            vertex_1 = scanner.nextInt();
            vertex_2 = scanner.nextInt();

            Graph.adjacency_list.get(vertex_1).add(vertex_2);
            Graph.adjacency_list.get(vertex_2).add(vertex_1);
        }
        
        Graph.subsize[1] = Graph.dfs(1);
        for(int i=1;i<=vertices;i++)
        {
            System.out.println("Size of "+i+"'s subtree is "+Graph.subsize[i]);
        }

        scanner.close();
    }

}