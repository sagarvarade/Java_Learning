package designpatterns.Creational.Builder;

public class BuilderDemo {
	public static void main(String[] args) {
		CarBuilder cb = new CarBuilder().setCarModel("2014").setCarName("Alto");
		System.out.println(cb.toString());

		CarBuilder2 cb2 = CarBuilder2.Builder.newInstance().setCarModel("2000").build();
		System.out.println(cb2.toString());
	}
}
