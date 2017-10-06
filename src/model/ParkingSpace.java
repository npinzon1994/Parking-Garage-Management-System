package model;

import java.io.Serializable;

public abstract class ParkingSpace implements Serializable {

	private static int idInt = 1;

	private String id;
	private Vehicle vehicle;
	private long startTime;
	private long endTime;
	private double hoursParked;

	public ParkingSpace(Vehicle vehicle, long startTime, long endTime, double hoursParked) {
		this.id = String.valueOf(idInt);
		this.vehicle = vehicle;
		this.startTime = startTime;
		this.endTime = endTime;
		this.hoursParked = hoursParked;
		idInt++;
	}

	public static int getIdInt() {
		return idInt;
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

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public double getHoursParked() {
		return hoursParked;
	}

	public void setHoursParked(double hoursParked) {
		this.hoursParked = hoursParked;
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
