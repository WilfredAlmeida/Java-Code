public class countSort 
{
	public static void main(String[] args) 
	{
		//int arr[] = {2, 3, 4, 2, 3, 6, 8, 4, 5};
		int arr[] = {5,4,3,2,1,2};
		
		printArray(arr);
		
		count_sort(arr);
		
		printArray(arr);
	}
	
	static void printArray(int[] arr)
	{
		System.out.println("\nArray is:");
		for(int i : arr)
			System.out.print(" "+i);
	}
	
	static void count_sort(int arr[])
	{
		int max = getMax(arr);
		System.out.println("\nMax "+max+"\n");
		int res[] = new int[max+1];
		
		for(int i=0;i<arr.length;i++)
		{
			res[arr[i]]++;
		}
		int a = 0;
		for(int i=0;i<res.length;i++)
		{
			if(res[i] > 0)
			{
				while(res[i] != 0)
				{
					arr[a++] = i;
					res[i]--;
				}
			}
			
		}
	}
	
	static int getMax(int arr[])
	{
		int max = arr[0];
		for(int i=1;i<arr.length;i++)
			if(arr[i] > max)
				max = arr[i];
		return max;
	}
}
