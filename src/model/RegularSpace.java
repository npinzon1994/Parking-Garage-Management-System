package model;

public class RegularSpace extends ParkingSpace {

	public RegularSpace(Vehicle vehicle) {
		super(vehicle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RegularSpace [getId()=" + getId() + ", isStatus()=" + isStatus()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
