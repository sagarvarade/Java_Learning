package designpatterns.Creational.Factory;

interface Shape {
	public void display();
}

class Rectangle implements Shape {

	@Override
	public void display() {
		System.out.println("Recatangle Dispalay");
	}

}

class Circle implements Shape {
	@Override
	public void display() {
		System.out.println("Circle Dispalay");
	}
}

interface Factory {
	Shape factoryMethod();
}

class RectangleFactory implements Factory {

	@Override
	public Shape factoryMethod() {
		return new Rectangle();
	}

}

class CircleFactory implements Factory {

	@Override
	public Shape factoryMethod() {
		return new Circle();
	}

}

public class FactoryDemo {
	public static void main(String[] args) {
		Factory fc = new RectangleFactory();
		Shape rect = fc.factoryMethod();
		rect.display();

		Factory cr = new CircleFactory();
		Shape circ = cr.factoryMethod();
		circ.display();
	}
}
