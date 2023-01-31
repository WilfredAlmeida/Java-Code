package Star_Patterns;

public class Star_Pyramid 
{
	public static void main(String[] args) 
	{
		int var = 10;
		int a = 1;
		
		for(int j=1;j<var;j+=2)
		{
			
			for(int k=var;k>=a;k--)
				System.out.print(" ");
			a++;
			
			for(int i=0;i<j;i++)
			{
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}
}
 