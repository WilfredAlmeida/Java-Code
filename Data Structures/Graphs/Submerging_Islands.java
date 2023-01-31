/*

Refer: CodeNCode Videos

https://www.spoj.com/problems/SUBMERGE/

*/

import java.util.*;

public class Submerging_Islands {
	
	static int size = 10001;
	static ArrayList<LinkedList<Integer>> adjacency_list;
	static int[] intime;
	static int[] lowtime;
	static int timer = 1;
	static int[] visited;
	
	
	static HashSet<Integer> articulation_points = new HashSet<Integer>();
	

	static void dfs(int current_node, int parent)
	{
		visited[current_node] = 1;
		intime[current_node] = timer;
		lowtime[current_node] = timer;
		++timer;
		int children_count=0;
		
		for(int connected_node: adjacency_list.get(current_node))
		{
			if(connected_node == parent) continue;
			
			if(visited[connected_node] == 1)
				lowtime[current_node] = Math.min(lowtime[current_node], intime[connected_node]);
			else
			{
				dfs(connected_node,current_node);
				
				lowtime[current_node] = Math.min(lowtime[current_node], lowtime[connected_node]);
				
				if(lowtime[connected_node] >= intime[current_node] && parent != -1)
					articulation_points.add(current_node);
				
				children_count++;
			}
			
			if(parent==-1 && children_count > 1)
				articulation_points.add(current_node);
		}
	}
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
		
			int number_of_nodes = scanner.nextInt();
			int number_of_edges = scanner.nextInt();
		
			adjacency_list = null;
			adjacency_list = new ArrayList<LinkedList<Integer>>(number_of_nodes+2);
			visited = new int[number_of_nodes+2];
			intime = new int[number_of_nodes+2];
			lowtime = new int[number_of_nodes+2];
			
			if(number_of_edges==0&&number_of_nodes==0)
				break;
			
			for(int i=0;i<number_of_nodes+1;i++)
			{
				adjacency_list.add(new LinkedList<Integer>()); 
				visited[i] = 0;
				intime[i] = -1;
				lowtime[i] = -1;
				timer=1;
			}
			
			for(int i=1;i<=number_of_edges;i++) 
			{
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				
				adjacency_list.get(a).add(b);
				adjacency_list.get(b).add(a);
			}
			
			dfs(1,-1);
			
			System.out.println(articulation_points.size());
			
		}
	}
}
