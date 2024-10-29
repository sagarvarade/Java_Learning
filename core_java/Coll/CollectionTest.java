package com.learn.corejava.Coll;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.learn.corejava.DataProvider.Data;
@SuppressWarnings("unused")
public class CollectionTest {
	static Comparator<String> comparator = (String a, String b) -> {
		return a.compareTo(b);
	};

	static Comparator<Integer> intComapre = (Integer a, Integer b) -> {
		return a.compareTo(b);
	};

	public static void main(String[] args) {
		List<Integer> randomeNumbers = Data.getRandomeNumbers(10);
		List<String> randomeString = Data.getRandomSurName(10);
		System.out.println("Random Numbers : " + randomeNumbers);
		Collections.sort(randomeNumbers, intComapre);
		System.out.println("Random Numbers sorted : " + randomeNumbers);
		System.out.println("Random Strings : " + randomeString);
		Collections.sort(randomeString, comparator);
		System.out.println("Random Strings sorted : " + randomeString);

		Comparable<Integer> comparableString = (a) -> {
			return a.compareTo(10);
		};
	}
}
