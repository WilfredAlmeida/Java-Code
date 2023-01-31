/*

Refer: CodeNCode Videos

Read Notes written in notebook

Sample I/p:

9 10
1 2
3 4
1 8
2 9
2 5
4 5
4 8
5 9
5 7
6 7

OP: 1 3 6 2 4 5 8 9 7

*/

import java.util.*;


public class Topological_Sort
{	
	static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(100);
	
	static int indegree[] = new int[100];
	
	static LinkedList<Integer> queue = new LinkedList<Integer>();
	
	static StringBuffer result = new StringBuffer("");
	
	static
	{
		for(int i=0;i<100;i++)
			adjacency_list.add(new LinkedList<Integer>());
	}
	
	public static void main(String[] args) 
	{
		int number_of_nodes,number_of_edges;
		
		Scanner scanner = new Scanner(System.in);
		
		number_of_nodes = scanner.nextInt();
		number_of_edges = scanner.nextInt();
		
		for(int i=1;i<=number_of_edges;i++)
		{
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			adjacency_list.get(a).add(b);
			
			indegree[b]++;
		}
		
		topological_sort(number_of_nodes);
		
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
	
}
