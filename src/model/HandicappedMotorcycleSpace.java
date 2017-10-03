package model;

public class HandicappedMotorcycleSpace extends HandicappedSpace {

	private HourlyRate earlyBirdRate;
	private HourlyRate regularRate;

	public HandicappedMotorcycleSpace(Vehicle vehicle) {
		super(vehicle);
		earlyBirdRate = new EarlyBirdRate();
		regularRate = new RegularRate();
	}

	@Override
	public String toString() {
		return "HandicappedMotorcycleSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}