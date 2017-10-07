package model;

import java.io.Serializable;

public abstract class ParkingSpace implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;	
	private static int idInt = 1;

	private String id;
	private Vehicle vehicle;

	public ParkingSpace(Vehicle vehicle) {
		this.id = String.valueOf(idInt);
		this.vehicle = vehicle;
		idInt++;
	}

	public static int getIdInt() {
		return idInt;
	}
	
	public static void setIdInt(int idCount){
		idInt = idCount;
	}

	public String getId() {
		return id;
	}

	public boolean hasVehicle() {
		if (vehicle != null) {
			return true;
		}
		return false;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void removeVehicle(Vehicle vehicle) {
		this.vehicle = null;
	}

	
	public boolean contains(Vehicle vehicle){
		if(vehicle == this.vehicle){
			return true;
		}
		return false;
	}
	

	@Override
	public String toString() {
		return "ParkingSpace [id=" + "id]";
	}

}
