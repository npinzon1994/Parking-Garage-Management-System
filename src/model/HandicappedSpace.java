package model;

import java.io.Serializable;

public class HandicappedSpace extends ParkingSpace implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;
	
	public HandicappedSpace(Vehicle vehicle, int level) {
		super(vehicle, level);

	}

	@Override
	public String toString() {
		return "HandicappedSpace []";
	}

}
