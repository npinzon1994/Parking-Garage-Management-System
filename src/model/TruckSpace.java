package model;

import java.io.Serializable;

public class TruckSpace extends RegularSpace implements Serializable {

	private static final long serialVersionUID = -5243411708594528988L;

	public TruckSpace(Vehicle vehicle, int level) {
		super(vehicle, level);
		setSpaceType("Truck");
	}

	@Override
	public String toString() {
		return "TruckSpace []";
	}
	

}
