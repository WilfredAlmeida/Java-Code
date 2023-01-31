/*

Refer: Durgasoft YouTube

Purpose of Generics is to provide Type-Safety and to resolve Type-Casting Problems.

A generic thing(Class, Method, Interface) in java can take and process any type of object and process
it at runtime. The data type of the data to be processed is not known at compilation. Instead it is
denoted by generic type 'T'. Generic feature of java allows reuse of code and reduces code length
of code by processing multiple data types. 

A generic thing can only process objects, so primitive data types cannot be directly used with generics,
instead, they should be boxed in their respective types. int -> Integer

*/

package generics;

class My_Generic<T>//'<>' Angular notations are exclusively used for generics, you find them, it
//means generics are here. 'T' is to indicate generic data type. It will be replaced by datatype sent
//while object creation of 'My_Generic'.
//Here 'T' can be any valid Java Identifier
{
	 T ob;//This statement is fully fledged like any other statement like 'int i', there is no difference, treat
	 //them same.
	public My_Generic(T ob) 
	{
		this.ob = ob;
	}
	
	void showData()
	{
		System.out.println("Data is: "+ob+"\nIts Class is: "+ob.getClass().getName());
		//getClass().getName() can be used on any object in Java.
	}
	
	T getData()//Notice return type here.
	{
		return ob;
	}
}


public class Generics_Part_1 {

	public static void main(String[] args) 
	{
		
		//Datatype is specified at runtime. Its same as normal object just the '<>' for genericness
		My_Generic<Integer> ob1 = new My_Generic<Integer>(10);
		ob1.showData();
		System.out.println("Data sent from main is: "+ob1.getData()+"\n");
		
		My_Generic<Double> ob2 = new My_Generic<Double>(10.34);
		ob2.showData();
		System.out.println("Data sent from main is: "+ob2.getData()+"\n");
		
		My_Generic<String> ob3 = new My_Generic<String>("Wilfred");
		ob3.showData();
		System.out.println("Data sent from main is: "+ob3.getData()+"\n");
	}

}