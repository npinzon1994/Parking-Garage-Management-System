package model;

public class HandicappedTruckSpace extends HandicappedSpace {

	private HourlyRate earlyBirdRate;
	private HourlyRate regularRate;

	public HandicappedTruckSpace(Vehicle vehicle) {
		super(vehicle);
		earlyBirdRate = new EarlyBirdRate();
		regularRate = new RegularRate();
	}

	@Override
	public String toString() {
		return "HandicappedTruckSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}
