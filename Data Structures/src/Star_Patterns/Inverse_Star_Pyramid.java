package Star_Patterns;

public class Inverse_Star_Pyramid 
{
	public static void main(String[] args) 
	{
		int var = 10;
		int a=1;
		
		for(int i=var;i>=0;i-=2)
		{
			for(int k=0;k<=a;k++)
				System.out.print(" ");
			a++;
			
			for(int j=0;j<=i;j++)
				System.out.print("*");
			
			System.out.println("");
		}
	}
}