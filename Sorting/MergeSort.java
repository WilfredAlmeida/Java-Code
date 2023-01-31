
public class MergeSort
{
    public static void main(String[] args)
    {
        int arr[] = {5,4,3,5,2,1};

        System.out.println("\nUnsorted List: ");

        printArray(arr);

        merge_sort(arr,0, arr.length-1);

        System.out.println("\nSorted List: ");

        printArray(arr);
    }

    static void printArray(int arr[])
    {
        for(int i:arr)
        {
            System.out.print(i+" ");
        }
    }

    static void merge_sort(int[] arr, int l, int h)
    {
        if(l<h)
        {
            int mid = (l+h)/2;
            merge_sort(arr, l, mid);
            merge_sort(arr, mid+1, h);
            merge(arr,l,mid,h);
        }
    }

    static void merge(int arr[], int l, int m, int h)
    {
        int i = l, j = m+1, k = l;

        int aux[] = new int[arr.length];
        
        while(i <= m && j <= h)
        {
            if(arr[i] < arr[j])
                aux[k++] = arr[i++];

            else
                aux[k++] = arr[j++];
        }

        for(;i<=m;i++)
            aux[k++] = arr[i];

        for(;j<=h;j++)
            aux[k++] = arr[j];

        for(int x=l;x<=h;x++)
            arr[x] = aux[x];
    }
}