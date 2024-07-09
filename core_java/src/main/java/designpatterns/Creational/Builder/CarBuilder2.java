package designpatterns.Creational.Builder;

public class CarBuilder2 {

	private String carName;
	private String carModel;

	public CarBuilder2(Builder builder) {
		super();
		this.carName = builder.carName;
		this.carModel = builder.carModel;
	}

	public static class Builder {
		private String carName;
		private String carModel;

		public static Builder newInstance() {
			return new Builder();
		}

		private Builder() {
		}

		public Builder setCarName(String carName) {
			this.carName = carName;
			return this;
		}

		public Builder setCarModel(String carModel) {
			this.carModel = carModel;
			return this;
		}

		public CarBuilder2 build() {
			return new CarBuilder2(this);
		}
	}

	@Override
	public String toString() {
		return "CarBuilder2 [carName=" + carName + ", carModel=" + carModel + "]";
	}
	
}
