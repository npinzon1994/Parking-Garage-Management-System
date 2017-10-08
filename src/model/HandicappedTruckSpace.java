package model;

import java.io.Serializable;

public class HandicappedTruckSpace extends HandicappedSpace implements Serializable {
	private static final long serialVersionUID = 844618332991485586L;

	public HandicappedTruckSpace(Vehicle vehicle, int level) {
		super(vehicle, level);

	}

	@Override
	public String toString() {
		return "HandicappedTruckSpace []";
	}

}
