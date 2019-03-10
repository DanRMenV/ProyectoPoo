package business;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;


import data.Vehicle;

public class ParkingManager {
	
	private TreeMap<Vehicle,LocalDate> vehicles;
	
	public TreeMap<Vehicle, LocalDate> getVehicles() {
		return vehicles;
	}

	public void setVehicles(TreeMap<Vehicle, LocalDate> vehicles) {
		this.vehicles = vehicles;
	}

	public ParkingManager() {
		this.vehicles = new TreeMap<Vehicle, LocalDate>();
	}

	public void addVehicle(Vehicle v,LocalDate l) {
		this.vehicles.put(v,l);
	}
		
	public void deleteVehicle(String placa) {
		Vehicle v = this.searchVehicle(placa);
		if (v!=null)
		this.vehicles.remove(v);
	}

	public Vehicle searchVehicle(String placa) {
		for(Map.Entry<Vehicle,LocalDate> entry : vehicles.entrySet()) {
		Vehicle key = entry.getKey(); 
		if(key.getPlaca().equals(placa)) {
			return key;
		}	
		}
		return null;
	}
	
	
	
}
