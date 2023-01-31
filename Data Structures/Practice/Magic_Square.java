// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

public class Magic_Square {

    // } Driver Code Ends

    // User function template for Java

    public static void sort012(int a[], int n) {

        int[] aux = new int[3];
        for (int i = 0; i < n; i++)
            aux[a[i]]++;

        int i = 0, j = 0;

        while (i <= 2) {
            if (aux[i] >= 1) {
                a[j++] = i;
                aux[i]--;
            } else
                i++;
        }

        System.out.print("\n");
        for (int k = 0; k < n; k++) {
            System.out.print(a[k] + " ");
        }

    }

    // { Driver Code Starts.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr[i] + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends
