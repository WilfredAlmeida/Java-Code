/*

Refer: Code N Code Videos

Question: https://www.spoj.com/problems/PPATH/

Lets say 'a' and 'b' are the 2 prime numbers and 'a' is to be converted into 'b'. 
So what we do is we'll first take out all prime numbers between 'a' and 'b' into a list. 
Then we'll make a graph from those values. 2 values will have a connecting edge if they differ only by one digit. 
For eg. 11 and 19 will have an edge cuz they differ only by 1 digit, if we change 1 to 9 from 11, we'll have 19. 
So like this, we'll connect each edge and then we'll find shortest path from 'a' to 'b' and thats our answer.

Sample I/P:
3
1033 8179
1373 8017
1033 1033

*/

import java.util.*;

public class Prime_Path 
{
    private static class Graph
    {
        static int size = 10005;
        static int[] visited = new int[size];
        static int[] distances = new int[size];
        
        //As explained above, to store prime numbers from 'a' to 'b'
        static ArrayList<Integer> primes = new ArrayList<Integer>(size);

        static ArrayList<LinkedList<Integer>> adjacency_list = new ArrayList<LinkedList<Integer>>(size);

        //BFS Queue
        static LinkedList<Integer> queue = new LinkedList<Integer>();

        static
        {
            for(int i=0;i<size;i++)
            {
                adjacency_list.add(new LinkedList<Integer>());
                distances[i]=-1;
            }
        }

        static void clear()//Clears memory for next  test case
        {
            for(int i=0;i<size;i++)
            {
                distances[i] = -1;
                visited[i]=0;
            }
            queue.clear();
        }

        //Check if a number is prime. Used to check if a number btwn 'a' to 'b' is prime or not to add it into prime numbers
        static boolean isPrime(int n)
        {
            for(int i=2;i<n;i++)
            {
                if(n%i == 0) 
                    return false;
            }
            return true;
        }

        //Check of 2 numbers are valid to have an edge btwn them. This done by counting: by how digits do they difer, if the count is 1, they will have an edge btwn them.
        static boolean isValid(int a, int b)
        {
            int c = 0;

            while(a>0)
            {
                if(a%10 != b%10)//Checks their last digit, if they are equal, increases count
                c++;

                //As we have checked the last digit, we don't need it so we remove it.
                a /= 10;
                b /= 10;
            }

            //As the numbers would be valid if they differ by only 1 digit, so we return whether their difference count is 1 or not
            return c==1;
        }

        static void buildGraph()
        {
            //Add all 4 digit prime numbers to list
            for(int i=1000;i<=9999;i++)
            {
                if(isPrime(i))
                    primes.add(i);
            }

            //Forming Adjacency List. We take every prime number and compare it with every number ahead it and if they are valid, we make an edge btwn them
            for(int i=0;i<primes.size();i++)
            {
                for(int j=i+1;j<primes.size();j++)
                {
                    int a = Graph.primes.get(i), b= Graph.primes.get(j);
                    if(isValid(a,b))
                    {
                        adjacency_list.get(a).push(b);
                        adjacency_list.get(b).push(a);
                    }
                }
            }
        }

        //Normal SSSP using bfs.
        static void bfs(int n)
        {
            visited[n] = 1;
            distances[n] = 0;
            queue.offer(n);

            while(!queue.isEmpty())
            {
                int a = queue.poll();

                for(int i:adjacency_list.get(a))
                {
                    if(visited[i] != 1)
                    {
                        visited[i] = 1;
                        distances[i] = distances[a]+1;
                        queue.offer(i);
                    }
                }
            }
        }
    }
    public static void main(String[] args) 
    {
        int test_case_count=0, num1=0,num2=0;

        Scanner scanner = new Scanner(System.in);

        test_case_count=scanner.nextInt();

        Graph.buildGraph();
        
        while(test_case_count != 0)
        {
            num1 = scanner.nextInt();
            num2 = scanner.nextInt();
            
            Graph.clear();
            
            Graph.bfs(num1);

            //As we are bfs'ing num1, it will give shortest paths to every node in list, so if there exists a path btwn 'num1' and 'num2', we'll get the distance here.
            if(Graph.distances[num2] == -1)
                System.out.print("Impossible");
            else
                System.out.println(Graph.distances[num2]);

            test_case_count--;
        }
        scanner.close();
    }
}