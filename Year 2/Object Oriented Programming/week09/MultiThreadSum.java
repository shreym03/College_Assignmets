import java.util.*;
class SumtoN implements Runnable 
{
	int start,end,sum;
	public SumtoN(int s,int e)
	{
		this.start=s;
		this.end=e;
	}
	public int getSum()
	{
		return sum;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}


public class MultiThreadSum
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n,d;
		int fsum=0;
		System.out.println("Enter end number");
		n=sc.nextInt();
		System.out.println("Enter the number of Threads");
		d=sc.nextInt();
		int inr= n/d;
		int i=1;
		int flag=0;
		while (flag<d)
		{
			Runnable r1=new SumtoN(i,i+inr);
			Thread t1= new Thread(r1);
			try
			{
				t1.start();
				t1.join();
			}
			catch(InterruptedException e)
			{
				System.out.println("Error generated");
				SumtoN s1=(SumtoN)r1;
				flag++;
				i+=inr;
			}
			System.out.println("The final sum is"+fsum);
		}
		sc.close();
	}
}
