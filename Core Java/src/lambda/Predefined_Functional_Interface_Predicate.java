/*

Refer: Durgasoft YouTube, Complete reference 11 book, Durgasoft Notes pdf's

A predicate is a function with a single argument and returns boolean value.
Predicate interface present in java.util.function package.
It’s a functional interface and it contains only one method i.e., test()


*/

package lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

class Employee
{
	String employee_name;
	double employee_salary;
	
	Employee(String ename, double esal)
	{
		employee_name = ename;
		employee_salary = esal;
	}
	
	public String toString()//This method is defined by 'Object', the father of all, it by default prints
	//something irrelevant for objects of this type, so we override it return our desired String which is
	//printed. Whenever an object is put for printing, its 'toString()' is automatically called.
	{
		return employee_name+":"+employee_salary;
	}
}

public class Predefined_Functional_Interface_Predicate 
{
	public static void main(String[] args) 
	{
		//ArrayList of employee objects
		ArrayList<Employee> l = new ArrayList<Employee>();
		l.add(new Employee("A", 1000));
		l.add(new Employee("B", 2000));
		l.add(new Employee("C", 3000));
		l.add(new Employee("D", 4000));
		l.add(new Employee("E", 5000));
		
		//Print employee details with salary greater than 2000
		Predicate<Employee> p = (emp)-> emp.employee_salary > 2000;
		
		for(Employee e: l)
			if(p.test(e))//test is the abstract method of predicate that is called and it returns booolean value
				System.out.println(e);
	}
	
	
}
