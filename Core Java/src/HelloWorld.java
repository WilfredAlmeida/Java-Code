// { Driver Code Starts

import java.lang.*;
import java.io.*;
import java.util.*;

class HelloWorld {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String) br.readLine()).split("\\s+");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new solve().minJumps(arr));
        }
    }

}
// } Driver Code Ends

class solve {
    static int minJumps(int[] arr) {

        int jumps = -1, maxRange = arr.length-1, steps = 0;
        for (int i = 0; i < arr.length; i++) {
            //steps=0;
            while (steps <= maxRange) {
                int sc=0;
                while (steps < arr[i]||sc!=arr[i])
                    {steps++;sc++;}

                jumps++;
                if (steps <= arr[i] || sc==arr[i])
                    break;
            }

        }
        return jumps;

    }
}
/*

1
6
1 4 3 2 6 7

*/