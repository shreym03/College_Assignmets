import java.io.*;
import java.lang.*;
import java.util.*;

class NoNegative extends Exception
{
	public NoNegative ()
	{
		System.out.println("No negative numbers please");
	}
}

class Thread implements Runnable
{
	public int[] arr;
	public int ele, start,stop;
	public static void display()
	{
		try
		{
			System.out.println("found");
		} catch(Exception e)
		{
			System.out.println("NULL");
		}
	}
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

class SearchThread
{
	
}
