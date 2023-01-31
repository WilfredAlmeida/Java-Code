package multithreading;

public class Interthread_Communication_Using_Wait_and_Notify {

	public static void main(String[] args) throws InterruptedException 
	{
		
		ThreadB b = new ThreadB();
		b.start();
		
		synchronized(b)
		{
			System.out.println("Main thread trying to call wait() method");
			
			b.wait();
			
			System.out.println("Main thread got notification");
			
			System.out.println(b.count);
		}

	}
}

class ThreadB extends Thread
{
	int count = 0;
	public void run()
	{
		synchronized(this)
		{
			System.out.println("Child thread starts calculation");
			
			for(int i=1;i<=100;i++)
				count = count+i;
			
			System.out.println("Child thread trying to give notification");
			
			this.notify();
		}
	}
}