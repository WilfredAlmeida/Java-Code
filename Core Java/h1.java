// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    public class h1 {
        // Driver code
        public static void main(String[] args) throws Exception {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String inputLine[] = br.readLine().trim().split(" ");
                int n = Integer.parseInt(inputLine[0]);
                int m = Integer.parseInt(inputLine[1]);
                int arr1[] = new int[n];
                int arr2[] = new int[m];
                inputLine = br.readLine().trim().split(" ");
                for (int i = 0; i < n; i++) {
                    arr1[i] = Integer.parseInt(inputLine[i]);
                }
                inputLine = br.readLine().trim().split(" ");
                for (int i = 0; i < m; i++) {
                    arr2[i] = Integer.parseInt(inputLine[i]);
                }
    
                new Solution().merge(arr1, arr2, n, m);
    
                StringBuffer str = new StringBuffer();
                for (int i = 0; i < n; i++) {
                    str.append(arr1[i] + " ");
                }
                for (int i = 0; i < m; i++) {
                    str.append(arr2[i] + " ");
                }
                System.out.println(str);
            }
        }
    }// } Driver Code Ends
    
    
    class Solution {
    
        public void merge(int arr1[], int arr2[], int n, int m) {
            int i=0,j=0;
            
            
            while(i<arr1.length)
            {int c=0;
                j = 0;
                while(j<arr2.length&&j<=i)
                {
                    if(arr2[j] <= arr1[i])
                    {
                        int t = arr1[i];
                        arr1[i] = arr2[j];
                        arr2[j] = t;
                        
                    }
                    j++;
                }
                
                while(c<j+1){
            for(int p=0;p<j-1;p++)
            {
                if(arr2[p] >= arr2[p+1])
                {
                    int t = arr2[p];
                    arr2[p] = arr2[p+1];
                    arr2[p+1] = t;
                }
            }
            c++;
        } 
                
                i++;
            }
            
           // System.out.println("Start");
           // for(int k:arr2)
           //     System.out.print(" "+k);
           //     System.out.println("End");
            
           // for(int m=0;m<arr2.length-1;m++)
           // {
           //     for(int n=0;n<=arr2.length-1-m;n++){
           //     if(arr2[n] >= arr2[n+1])
           //     {
           //         int t = arr2[n];
           //         arr2[n] = arr2[n+1];
           //         arr2[n+1] = t;
           //     }
                    
           //     }
           // }
        }
    }
    /*
    1
    10 10
    7 9 9 10 11 11 13 14 17 19
    1 1 4 5 8 11 13 16 19 19

1
4 10
2 7 10 15
2 2 2 7 10 12 14 14 17 20
    */