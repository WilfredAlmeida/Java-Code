/*

Refer: Complete Reference 11 book

We will practice generic interface here

*/

package generics;

interface MinMax<T extends Comparable<T>>//Interface to find min and max among 2 numbers
{
	T min();
	T max();
}

public class Generics_Part_5_Interfaces<T extends Comparable<T>> implements MinMax<T>
//Class implementing generic interface must also be generic
//This might be tricky to understand, read cmplete reference pdf pg 597
{
	T a,b;
	
	public Generics_Part_5_Interfaces(T a, T b) 
	{
		this.a = a;
		this.b = b;
	}
	
	public T min()
	{
		return a.compareTo(b) > 0?b:a;
	}
	
	public T max()
	{
		return a.compareTo(b) > 0?a:b;
	}
	
	public static void main(String[] args) 
	{
		Generics_Part_5_Interfaces<Integer> ob = 
				new Generics_Part_5_Interfaces<Integer>(10, 20);
		
		System.out.println("\nMin is: "+ob.min());
		System.out.println("\nMax is: "+ob.max());
		
		Generics_Part_5_Interfaces<Double> ob1 = 
				new Generics_Part_5_Interfaces<Double>(45.68985d, 23.44324d);
		
		System.out.println("\nMin is: "+ob1.min());
		System.out.println("\nMax is: "+ob1.max());
	}
}
