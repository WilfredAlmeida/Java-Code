/*

Refer: Complete Reference 11 book

Normally a method can receive reference to interface as parameter, it can be a lambda reference too :-)

*/

package lambda;

@FunctionalInterface
interface MyInterface2
{
	void square(int a);
}

public class Lambda_as_Arguement 
{
	public static void main(String[] args) 
	{
		MyInterface2 m = (a)-> System.out.println(a*a); 
		
		m1(m, 2);
	}
	
	static void m1(MyInterface2 m, int x)
	{
		m.square(x);
	}
}
