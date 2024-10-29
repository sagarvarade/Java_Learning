package com.learn.corejava.Coll;

import java.util.HashMap;

public class HashMapTest {
	public static void main(String[] args) {
		Std s1 = new Std(1, "A", "aa");
		Std s2 = new Std(2, "B", "bb");
		Std s3 = new Std(1, "A", "aa");

		System.out.println("s1  : " + s1 + "  " + s1.hashCode());
		System.out.println("s2  : " + s2 + "  " + s2.hashCode());
		System.out.println("s3  : " + s3 + "  " + s3.hashCode());
		HashMap<Std, String> map = new HashMap<Std, String>();
		map.put(s1, "11");
		map.put(s2, "22");
		map.put(s3, "33");
		System.out.println(map.entrySet());
		System.out.println("s1 "+s1.hashCode()+"  "+s3.hashCode());
		System.out.println(s1.equals(s3));

	}
}
