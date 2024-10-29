package com.learn.corejava.Coll;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class CompareTest {
	public static void main(String[] args) {
        LinkedHashSet<Test> linkedHashSet = new LinkedHashSet<>();
        Test<String> t1=new Test();
        t1.setNum(100);
        
        Test<String> t2=new Test();
        t2.setNum(1001);
        System.out.println(t1.hashCode()+"     "+t2.hashCode());
        
        linkedHashSet.add(t1);
        linkedHashSet.add(t2);
        System.out.println(linkedHashSet);
        linkedHashSet.stream().forEach(e->System.out.println(e.getNum()));;
	}
}

class Test<T> implements Comparable<T>,Comparator<T> {

	private int num;

	@Override
	public int compareTo(T o) {
		if (this.hashCode() == o.hashCode())
			return 0;
		else if (this.hashCode() > o.hashCode())
			return 1;
		else if (this.hashCode() < o.hashCode())
			return -1;
		return -1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		return num == other.num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public int compare(T o1, T o2) {
		if (o1.hashCode() == o2.hashCode())
			return 0;
		else if (o1.hashCode() > o2.hashCode())
			return 1;
		else if (o1.hashCode() < o2.hashCode())
			return -1;
		return -1;
	}

}