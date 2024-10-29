package com.learn.corejava.Coll;

public class CarTest {
	public static void main(String[] args) {
		Nexon nx = new Nexon();
		nx.setColor("red");
		nx.setLength(3);
		System.out.println(nx);

		Slavia slv = new Slavia();
		slv.setColor("Black");
		slv.setLength(6);
		System.out.println(slv);
	}
}

class Car {
	protected String color;
	protected int length;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}

class Nexon extends Car {

	@Override
	public String toString() {
		return "Nexon [color=" + color + ", length=" + length + "]";
	}

}

class Slavia extends Car {

	@Override
	public String toString() {
		return "Slavia [color=" + color + ", length=" + length + "]";
	}

}
