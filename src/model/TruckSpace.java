package model;

public class TruckSpace extends RegularSpace {

	private HourlyRate earlyBirdRate;
	private HourlyRate regularRate;

	public TruckSpace(Vehicle vehicle) {
		super(vehicle);
		earlyBirdRate = new EarlyBirdRate();
		regularRate = new RegularRate();
	}

	@Override
	public String toString() {
		return "TruckSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}
