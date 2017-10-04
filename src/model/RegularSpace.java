package model;

public class RegularSpace extends ParkingSpace {

	public RegularSpace(Vehicle vehicle) {
		super(vehicle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RegularSpace [getId()=" + getId() 
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
