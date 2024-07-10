package designpatterns.Creational.Builder;

public class CarBuilder {

	private String carName;
	private String carModel;

	public String getCarName() {
		return carName;
	}

	public CarBuilder setCarName(String carName) {
		this.carName = carName;
		return this;
	}

	public String getCarModel() {
		return carModel;
	}

	public CarBuilder setCarModel(String carModel) {
		this.carModel = carModel;
		return this;
	}

	@Override
	public String toString() {
		return "CarBuilder [carName=" + carName + ", carModel=" + carModel + "]";
	}

}
