package practice;

import java.util.*;

public class Collections_Practice 
{
	public static void main(String[] args) 
	{
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(1);
		l.add(10);
		l.add(100);
		l.add(1000);
		
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.add(232);
		l2.add(90);
		
		l.addAll(3,l2);
		System.out.println(l);
	}
}
