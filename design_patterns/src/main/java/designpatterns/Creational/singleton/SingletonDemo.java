package designpatterns.Creational.singleton;

public class SingletonDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		//extracted();
		extraced_2();
	}

	private static void extraced_2() throws CloneNotSupportedException {
		FullySingleton fl=FullySingleton.getInstance();
		FullySingleton fl2=fl.clone();
		System.out.println(fl.hashCode()+"  "+fl2.hashCode());
		
		
	}

	private static void extracted() {
		Car c1 = Car.getCarInstance();
		Car c2 = Car.getCarInstance();
		System.out.println(c1.hashCode() + "  " + c2.hashCode());

		for (int j = 0; j < 10; j++) {
			Runnable thread = new Runnable() {
				@Override
				public void run() {
					Car c3 = Car.getCarInstance();
					System.out.println(c3.hashCode());
				}
			};

			Runnable rt = () -> {
				Car c3 = Car.getCarInstance();
				System.out.println(c3.hashCode());
			};
			Thread thr=new Thread(rt);
			thr.start();
		}
	}
}
