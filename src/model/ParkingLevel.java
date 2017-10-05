package model;

import java.util.Arrays;
import java.util.HashMap;

public class ParkingLevel {

	private HashMap<String, ParkingSpace> motorcycleLot;
	private ParkingSpace[] motorcycleSpaces;

	private HashMap<String, ParkingSpace> compactLot;
	private ParkingSpace[] compactSpaces;

	private HashMap<String, ParkingSpace> midSizeLot;
	private ParkingSpace[] midSizeSpaces;

	private HashMap<String, ParkingSpace> truckLot;
	private ParkingSpace[] truckSpaces;

	public ParkingLevel() {
		motorcycleLot = new HashMap<String, ParkingSpace>();
		motorcycleSpaces = new MotorcycleSpace[25];
		for (int i = 0; i < motorcycleSpaces.length; i++) {
			motorcycleSpaces[i] = new MotorcycleSpace(null, 0, 0, 0);
			motorcycleLot.put(motorcycleSpaces[i].getId(), motorcycleSpaces[i]);
		}

		compactLot = new HashMap<String, ParkingSpace>();
		compactSpaces = new CompactSpace[50];
		for (int i = 0; i < compactSpaces.length; i++) {
			compactSpaces[i] = new CompactSpace(null, 0, 0, 0);
			compactLot.put(compactSpaces[i].getId(), compactSpaces[i]);
		}

		midSizeLot = new HashMap<String, ParkingSpace>();
		midSizeSpaces = new MidSizeSpace[50];
		for (int i = 0; i < midSizeSpaces.length; i++) {
			midSizeSpaces[i] = new MidSizeSpace(null, 0, 0, 0);
			midSizeLot.put(midSizeSpaces[i].getId(), midSizeSpaces[i]);
		}

		truckLot = new HashMap<String, ParkingSpace>();
		truckSpaces = new TruckSpace[50];
		for (int i = 0; i < truckSpaces.length; i++) {
			truckSpaces[i] = new TruckSpace(null, 0, 0, 0);
			truckLot.put(truckSpaces[i].getId(), truckSpaces[i]);
		}

	}
	
	public ParkingSpace[] getMotorcycleSpaces(){
		return motorcycleSpaces;
	}
	
	public ParkingSpace[] getCompactSpace(){
		return compactSpaces;
	}
	
	public ParkingSpace[] getMidSizeSpace(){
		return midSizeSpaces;
	}
	
	public ParkingSpace[] getTruckSpace(){
		return truckSpaces;
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

	@Override
	public String toString() {
		return "ParkingLevel [motorcycleLot=" + motorcycleLot + ", motorcycleSpaces="
				+ Arrays.toString(motorcycleSpaces) + ", compactLot=" + compactLot + ", compactSpaces="
				+ Arrays.toString(compactSpaces) + ", midSizeLot=" + midSizeLot + ", midSizeSpaces="
				+ Arrays.toString(midSizeSpaces) + ", truckLot=" + truckLot + ", truckSpaces="
				+ Arrays.toString(truckSpaces) + "]";
	}
	
//	public ArrayList<ParkingSpace> getMotorcycleSpaces(HashMap<String, ParkingSpace> lot){
//		lot = ParkingStructure.getLevel1().getMotorcycleLot();
//		ArrayList<ParkingSpace> motorcycleSpaces = new ArrayList<ParkingSpace>();
//		
//			motorcycleSpaces.addAll(lot.keySet());
//			return motorcycleSpaces;
//	
//	}
	
//	public boolean hasMotorcycle(){
//		return motorcycleSpaces;
//	}
//	
//	public boolean hasCompact(){
//		return compactSpace.getVehicle()!=null;
//	}
//	
//	public boolean hasMidSize(){
//		return midSizeSpace.getVehicle()!=null;
//	}
//	
//	public boolean hasTruck(){
//		return truckSpace.getVehicle()!=null;
//	}

	

}
