/*

Refer: Durgasoft YouTube

*/

package generics;

class My_Generic_3<T>
{
	My_Generic_3(T a, T b)
	{
		System.err.println("\nData Received is: "+a+" "+b);
	}
}

public class Generics_Part_3 
{
	static void My_Meth(My_Generic_3<?> m)//By this, we can pass generic object in method
	//We need to specify data type here tho, '?' indicates that it can receive any type. 'extends' will also
	//work here.
	//Although when '?' is used, we cannot perform much operations on the object received
	//'?' can be used to create reference variable but not object.
	{
		System.out.println("\nFrom Method: "+m.toString());
	}
	
	public static void main(String[] args) 
	{
		My_Generic_3<Integer> i = new My_Generic_3<Integer>(1, 2);
		My_Meth(i);
	}
}
