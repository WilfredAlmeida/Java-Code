/*

Refer: Code N Code Videos

In/Out time is the time spent for dfs'ing a node. In time is the time of entry and out time is the time of exit from a node.


Using In/Out times, we can solve a prblem of finding that if we are given 2 nodes, than is one node in subtree of other node. To find that, following are the rules:

INTIME of root is SMALLER than intime of children.
OUTIME of root is GREATER than outime of childern.

*/

import java.util.*;

public class In_Out_Time 
{
    private static class Graph
    {
        static int size=100;
        static int[] visited = new int[size];
        static int[] intime = new int[size];
        static int[] outime = new int[size];
        static int timer = 1;

        static ArrayList<LinkedList<Integer>> ll = new ArrayList<LinkedList<Integer>>(size);

        static
        {
            for(int i=0;i<size;i++)
                ll.add(new LinkedList<Integer>());
        }

        static void dfs(int n)
        {
            visited[n] =1;
            intime[n] = timer++;//Control entered to dfs a node, now we store the the entry time. Now for other dfs's to get the timer of their entry we increment it. As here recursion is used, other nodes won't consider current nodes' exit time.

            for(int i:ll.get(n))
            {
                if(visited[i] != 1)
                    dfs(i);
            }

            //Not that control is leaving, we record current time and mark it as out time. Incrementation is done cuz time flows and we aren't using real time here so our used time needs to flow. :)
            outime[n] = timer++;
        }
    }

    public static void main(String[] args) {
        
        int v=0,e=0,n=0,m=0;

        Scanner s = new Scanner(System.in);

        v = s.nextInt();
        e = s.nextInt();

        for(int i=0;i<e;i++)
        {
            n = s.nextInt();
            m = s.nextInt();

            Graph.ll.get(m).add(n);
            Graph.ll.get(n).add(m);
        }

        for(int i=1;i<=v;i++)
        {
            if(Graph.visited[i] != 1)
                Graph.dfs(i);
        }

        System.out.print("\nIntime's: ");
        for(int i=1;i<=e+1;i++)
        {
            System.out.print(Graph.intime[i]+" ");
        }

        System.out.print("\nOutime's: ");
        for(int i=1;i<=e+1;i++)
        {
            System.out.print(Graph.outime[i]+" ");
        }


        System.out.print("\n");

        int n1=s.nextInt(),n2=s.nextInt();

        if(Graph.intime[n1]<Graph.intime[n2] && Graph.outime[n1]>Graph.outime[n2])
            System.out.print("\nParent is: "+n1+" Child is: "+n2);
        
        else if(Graph.intime[n2]<Graph.intime[n1] && Graph.outime[n2]>Graph.outime[n1])
            System.out.print("\nParent is: "+n2+" Child is: "+n1);

        else
            System.out.print("\nThey aren't in same subtrees");

        s.close();

    }
}