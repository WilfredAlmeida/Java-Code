// { Driver Code Starts
    import java.io.*;
    import java.lang.*;
    import java.util.*;
    
    class Item {
        int value, weight;
        double pw = value;
        Item(int x, int y){
            this.value = x;
            this.weight = y;

            if(weight != 0)
                pw = value/weight;
        }
    }
    
    public class MyFractionalKnapsack {
        
        public static void main(String[] args) throws IOException{

            int n = 3, w = 50;
            int values[] = {60,100,120};
            int weight[] = {10,20,30};

            Item arr[] = new Item[n];

            for(int i=0;i<n;i++)
            {
                arr[i] = new Item(values[i],weight[i]);
            }

            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        
        }
    }// } Driver Code Ends
    
    
    /*
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
    */
    
    class Solution{
        double fractionalKnapsack(int W, Item arr[], int n) {
            
            double profit = 0;

            mergeSort(arr,0,n-1);
            
            for(int i=0;i<n;i++)
            {
                if(W>0 && W <= arr[i].weight)
                {
                    W -= arr[i].weight;
                    profit += arr[i].value;
                }
                else
                {
                    profit += profit * (W/arr[i].weight);
                }
            }
            
            return profit;
            
        }
        
        void mergeSort(Item arr[], int l, int h)
        {
            if(l<h)
            {
                int mid = (l+h)/2;
                
                mergeSort(arr,l,mid);
                mergeSort(arr,mid+1,h);
                merge(arr,l,mid,h);
            }
        }
        
        void merge(Item arr[], int l, int m, int h)
        {
            Item aux[] = new Item[arr.length];
            
            int i = l, j = h, k = l;
            
            while(i<=m && j<=h)
            {
                if(arr[i].pw < arr[j].pw)
                {
                    aux[k++] = arr[i++];
                }
                else
                    aux[k++] = arr[j++];
                    
                for(;i<=m;i++)
                    aux[k++] = arr[i];
                    
                for(;j<=h;j++)
                    aux[k++] = arr[j];
                    
                for(i=l;i<=h;i++)
                    arr[i] = aux[i];
            }
        }
        
    }