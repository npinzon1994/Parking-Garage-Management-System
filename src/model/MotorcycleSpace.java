package model;

public class MotorcycleSpace extends RegularSpace {

	private HourlyRate earlyBirdRate;
	private HourlyRate regularRate;

	public MotorcycleSpace(String size, Vehicle vehicle) {
		super(size, vehicle);
		earlyBirdRate = new EarlyBirdRate();
		regularRate = new RegularRate();
	}

	@Override
	public String toString() {
		return "MotorcycleSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}
