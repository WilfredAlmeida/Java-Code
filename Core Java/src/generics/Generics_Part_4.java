/*

Refer: Durgasoft YouTube

Here we'll see Generic method, to declare a generic method, before its return type, specify '<T>'.
eg. public <T> void m1(T a). 'T' is local to this method only. We can also define bounded types at
method level(T extends Number).

Communication with Non-Generic code: When we send any object to generic area from non-generic
area, it will behave like generic object and if we send generic object to non generic area, it will behave
like non generic object. It follows the idea of "When in Rome, behave like the Romans".


*/

package generics;

import java.util.ArrayList;

public class Generics_Part_4 
{
	public static void main(String[] args) 
	{
		//Communication with non generic code
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(20);
		//al.add("W");//These 2 will produce error cuz arraylist is generic of Integer objects.
		//al.add('W');
		
		m1(al);//Watch this method below
		
		System.out.println(al);
	}
	

	static void m1(ArrayList al)//It takes normal/non-generic arraylist and as we can add any type of
	//data in normal arraylist, it does the same and adds String and char data to arraylist which is
	//meant to be of Integer type.
	{
		al.add("Wilfred");
		al.add('W');
	}
}
