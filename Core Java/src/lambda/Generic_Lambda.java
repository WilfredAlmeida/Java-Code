/*

Refer: Complete Reference 11 book

*/

package lambda;

interface MyInterface1<T>
{
	T get(T a);
}

public class Generic_Lambda 
{
	public static void main(String[] args) 
	{
		MyInterface1<Integer> i = (a) -> a;
		System.out.println(i.get(10));
		
		MyInterface1<String> s = (a) -> a;
		System.out.println(s.get("Wilfred"));
	}
}
