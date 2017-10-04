package model;

public abstract class ParkingSpace {

	private static int idInt = 1;

	private String id;
	private boolean status;
	private Vehicle vehicle;

	public ParkingSpace(Vehicle vehicle) {
		super();
		this.id = String.valueOf(idInt);
		this.vehicle = vehicle;
		if (vehicle == null) {
			this.status = true; //spot is empty
		} else {
			this.status = false; //spot is taken
		}
		idInt++;
	}

	public static int getIdInt() {
		return idInt;
	}

	public String getId() {
		return id;
	}

	public boolean isEmpty() {
		return status = true;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void setVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
	}
	
	public Vehicle getVehicle(){
		return this.vehicle;
	}
	
	public void removeVehicle(Vehicle vehicle){
		this.vehicle = null;
	}

	@Override
	public String toString() {
		return "ParkingSpace [id=" + id + ", status=" + status + "]";
	}

}
