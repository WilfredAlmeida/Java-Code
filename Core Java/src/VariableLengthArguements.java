/*
 
 Refer: Complete Reference 11 Book
 
 Varargs are used to send multiple inputs to a method when it is not known how much arguments a method will receive. Variable-length argument is specified by three periods (…).
 
 eg: static vaTest(int ... n)
 
This syntax tells the compiler that 'vaTest( )' can be called with zero or more arguments. As a result, 'v' is implicitly declared as an array of type int[ ]. Thus, inside vaTest( ), 'v' is accessed using the normal array syntax.
  
 The … syntax simply tells the compiler that a variable number of arguments will be used, and that these arguments will be stored in the array referred to by 'v'.
 
  *vaTest( ) is called with different numbers of arguments, "including no arguments at all". 
 
 A method can have “normal” parameters along with a variable-length parameter. However, the variable-length parameter must be the last parameter declared by the method.
 
 There must be only one varargs parameter.
 
 Varargs methods can be overloaded by methods with varargs and non varargs parameters.
 Overloading can be however error prone. Consider following:
 	Methods are vaTest(int …) & vaTest(boolean …), if you call vaTest() like this with no arguments 	at all, it will fit both methods and create compile error.
 	
 	static void vaTest(int ... v)
    static void vaTest(int n, int ... v)
    
    This also will create error
    
 This errorness is known as ambiguity
 
 */

public class VariableLengthArguements 
{
	public static void main(String[] args) 
	{
		vaTest(1,2,3,4,5);
		vaTest(11,22,33);
	}
	
	static void vaTest(int ... n)
	{
		System.out.println("Number of arguements is: "+n.length);
		
		for(int i: n)
		{
			System.out.println(i);
		}
	}
}
