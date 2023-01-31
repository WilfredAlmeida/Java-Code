/*

Refer: Abdul Bari Algo Analysis video 3.3 and Gate Smashers YouTube Algo Analsis video L-4.6

We have elements to merge, they have costs of merging, here we have integer array elements as costs.

Algorithm:

1. Create Min Heap with 'n' elements where 'n' is number of elements.
2. For each iteration, remove two minimum elements 'a' and 'b' from heap and put 'a+b' back in heap and add cost 'a+b' to total cost.

The total number of iterations is 'n-1' for merging 'n' elements.

Heap is simple and fantastically documented in C code, look up there :).
DO NOT proceed without understanding the C code.

*/

public class Optimal_Merge_Pattern {

    public static void main(String[] args) {
        int heap[] = { 10, 20, 30 };

        //Class has methods which heapifies the above array and has delete and insert methods
        Heap_Operations o = new Heap_Operations(heap);

        //Merging stuff Begins

        int cost = 0;//Total cost of merging

        for (int i = 0; i < heap.length - 1; i++)//As explained above, we need 'n-1' iterations
        {
            //Delete 2 minimum elements from heap
            int a = o.delete_from_heap(heap);
            int b = o.delete_from_heap(heap);

            //Merge them
            int s = a + b;

            //Add cost of their merging to total cost
            cost += s;

            //Heapify insert merged element into min heap and repeat
            o.insert_into_heap(heap, s);
        }

        System.out.println("\n" + cost);

    }

}

class Heap_Operations {
    //Last index of complete binary tree in array, after it, there will be empty spaces as we'll delete root and replace it with last element, required for deletion.
    int last_index;

    //Local heap copy
    int heap[];

    Heap_Operations(int heap[]) {
        last_index = heap.length - 1;
        this.heap = heap;

        //We heapify the heap, read C code comments.
        for (int i = (heap.length / 2) - 1; i >= 0; i--)
            heapify(heap, i);
    }

    //Heapify methods, read C code comments
    void heapify(int heap[], int i) {
        while (i >= 0) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            int smallest = i;

            if (left < last_index + 1 && heap[left] < heap[smallest])
                smallest = left;

            if (right < last_index + 1 && heap[right] < heap[smallest])
                smallest = right;

            if (i != smallest)
                swap(heap, i, smallest);
            else
                break;

            i = smallest;
        }
    }

    //Insert method to insert merged value into heap
    void insert_into_heap(int heap[], int n) {

        //Put the merged element at end of heap
        heap[last_index++] = n;

        //Heapify the heap
        for (int i = ((last_index + 1) / 2) - 1; i >= 0; i--)
            heapify(heap, i);
    }

    //Deleting from heap, read C code comments
    int delete_from_heap(int heap[]) {
        int t = heap[0];

        heap[0] = heap[last_index--];

        if (last_index < 0)
            last_index = 0;

        int i = 0;

        while (i <= last_index) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            int smallest = i;

            if (left <= last_index && heap[left] < heap[smallest])
                smallest = left;

            if (right <= last_index && heap[right] < heap[smallest])
                smallest = right;

            if (i != smallest)
                swap(heap, i, smallest);
            else
                break;

            i = smallest;
        }

        return t;
    }

    //Swap method to swap array values.
    void swap(int a[], int m, int n) {
        int t = a[m];
        a[m] = a[n];
        a[n] = t;
    }
}