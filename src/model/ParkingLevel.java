package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingLevel implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;
	private int id;

	private Map<String, ParkingSpace> motorcycleLot;
	private ParkingSpace[] motorcycleSpaces;

	private Map<String, ParkingSpace> compactLot;
	private ParkingSpace[] compactSpaces;

	private Map<String, ParkingSpace> midSizeLot;
	private ParkingSpace[] midSizeSpaces;

	private Map<String, ParkingSpace> truckLot;
	private ParkingSpace[] truckSpaces;

	public ParkingLevel(int id) {
		this.id = id;
		motorcycleLot = new HashMap<String, ParkingSpace>();
		motorcycleSpaces = new MotorcycleSpace[10];
		for (int i = 0; i < motorcycleSpaces.length; i++) {
			motorcycleSpaces[i] = new MotorcycleSpace(null, id);
			motorcycleLot.put(motorcycleSpaces[i].getId(), motorcycleSpaces[i]);

		}

		compactLot = new HashMap<String, ParkingSpace>();
		compactSpaces = new CompactSpace[15];
		for (int i = 0; i < compactSpaces.length; i++) {
			compactSpaces[i] = new CompactSpace(null, id);
			compactSpaces[i].setSpaceType("Compact");
			compactLot.put(compactSpaces[i].getId(), compactSpaces[i]);

		}

		midSizeLot = new HashMap<String, ParkingSpace>();
		midSizeSpaces = new MidSizeSpace[15];
		for (int i = 0; i < midSizeSpaces.length; i++) {
			midSizeSpaces[i] = new MidSizeSpace(null, id);
			midSizeSpaces[i].setSpaceType("Mid Size");
			midSizeLot.put(midSizeSpaces[i].getId(), midSizeSpaces[i]);

		}

		truckLot = new HashMap<String, ParkingSpace>();
		truckSpaces = new TruckSpace[15];
		for (int i = 0; i < truckSpaces.length; i++) {
			truckSpaces[i] = new TruckSpace(null, id);
			truckSpaces[i].setSpaceType("Truck");
			truckLot.put(truckSpaces[i].getId(), truckSpaces[i]);

		}

	}

	public ParkingSpace[] getMotorcycleSpaces() {
		return motorcycleSpaces;
	}

	public ParkingSpace[] getCompactSpace() {
		return compactSpaces;
	}

	public ParkingSpace[] getMidSizeSpace() {
		return midSizeSpaces;
	}

	public ParkingSpace[] getTruckSpace() {
		return truckSpaces;
	}

	public Map<String, ParkingSpace> getMotorcycleLot() {
		return motorcycleLot;
	}

	public Map<String, ParkingSpace> getCompactLot() {
		return compactLot;
	}

	public Map<String, ParkingSpace> getMidSizeLot() {
		return midSizeLot;
	}

	public Map<String, ParkingSpace> getTruckLot() {
		return truckLot;
	}

	

	public boolean motorcyclesFull() {
		int count = 0;
		for (ParkingSpace space : motorcycleLot.values()) {
			if (space.getVehicle() != null) {
				count++;
			}
		}
		return count == 10;
		
	}

	public boolean compactsFull() {
		int count = 0;
		for (ParkingSpace space : compactLot.values()) {
			if (space.getVehicle() != null) {
				count++;
			}
		}
		return count == 15;
	}

	public boolean midSizesFull() {
		int count = 0;
		for (ParkingSpace space : midSizeLot.values()) {
			if (space.getVehicle() != null) {
				count++;
			}
		}
		return count == 15;
	}

	public boolean trucksFull() {
		int count = 0;
		for (ParkingSpace space : truckLot.values()) {
			if (space.getVehicle() != null) {
				count++;
			}
		}
		return count == 15;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ParkingLevel [motorcycleLot=" + motorcycleLot + ", motorcycleSpaces="
				+ Arrays.toString(motorcycleSpaces) + ", compactLot=" + compactLot + ", compactSpaces="
				+ Arrays.toString(compactSpaces) + ", midSizeLot=" + midSizeLot + ", midSizeSpaces="
				+ Arrays.toString(midSizeSpaces) + ", truckLot=" + truckLot + ", truckSpaces="
				+ Arrays.toString(truckSpaces) + "]";
	}

}
