package com.nishit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintDuplicatesFromStringwithoutDS {
	
	public static void main(String arg[])throws Exception
	{
	String res="";
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String a=br.readLine();
	while(a.length()>0)
	{
	int c=0;
	for(int j=0;j<a.length();j++)
	{
	if(a.charAt(0)==a.charAt(j))
	c=c+1;
	}
	res=res+a.charAt(0)+"="+c+"\n";
	String k[]=a.split(a.charAt(0)+"");
	a=new String("");
	for(int i=0;i<k.length;i++)
	a=a+k[i];
	}
	System.out.println(res);
	}
	

	
}
