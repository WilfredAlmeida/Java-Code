/*

Refer: Code N Code Videos

Question Link: https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/social-networking-graph/

*/

import java.util.*;

public class Social_Networking_Graph 
{
    static private class Graph
    {
        static int size = 1000001;
        static int[] visited = new int[size];
        static int[] level = new int[size];
        static int[] distances = new int[size];

        static ArrayList<LinkedList<Integer>> ll = new ArrayList<LinkedList<Integer>>();

        static LinkedList<Integer> queue = new LinkedList<Integer>();

        static
        {
            for(int i=0;i<size;i++)
            {
                ll.add(new LinkedList<Integer>());
            }
        }

        static void bfs(int n)
        {
            visited[n] = 1;
            distances[n] = 0;
            queue.offer(n);

            while(!queue.isEmpty())
            {
                int a = queue.poll();

                for(int i:ll.get(a))
                {
                    if(visited[i] != 1)
                    {
                        visited[i] = 1;
                        distances[i] = distances[a]+1;
                        queue.offer(i);
                        level[distances[i]]++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        
        int n,m,a,b,src,d, t;

        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        m = s.nextInt();

        for(int i=0;i<m;i++)
        {
            a = s.nextInt();
            b = s.nextInt();

            Graph.ll.get(a).add(b);
            Graph.ll.get(b).add(a);
        }

        t = s.nextInt();
        while(t--!=0)
        {
            src = s.nextInt();
            d = s.nextInt();

            for(int i=0;i<=n;i++)
            {
                Graph.visited[i] = 0;
                Graph.level[i] = 0;
            }
            Graph.bfs(src);

            System.out.println(Graph.level[d]);
        }
        s.close();
    }
}
