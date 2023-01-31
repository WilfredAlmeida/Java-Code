/*
Refer: Complete Reference 11 book

A lambda expression can throw an exception. However, it if throws a checked
exception, then that exception must be compatible with the exception(s) listed
in the throws clause of the abstract method in the functional interface.

*/

package lambda;

@FunctionalInterface
interface MyInterface3
{
	void m1() throws NullPointerException;
}

public class Lambda_and_Exceptions 
{
	public static void main(String[] args) 
	{
		MyInterface3  m = ()-> {throw new NullPointerException();};
		try {m.m1();}
		catch (NullPointerException e) {System.out.println("Hi "+e.getMessage());}
	}
}
