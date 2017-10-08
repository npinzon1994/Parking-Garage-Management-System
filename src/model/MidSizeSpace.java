package model;

import java.io.Serializable;

public class MidSizeSpace extends RegularSpace implements Serializable {

	private static final long serialVersionUID = 8942370271694432459L;	

	public MidSizeSpace(Vehicle vehicle, int level) {
		super(vehicle, level);
		setSpaceType("Mid Size");
	
	}

	@Override
	public String toString() {
		return "MidSizeSpace []";
	}


}
