package model;

import java.io.Serializable;

public class MotorcycleSpace extends RegularSpace implements Serializable {

	private static final long serialVersionUID = -179884690838979763L;

	public MotorcycleSpace(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public String toString() {
		return "MotorcycleSpace []";
	}

}
