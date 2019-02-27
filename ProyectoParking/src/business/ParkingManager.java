package business;

import data.Vehicle;

public class ParkingManager {
	
	Vehicle[] vehicles=new Vehicle[30];

	public Vehicle[] getVehicles() {
		return vehicles;
	}

	public void setVehicles(Vehicle[] vehicles) {
		this.vehicles = vehicles;
	}
	
	public void addVehicle(Vehicle v, int pos) {
		this.vehicles[pos]=v;
	}
	
	public void removeVehicle(Vehicle v, int pos) {
		this.vehicles[pos]=null;
	}	
	
}
