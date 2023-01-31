/*
 
 In earlier versions of java, StringBuffer didn't implement Comparable, but from jdk 11 it has 
 implemented it. 
 
 */

package practice;

import java.util.TreeSet;
import java.util.Comparator;

public class TreeSet_String_Sort 
{
	public static void main(String[] args) 
	{
		TreeSet<StringBuffer> t = new TreeSet<StringBuffer>(new myComparator());
		
		t.add(new StringBuffer("Wilfred"));
		t.add(new StringBuffer("Joy"));
		t.add(new StringBuffer("Flavin"));
		t.add(new StringBuffer("Aaron"));
		
		System.out.println(t);
	}
}

class myComparator implements Comparator<StringBuffer>
{
	public int compare(StringBuffer s1, StringBuffer s2)
	{	
		return -s1.compareTo(s2);//Changing sign here will be ascending and descending sort
	}
}