package business;

import java.util.TreeSet;

import data.Vehicle;

public class ParkingManager {
	
	private TreeSet<Vehicle> vehicles;
	
	public TreeSet<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(TreeSet<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	
	public ParkingManager() {
		this.vehicles = new TreeSet<Vehicle>();
	}

	public void addVehicle(Vehicle v) {
		this.vehicles.add(v);
	}
		
	public void deleteVehicle(String id) {
		Vehicle v = this.searchVehicle(id);
		if (v!=null)
		this.vehicles.remove(v);
	}

	public Vehicle searchVehicle(String placa) {
		for (Vehicle v : vehicles) {
			if (v.getPlaca().equals(placa))
				return v;
		}
		return null;
	}
	
	
	
}
