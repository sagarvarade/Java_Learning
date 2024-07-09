package designpatterns.Creational.singleton;

public final class Car {
	public static Car car;

	private Car() {

	}

	public static Car getCarInstance() {
		if (car == null) {
			synchronized (Car.class) {
				car = new Car();
			}
		}
		return car;
	}

}
