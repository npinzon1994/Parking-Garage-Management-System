package model;

import java.io.Serializable;

public class CompactSpace extends RegularSpace implements Serializable {

	private static final long serialVersionUID = 3451305225730591755L;

	public CompactSpace(Vehicle vehicle, int level) {
		super(vehicle, level);
		setSpaceType("Compact");
	}

	@Override
	public String toString() {
		return "CompactSpace []";
	}

	
	
}
