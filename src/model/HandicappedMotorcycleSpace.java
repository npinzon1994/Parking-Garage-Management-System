package model;

import java.io.Serializable;

public class HandicappedMotorcycleSpace extends HandicappedSpace implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;

	private HourlyRate earlyBirdRate;
	private HourlyRate regularRate;

	public HandicappedMotorcycleSpace(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public String toString() {
		return "HandicappedMotorcycleSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}
