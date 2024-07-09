package com.learn.corejava;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HelloWorld {
	public static void main(String[] args) {
		//checkForPalindorme();
		//checkDigitCountInString(List.of("a","b","c","d","a","b"));
		
		
	}

	private static void checkDigitCountInString(List<String> list) {
		Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		System.out.println(collect);
		
		Map<String,Integer> count=new HashMap<String,Integer>();
		list.forEach(e->{
			if(count.containsKey(e)) {
				int cnt=count.get(e)+1;
				count.put(e,cnt);
			}
			else {
				count.put(e,1);
			}
		});
		System.out.println(count.toString());
		
	
	}

	private static void checkForPalindorme() {
		int x=343;
		int rev=reverseANumber(x);
		if(x==rev)
			System.out.println("Palin");
		else
			System.out.println("Not Palindrom");
	}

	private static int reverseANumber(int x) {
		int temp=0;
		while(x!=0) {
			int z=x%10;
			temp=temp*10+z;
			x=x/10;
		}
		System.out.println(temp);
		return temp;
	}
}
