/*

Refer: Durgasoft YouTube, Durgasoft PDF Notes

Functions are exactly same as predicates except that functions can return any type of result, not just
boolean like predicate.

Function interface is present in java.util.function package.
Functional interface contains only one method i.e., apply()

interface function(T,R) {
 public R apply(T t);
}

Here, 'T' is the parameter on which operations are to be performed, 'R' is the return type of data the
function will return.


Function chaining is also possible using 'andThen()' and 'compose()' methods.

1. f1.andThen(f2).apply(3);
2. f1.compose(f2).apply(3);

Difference btwn both is that in 1, first function 'f1' will be executed and its result will be passed on to
function 'f2' and in 2, first 'f2' will be executed and then its result will be passed on to 'f1' and result
will be obtained.

This chaining can go on and on, like, f1.andThen(f2).andThen(f3)....

*/

package lambda;

import java.util.function.Function;

class Student
{
	String sname, sgrade;
	int smarks;
	
	Student(String name, int marks)
	{
		sname = name;
		smarks = marks;
	}
}

public class Predefined_Functional_Interface_Function 
{
	public static void main(String[] args) 
	{
		Student[] s = {
				new Student("A", 20),
				new Student("B", 40),
				new Student("C", 60),
				new Student("D", 90)
		};
		
		Function<Student, String> getGrade = (stud)->{
			String grade = ""; int m = stud.smarks;
			if(m >= 65) grade = "Distinction";
			else if(m>=50 && m<65) grade = "Second Class";
			else if(m>=35 && m<50) grade = "Pass";
			else if(m<35) grade = "Fail";
			
			return grade;
		};
		
		for(Student s1:s)
		{
			System.out.println("Name: "+s1.sname);
			System.out.println("Marks: "+s1.smarks);
			System.out.println("Grade: "+getGrade.apply(s1));
			System.out.println();
		}
	}

}
