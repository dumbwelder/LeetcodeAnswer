// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Main.java

package test;

import java.io.PrintStream;

public class Main
{
	public static class MyThread
		implements Runnable
	{

		public int a;

		public void run()
		{
			a++;
			try
			{
				Thread.sleep(1000L);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		public MyThread()
		{
			a = 0;
		}
	}


	final int i = 0;

	public Main()
	{
	}

	public static void main(String args[])
		throws InterruptedException
	{
		MyThread runnable = new MyThread();
		for (int i = 0; i < 500; i++)
			(new Thread(runnable)).start();

		Thread.sleep(1000L);
		System.out.println(runnable.a);
	}
}
