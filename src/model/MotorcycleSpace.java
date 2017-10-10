package model;

import java.io.Serializable;

public class MotorcycleSpace extends RegularSpace implements Serializable {

	private static final long serialVersionUID = -179884690838979763L;

	public MotorcycleSpace(Vehicle vehicle, int level) {
		super(vehicle, level);
		if ((1 < getIdInt()) && (getIdInt() < 25)){
			level = 1;
		} else if((25 < getIdInt()) && (getIdInt() < 50)){
			level = 2;
		} else if((50 < getIdInt()) && (getIdInt() < 75)){
			level = 3;
		}
		setSpaceType("Motorcycle");
	}

	@Override
	public String toString() {
		return "MotorcycleSpace []";
	}
	
	
}
