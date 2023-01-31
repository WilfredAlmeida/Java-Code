/*

Refer: Code N Code videos

Question Link: https://www.codechef.com/problems/FIRESC

To solve this, we count number of components for exit routes

*/
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Fire_Escape_Routes {

	static int size = 100;
	static int visited[] = new int[size];
	
	static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(size);
	
	static {
		for(int i=0;i<size;i++) {
			adjacency_list.add(new LinkedList<Integer>());
		}
	}
	
	static int connected_components_size = 0;
	static int friends_count = 0;
	static long result = 1;
	
	
	static void dfs(int node) 
	{
		visited[node] = 1;
		friends_count++;
		
		for(int child:adjacency_list.get(node)) {
			if(visited[child] == 0)
				dfs(child);
		}
	}
	
	public static void main(String[] args) throws Exception {
		//Scanner s = new Scanner(System.in);
		
		//BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        FastReader s = new FastReader();

		
		int t = s.nextInt();
		
		while(t-- > 0) {
			
			int n = s.nextInt();
			int m = s.nextInt();
			
			for(int i=1;i<=n;i++) {
				adjacency_list.get(i).clear();
				visited[i] = 0;
			}
			
			connected_components_size = 0;
			result = 1;
			friends_count = 0;
			
			
			for(int i=0;i<m;i++) {
				int friend_1 = s.nextInt();
				int friend_2 = s.nextInt();
				
				adjacency_list.get(friend_1).add(friend_2);
				adjacency_list.get(friend_2).add(friend_1);
				
			}
			
			for(int i=1;i<=n;i++) {
				if(visited[i] == 0) {
					friends_count = 0;
					dfs(i);
					connected_components_size++;
					result = (result*friends_count) % (10000000000L+7);
				}
			}
			
			
			System.out.println(connected_components_size+" "+result);
		

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