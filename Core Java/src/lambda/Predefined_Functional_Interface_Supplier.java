/*

Refer: DurgaSoft YouTube

Supplier is a functional interface that does not take any input but returns an output.
It's abstract method is: public R get() where 'R' is its return type and a generic.

Following is a program to generate random otp

*/

package lambda;

import java.util.function.Supplier;

public class Predefined_Functional_Interface_Supplier 
{
	public static void main(String[] args) 
	{
		Supplier<String> s = ()->{
			String otp = "";
			
			for(int i=0;i<6;i++)
				otp += (int)(Math.random() * 10);
			
			return otp;
		};
		
		System.out.println("Otp is: "+s.get());
	}
}
