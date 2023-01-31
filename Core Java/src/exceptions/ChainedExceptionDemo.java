/*
 
 Refer: Complete Reference 11 Book
 
The chained exception feature allows you to associate another exception with an exception. 
This second exception describes the cause of the first exception
 
 */

package exceptions;

public class ChainedExceptionDemo 
{
	static void demoProc()
	{
		NullPointerException exception = new NullPointerException("Top Layer");
		
		exception.initCause(new ArithmeticException("Cause"));
		
		throw exception;
	}
	
	public static void main(String[] args) 
	{
			try {demoProc();}
			catch (NullPointerException e) {
				System.out.println("\nCaught: "+e);
				
				System.out.println("Orignal Cause: "+e.getCause());
			}
	}
}
