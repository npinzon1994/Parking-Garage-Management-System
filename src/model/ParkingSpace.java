package model;

import java.io.Serializable;

public abstract class ParkingSpace implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;	
	private static int idInt = 1;

	private String id;
	private Vehicle vehicle;
	private String spaceType;
	private int level;

	public ParkingSpace(Vehicle vehicle, int levelId) {
		this.id = String.valueOf(idInt);
		this.vehicle = vehicle;
		this.level = levelId;
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

	public boolean hasVehicle(Vehicle vehicle) {
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
		vehicle = null;
		this.vehicle = vehicle;
	}

	
	public boolean contains(Vehicle vehicle){
		if(vehicle == this.vehicle){
			return true;
		}
		return false;
	}
	
	public String getSpaceType(){
		return spaceType;
	}
	
	public void setSpaceType(String type){
		this.spaceType = type;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int level){
		this.level = level;
	}

	@Override
	public String toString() {
		return "ParkingSpace [id=" + "id]";
	}

}
