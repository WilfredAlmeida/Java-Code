/*

Refer: Apni Kaksha

Question Link: https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1#

Kadene's Algortihm is used to find maximum sum of contiguous sub array. Sub array is small part of array and contigous means adjacent. So in array {1 2 3}, {1 2} can be contiguous sub array but {1 3} cannot. Although its a sub array, its not contiguous.

Simple approach is to find sums of all subarrays and find max among them but thats O(n^3).
Kadene does that in O(n).

Idea here is we maintain 2 variables, 'current_sum' and 'max_sum'. Then,

Initialize:
    max_sum = 0
    current_sum = 0

Loop for each element of the array

  (a) current_sum = current_sum + a[i]
  (b) if(current_sum < 0)
            current_sum = 0
  (c) if(max_sum < current_sum)
            max_sum = current_sum

return max_sum

What we do above is take sum each of each element in 'current_sum' as we proceed and if that sum is -ve, it can't be max so we reset it to 0.
Also, if the 'current_sum' we got is greater than the 'max_sum', we set 'max_sum' equal to 'current_sum'.

Sample IP:
5
1,2,3,-2,5

O/P: 9

*/
import java.io.*;

class Array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            // size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Kadane obj = new Kadane();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr, n));
        }
    }
}

class Kadane {

    // Function to find subarray with maximum sum
    // arr: input array
    // n: size of array
    int maxSubarraySum(int arr[], int n) {

        int max_sum = 0, current_sum = 0;
        for (int i = 0; i < n; i++) {
            current_sum += arr[i];
            if (current_sum < 0)
                current_sum = 0;
            if (max_sum < current_sum)
                max_sum = current_sum;
        }

        return max_sum;

    }

}
