package model;

import java.io.Serializable;

public class CompactSpace extends RegularSpace implements Serializable {

	private static final long serialVersionUID = 3451305225730591755L;

	public CompactSpace(Vehicle vehicle, int level) {
		super(vehicle, level);
		if ((1 < getIdInt()) && (getIdInt() < 50)){
			level = 1;
		} else if((50 < getIdInt()) && (getIdInt() < 100)){
			level = 2;
		} else if((100 < getIdInt()) && (getIdInt() < 150)){
			level = 3;
		}
		setSpaceType("Compact");
	}

	@Override
	public String toString() {
		return "CompactSpace []";
	}

}
