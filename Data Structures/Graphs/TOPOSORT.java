/*

Refer: CodeNCode Videos

https://www.spoj.com/problems/TOPOSORT/

*/


import java.io.*;
import java.util.*;


public class TOPOSORT
{	
	static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(10000);
	
	static int indegree[] = new int[10000];
	
	static PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	
	static StringBuffer result = new StringBuffer("");
	
	static
	{
		for(int i=0;i<10000;i++)
			adjacency_list.add(new LinkedList<Integer>());
	}
	
	public static void main(String[] args) 
	{
		int number_of_nodes=0,number_of_edges;
		
		//FastReader scanner = new FastReader();
		
		Scanner scanner = new Scanner(System.in);
		
		if(scanner.hasNextInt())
		number_of_nodes = scanner.nextInt();
		number_of_edges = scanner.nextInt();
		
		for(int i=0;i<number_of_edges;i++)
		{
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			adjacency_list.get(a).add(b);
			
			indegree[b]++;
		}
		
		topological_sort(number_of_nodes);
		
		if(result.length() != number_of_nodes*2)
			System.out.println("Sandro fails.");
		else
			System.out.println(result.toString().trim());
		
	}
	
	static void topological_sort(int number_of_nodes)
	{
		for(int i=1;i<=number_of_nodes;i++)
		{
			if(indegree[i] == 0)
				queue.add(i);
		}
		
		while(!queue.isEmpty())
		{
			int a = queue.poll();
			result.append(a+" ");
			
			for(int connected_element: adjacency_list.get(a))
			{
				indegree[connected_element]--;
				if(indegree[connected_element] == 0)
					queue.add(connected_element);
			}
		}
	}

static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(
            new InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
}