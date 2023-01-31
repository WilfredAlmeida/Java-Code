/*
 
 Refer: Java Apni Kaksha Videos
 
 */

package practice;

public class Reverse_String_Word_By_Word {

	public static void main(String[] args) 
	{
		
			String str = "  Hello   World  ", revString = "";
			
			int i = str.length() - 1;
			
			while(i>=0)
			{
				while(i >=0 && str.charAt(i) == ' ') i--;
				
				int j = i;
				
				while( i>=0 && str.charAt(i) != ' ') i--;
				
				if(revString.isEmpty())
					revString = revString.concat(str.substring(i+1, j+1));
				
				else
					revString = revString.concat(" " + str.substring(i+1, j+1));
			}
			
			System.out.println("\nOrignal String:\n"+str);
			System.out.println("\nReversed String:\n"+revString);

	}

}
