/*

Refer: Durgasoft YouTube

See Generics_Part_1 before this.

As done in part 1, datatype could be any. But if we want to perform some operations that may not be
available for all objects than that would be problem. For eg. if we are performing arithmetic
operations on objects received and we pass String object than it will result in runtime error.

 So to solve this, we can specify 'T' as a superclass of objects that we would like to receive.
 
 In the following program, we want to perform arithmetic operations so we will specify 'T' as
 'Number' which is superclass of: "Byte, Short, Integer, Float, Double". This will allow our generic
 class to accept objects only related to 'Number' class and specifying anything else will result in
 compile time error. 

*/

package generics;

class My_Generic_2<T extends Number>
//This known as bounding of type parameters. Here, in place of Number, there can be any class or
//interface. 'extends' is permanent and cannot be changed.
//Here, we can write '<T extends Number & Runnable>'. This perfectly valid and now 'T' will take 
//both Number and Runnable type parameters., It can go on and on with '&'.
//Note that things after '&' can be only be interfaces and not other classes. Also class should be written
//first and interfaces after that. It will also work for one interface like 'T extends Runnable'.
{
	T a,b;
	My_Generic_2(T a, T b)
	{
		this.a = a;
		this.b = b;
	}
	
	void displayCalculations()
	{
		//Sadly we cannot perform directly using +, following is the only workaround
		
		if(a instanceof Integer && b instanceof Integer)
			System.out.println("Addition is: "+(Integer.parseInt(a.toString())+Integer.parseInt(b.toString())));
		
		if(a instanceof Float && b instanceof Float)
			System.out.println("Addition is: "+(Float.parseFloat(a.toString())+Float.parseFloat(b.toString())));
		
		if(a instanceof Double && b instanceof Double)
			System.out.println("Addition is: "+(Double.parseDouble(a.toString())+Double.parseDouble(b.toString())));
	}
}

public class Generics_Part_2 
{
	public static void main(String[] args) 
	{
		My_Generic_2<Integer> i = new My_Generic_2<Integer>(10,20);
		i.displayCalculations();
		
		My_Generic_2<Float> f = new My_Generic_2<Float>(10.25f,220.11f);
		f.displayCalculations();
		
		My_Generic_2<Double> d = new My_Generic_2<Double>(10.25d,30d);
		d.displayCalculations();
	}
}
