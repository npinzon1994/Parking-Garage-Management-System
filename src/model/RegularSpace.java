package model;

import java.io.Serializable;

public class RegularSpace extends ParkingSpace implements Serializable {

	private static final long serialVersionUID = 6814129886443050988L;	
	public RegularSpace(Vehicle vehicle, int level) {
		super(vehicle, level);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RegularSpace [getId()=" + getId() 
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	


}
