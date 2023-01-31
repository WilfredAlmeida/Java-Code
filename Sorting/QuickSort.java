public class QuickSort
{
    public static void main(String[] args) 
    {
        int arr[] = {5,4,3,2,1,Integer.MAX_VALUE};

        System.out.println("Unsorted List: \n");

        printArray(arr);

        quick_sort(arr,0,arr.length-1);

        System.out.println("\nSorted List: \n");

        printArray(arr);
    }

    static void printArray(int arr[])
    {
        for(int i:arr)
        {
            System.out.print(i+" ");
        }
    }

    static void quick_sort(int arr[], int l, int h)
    {
        if(l<h)
        {
            int pivot = partition(arr,l,h);
            quick_sort(arr, l, pivot);
            quick_sort(arr, pivot+1, h);
        }
    }

    static int partition(int arr[], int l, int h)
    {
        int pivot = arr[l], i = l, j = h;

        while(i<j)
        {
            do{i++;}while(pivot >= arr[i]);
            do{j--;}while(pivot < arr[j]);

            if(i<j)
            {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[l];
        arr[l] = arr[j];
        arr[j] = t;

        return j;
    }
}