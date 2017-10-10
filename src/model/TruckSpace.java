package model;

import java.io.Serializable;

public class TruckSpace extends RegularSpace implements Serializable {

	private static final long serialVersionUID = -5243411708594528988L;

	public TruckSpace(Vehicle vehicle, int level) {
		super(vehicle, level);
		if ((1 < getIdInt()) && (getIdInt() < 50)){
			level = 1;
		} else if((50 < getIdInt()) && (getIdInt() < 100)){
			level = 2;
		} else if((100 < getIdInt()) && (getIdInt() < 150)){
			level = 3;
		}
		setSpaceType("Truck");
	}

	@Override
	public String toString() {
		return "TruckSpace []";
	}
	

}
