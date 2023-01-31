package multithreading;

class my extends Thread
{
	static Thread m;
	public void run()
	{
		System.out.println("Hi C");
		try {m.join();}
		catch(InterruptedException e) {}
		
		for(int i=0;i<5;i++)
		{
			System.out.println("Hi C");
		}
	}
}

public class deadlock 
{
	public static void main(String[] args) throws Exception{
		
		my.m = Thread.currentThread();
		
		my m1 = new my();
		m1.start();
		System.out.println("Hi M");
		
		m1.join();
		
		for(int i=0;i<5;i++)
		{
			System.out.println("Hi M");
		}
	}
}
