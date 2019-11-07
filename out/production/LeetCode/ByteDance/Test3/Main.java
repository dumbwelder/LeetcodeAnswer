// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Main.java

package ByteDance.Test3;

import java.io.PrintStream;
import java.util.*;

public class Main
{

	public Main()
	{
	}

	public static void main(String args[])
	{
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		Iterator ite = list.iterator();
		do
		{
			if (!ite.hasNext())
				break;
			String item = (String)ite.next();
			if ("2".equals(item))
				list.remove(item);
		} while (true);
		System.out.println(list);
	}
}
