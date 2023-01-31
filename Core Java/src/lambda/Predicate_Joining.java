/*

Refer: Durgasoft YouTube, Durgasoft PDF Notes

It’s possible to join predicates into a single predicate by using the following methods:
and()
or()
negate()
these are exactly same as logical AND ,OR complement operators.
and(), or(), negate() are default methods present inside Predicate interface.

Following is a program to check if a number is even and greater than 10.
We will write 2 predicate conditions and combine them using above methods.

*/

package lambda;

import java.util.function.Predicate;

public class Predicate_Joining 
{
	public static void main(String[] args) 
	{
		int arr[] = {2,1,234,123,54,23,65,34,77,45,3,4,5,6,7};
		
		Predicate<Integer> p1 = (a)-> a%2==0;
		Predicate<Integer> p2 = (b)->b>10;
		
		for(int i:arr)
			if(p1.and(p2).test(i))//Here, we can as many as 'and()', 'or()', 'negate()' we want.
				System.out.println(i);
	}
}
