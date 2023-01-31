/*

Question Link: https://practice.geeksforgeeks.org/problems/union-of-two-arrays/0#

This is self thought :)

What we do is take an quxillary array whose index range is equal to max input constraint. Now we loop both arrays and for every element, we increment its equivalent index in auxillary array, this is the same thing we do in count sort. We count the number of each element but count doesn't matter, we just want to know which element is there.

We traverse the auxillary array and for every element whose count isn't 0, we add it into resultant union array.

Sample input:
2
5 3
1 2 3 4 5
1 2 3
6 2
85 25 1 32 54 6
85 2

*/
import java.io.*;
import java.util.*;

public class Union_Of_Two_Arrays {
    public static void main(String[] args) {

        int number_of_test_cases, size_of_array_1, size_of_array_2;

        Scanner scanner = new Scanner(System.in);

        number_of_test_cases = scanner.nextInt();

        while (number_of_test_cases-- != 0) {
            size_of_array_1 = scanner.nextInt();
            size_of_array_2 = scanner.nextInt();

            int[] array_1 = new int[size_of_array_1];
            int[] array_2 = new int[size_of_array_2];

            for (int i = 0; i < size_of_array_1; i++)
                array_1[i] = scanner.nextInt();

            for (int i = 0; i < size_of_array_2; i++)
                array_2[i] = scanner.nextInt();

            int[] unionn = new int[size_of_array_2 + size_of_array_1];
            int result_count=0;
            int[] auxillary_array = new int[100001];
            
            for(int i=0;i<size_of_array_1;i++)
                auxillary_array[array_1[i]]++;
            
            for(int i=0;i<size_of_array_2;i++)
                auxillary_array[array_2[i]]++;
            
            for(int i=0;i<auxillary_array.length;i++)
                if(auxillary_array[i] != 0)
                    unionn[result_count++] = i;

            System.out.println(result_count);
            scanner.close();

        }

    }
}