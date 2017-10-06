package model;

import java.io.Serializable;

public class Truck extends Vehicle implements Serializable {

	public Truck(String firstName, String lastName, String licensePlate) {
		super(firstName, lastName, licensePlate);
	}

}
