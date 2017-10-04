package model;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLevel {

	private HashMap<String, ParkingSpace> motorcycleLot;
	private ParkingSpace motorcycleSpace;

	private HashMap<String, ParkingSpace> compactLot;
	private ParkingSpace compactSpace;

	private HashMap<String, ParkingSpace> midSizeLot;
	private ParkingSpace midSizeSpace;

	private HashMap<String, ParkingSpace> truckLot;
	private ParkingSpace truckSpace;

	public ParkingLevel() {
		motorcycleLot = new HashMap<String, ParkingSpace>();
		motorcycleSpace = new MotorcycleSpace(null);
		for (int i = 0; i < 25; i++) {
			motorcycleLot.put(motorcycleSpace.getId(), motorcycleSpace);
		}

		compactLot = new HashMap<String, ParkingSpace>();
		compactSpace = new CompactSpace(null);
		for (int i = 0; i < 50; i++) {
			compactLot.put(compactSpace.getId(), compactSpace);
		}

		midSizeLot = new HashMap<String, ParkingSpace>();
		midSizeSpace = new MidSizeSpace(null);
		for (int i = 0; i < 50; i++) {
			midSizeLot.put(midSizeSpace.getId(), midSizeSpace);
		}

		truckLot = new HashMap<String, ParkingSpace>();
		truckSpace = new TruckSpace(null);
		for (int i = 0; i < 50; i++) {
			truckLot.put(truckSpace.getId(), truckSpace);
		}

	}
	
	public ParkingSpace getMotorcycleSpace(){
		return motorcycleSpace;
	}
	
	public ParkingSpace getCompactSpace(){
		return compactSpace;
	}
	
	public ParkingSpace getMidSizeSpace(){
		return midSizeSpace;
	}
	
	public ParkingSpace getTruckSpace(){
		return truckSpace;
	}
	
	public HashMap<String, ParkingSpace> getMotorcycleLot() {
		return motorcycleLot;
	}

	public HashMap<String, ParkingSpace> getCompactLot() {
		return compactLot;
	}

	public HashMap<String, ParkingSpace> getMidSizeLot() {
		return midSizeLot;
	}

	public HashMap<String, ParkingSpace> getTruckLot() {
		return truckLot;
	}
	
//	public ArrayList<ParkingSpace> getMotorcycleSpaces(HashMap<String, ParkingSpace> lot){
//		lot = ParkingStructure.getLevel1().getMotorcycleLot();
//		ArrayList<ParkingSpace> motorcycleSpaces = new ArrayList<ParkingSpace>();
//		
//			motorcycleSpaces.addAll(lot.keySet());
//			return motorcycleSpaces;
//	
//	}
	
	public boolean hasMotorcycle(){
		return motorcycleSpace.getVehicle()!=null;
	}
	
	public boolean hasCompact(){
		return compactSpace.getVehicle()!=null;
	}
	
	public boolean hasMidSize(){
		return midSizeSpace.getVehicle()!=null;
	}
	
	public boolean hasTruck(){
		return truckSpace.getVehicle()!=null;
	}

	@Override
	public String toString() {
		return "ParkingLevel [motorcycleLot=" + motorcycleLot + ", motorcycleSpace=" + motorcycleSpace + ", compactLot="
				+ compactLot + ", compactSpace=" + compactSpace + ", midSizeLot=" + midSizeLot + ", midSizeSpace="
				+ midSizeSpace + ", truckLot=" + truckLot + ", truckSpace=" + truckSpace + "]";
	}

}
