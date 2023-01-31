public class HelloWoryld{
    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        swap(a,1,2);

        System.out.println(a[1]+" "+a[2]);;
    }

    static void swap(int a[],int m,int n)
    {
            int t = a[m];
            a[m] = a[n];
            a[n] = t;
    }
}