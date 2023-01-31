import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/*
 
 Refer: Durgasoft YouTube, Complete Reference 11

 Creating and using custom annotations and getting annotations' data at runtime.
 Better read point 29 of Notes.txt
 
Java provides a feature that enables you to embed supplemental information
into a source file. This information, called an annotation, does not change the
actions of a program.

Annotation can be applied to anything in Java.
 
 */

//Annotation is defined using @interface annotation_name syntax.

@Retention(RetentionPolicy.RUNTIME)//Read point 29 of Notes.txt
@interface MyAnnotation
{
	String name() default "Wilfred";//Values an annotation has, Observe the syntax here,
	//'name' is a field here but has '()', "Wilfred" is the default value incase any
	//value is not specified.
	
	//They must always return a value of:
//	� A primitive type, such as int or double
//	� An object of type String or Class
//	� An object of an enum type
//	� An object of another annotation type
//	� An array of a legal type.

	
	int age() default 18;
}

//@SuppressWarnings("unchecked")
public class Custom_Annotations {

	public static void main(String[] args) {
		new anno();
		anno.myMeth();
	}
}

class anno
{
     	//Annotating a method, write @annotation_name and specify name=value pairs in
		//parenthesis.
		@MyAnnotation(name = "W", age = 20)
		public static void myMeth()
		{
			System.out.println("My Method");
			anno a = new anno();
	
		    //If a annotation has retention RUNTIME than its data can be accessed by JVM
		    //at runtime through the use of reflection.
		    //Reflection is the feature that enables information about a class to be obtained at
	    	//run time. The reflection API is contained in the java.lang.reflect package.
			
			try
			{
				//Get a 'Class' object that represents this class
				Class<?> c = a.getClass();
				
				//Get a 'Method' object that represents this method 'myMeth()'
				Method m = c.getMethod("myMeth");//If the method being specified here has parameters
				//then we need to specify 'datatype.class' here. For eg. if 'myMeth()' has 2 parameters
				//String s and int i then we would write c.getMethod("meMeth.class", String.class,int.class)
				//If method is not found, it throws "NoSuchMethodException"
				
				//Get the annotation for this class
				MyAnnotation ann = m.getAnnotation(MyAnnotation.class);
				
				//Display values
				System.out.println("\nName: "+ann.name()+"\nAge: "+ann.age());
			}
			catch(NoSuchMethodException e)
			{
				System.out.println(e);
			}
			
			
		}
}