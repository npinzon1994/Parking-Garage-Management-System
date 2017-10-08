package model;

import java.io.Serializable;

public class HandicappedCompactSpace extends HandicappedSpace implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;

	public HandicappedCompactSpace(Vehicle vehicle, int level) {
		super(vehicle, level);

	}

	@Override
	public String toString() {
		return "HandicappedCompactSpace []";
	}

}
