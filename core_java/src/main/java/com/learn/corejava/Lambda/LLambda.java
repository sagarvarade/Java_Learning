package com.learn.corejava.Lambda;

public class LLambda {

	public static void main(String[] args) {
		
		String s3=new String("sagar");
		String s4=new String("sagar");
		
	
		String s1="sagar";
		String s2="sagar";
	//	s2="sagar"+"varade";
		
		
		System.out.println(s1.hashCode()+"   "+s2.hashCode());
		
		System.out.println(s3.hashCode()+"   "+s4.hashCode());
		
		
		StringBuilder strB=new StringBuilder("sagar");
		System.out.println(strB.hashCode());
	}
}
