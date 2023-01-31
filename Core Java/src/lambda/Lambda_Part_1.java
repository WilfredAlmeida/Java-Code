/*

Refer: Durgasoft YouTube->its best explained, Complete Reference 11 book

For lambda introductory notes, read 'Notes.txt' file

Here are some notes and an exapmle program. For starters, Lambdas can only defined with
functional interfaces(if's with only 1 method). Lambdas are the implementation on the abstract
method of the interface.

*/

package lambda;

@FunctionalInterface
interface MyInterface
{
	int add(int a, int b);
}

public class Lambda_Part_1 
{
	public static void main(String[] args) 
	{
		//Following is lambda implementation
		MyInterface m = (a,b) -> a+b;
		//It is accessed via interface reference, its the only way. '(a,b)' are parameters of the method.
		//Specifying their type is optional.
		//When only 1 parameter is there, '()' are optional but mandatory for 0 or 1+ parameters.
		// '->' is lambda operator. 'a+b' is method body. Here, if only statement is there, '{}' are optional.
		//if any value is to be returned, for a single statement, 'return' is also optional.
		
		//Here are some valid and invalid syntaxes: i is interface reference
		//i = n->n*n; //valid
		//(i) = n*n; //valid
		//(int n) = n*n; //valid
		//(int n, int a) = a*n; //valid
		//(int n, a) = a*n; //invalid
		//i = n-> return n*n; //invalid cuz without '{}' we cannot write 'return'
		//i = n-> {return n*n;}; //valid
		//i = n-> {return n*n;}; //invalid, notice ';' here
		//i = n-> {return n*n;} //invalid, notice ';' here
		//i = n-> {n*n;}; //invalid cuz in '{}' 'return' is compulsory
		//i = n-> {n*n}; //invalid
		
		System.out.println(m.add(1, 2));
		
	}
}
