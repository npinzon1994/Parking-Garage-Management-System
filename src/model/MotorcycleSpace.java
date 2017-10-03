package model;

public class MotorcycleSpace extends RegularSpace {

	private HourlyRate earlyBirdRate;
	private HourlyRate regularRate;

	public MotorcycleSpace(Vehicle vehicle) {
		super(vehicle);
		earlyBirdRate = new EarlyBirdRate();
		regularRate = new RegularRate();
	}

	@Override
	public String toString() {
		return "MotorcycleSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + ", toString()="
				+ super.toString() + ", getId()=" + getId() + ", isStatus()=" + isStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
