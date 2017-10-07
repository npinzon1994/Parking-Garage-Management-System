package model;

import java.io.Serializable;

public class HandicappedMidSizeSpace extends HandicappedSpace implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;

	public HandicappedMidSizeSpace(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public String toString() {
		return "HandicappedMidSizeSpace []";
	}

}
