/*

Refer: Complete Reference 11 Book

We will open a file with try and it will close automatically when try block ends, we don't need to
close it explicitly. After the try block ends, it will be closed automatically.

*/

import java.io.*;

public class Try_With_Resources {

	public static void main(String[] args) {

		try(FileInputStream fInputStream = new FileInputStream("D:\\Study\\Java\\Programs\\Core Java\\src\\MyFile.txt"))
		//Note that fInputStream is final and cannot be changed.
		//t beginning with JDK 10, you can use local variable type inference to specify the type of the resource
		//declared in a try-with-resources statement.
		//You can manage more than one resource within a single try statement. To
		//do so, simply separate each resource specification with a semicolon.
		{
			int i;
			do
			{
				i = fInputStream.read();
				if(i!=-1)
					System.out.print((char)i);
			}while(i != -1);
		}
		catch(IOException e) {System.out.println(e);}
	}
}
