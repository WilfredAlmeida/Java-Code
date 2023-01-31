/*

Refer: Durgasoft YouTube

Consumer is a functional interface that defines a method that takes one parameter and doesn't return
any value. The only  difference btwn 'Function' and 'Consumer' is that Consumer doesn't return any
value and Function does.

Consumer has method: public void accept(T t); where 'T' is generic.

*/

package lambda;

import java.util.function.Consumer;

public class Preddefined_Functional_Interface_Consumer 
{
	public static void main(String[] args) 
	{
		Student[] s = {
				new Student("A", 432),
				new Student("B", 345),
				new Student("C", 334)
		};
		
		Consumer<Student> c = (c1)->System.out.println("Name: "+c1.sname+" Marks: "+c1.smarks);
		Consumer<Student> f = (c2)->System.out.println(c2.sname+" is Male"); 
	
		for(Student i:s)
			c.accept(i);
		
		//Chaining is possible in Consumer. Following is an example.
		//Only 'andThen()' method is available here.
		c.andThen(f).accept(s[0]);
	}
}
