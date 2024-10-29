package com.learn.corejava.Coll;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class SortedMap {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		TreeMap<String,String> sortedMap = new TreeMap<String,String>();

		sortedMap.put("a", "one");
		sortedMap.put("b", "two");
		sortedMap.put("c", "three");
		Iterator<String> iterator = sortedMap.keySet().iterator();

		while(iterator.hasNext()) {
		    String key   = (String) iterator.next();

		    String value = (String) sortedMap.get(key);
		    System.out.println("Key "+key+"  "+value);
		}
		
		String x=null;
		//System.out.println(x.equals("yy"));
		System.out.println("yy".equals(x));
		Comparator<String> comp=(e,b)->e.compareTo(b);
		
		int [] intAry=new int[] {0,1,1,0,1};
		Arrays.sort(intAry);
		//System.out.println(Arrays.toString(intAry));
		
		
	}
}
