/*

Refer: CodeNCode Videos

Read notes written in notebook


9 11
1 2
2 3
2 4
3 4
1 7
1 6
7 6
1 5
5 8
5 9 
8 9


 */

import java.util.*;

public class Articulation_Points {

	
	static int size = 100;
	static int[] visited = new int[size];
	static int[] in_time = new int[size];
	static int[] low_time = new int[size];
	static int timer=0;
	static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(size);
	
	static HashSet<Integer> articulation_points = new HashSet<Integer>();
	
	static 
	{
		for(int i=0;i<size;i++) 
		{
			adjacency_list.add(new LinkedList<Integer>());
			visited[i] = 0;
			low_time[i] = -1;
			in_time[i] = -1;
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		int number_of_nodes = scanner.nextInt();
		int number_of_edges = scanner.nextInt();
		
		for(int i=1;i<=number_of_edges;i++) 
		{
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			adjacency_list.get(a).add(b);
			adjacency_list.get(b).add(a);
		}
		
		for(int i=1;i<=number_of_nodes;i++)
			if(!(visited[i]==1))
			dfs(i,-1);
		
		for(int i:articulation_points)
		{
			System.out.println(i);
		}
		
		scanner.close();
		
	}
	
	static void dfs(int current_node, int parent)
	{
		visited[current_node] = 1;
		in_time[current_node] = timer;
		low_time[current_node] = timer;
		timer++;
		
		int children_count = 0;
		
		for(int connected_node: adjacency_list.get(current_node))
		{
			if(connected_node == parent) continue;
			
			if(visited[connected_node] == 1)
			{
				low_time[current_node] = Math.min(low_time[current_node], low_time[connected_node]);
			}
			else
			{
				dfs(connected_node, current_node);
				
				low_time[current_node] = Math.min(low_time[current_node], low_time[connected_node]);
				
				if(low_time[connected_node]>=in_time[current_node] && parent!=-1) 
				{
					articulation_points.add(current_node);
				}
				
				children_count++;
			}
		}
		if(parent == -1 && children_count > 1)
			articulation_points.add(current_node);
	}
	
}
