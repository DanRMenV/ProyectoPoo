package business;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;


import data.Vehicle;

public class ParkingManager {
	
	private TreeMap<Vehicle,LocalDateTime> vehicles;
	
	public TreeMap<Vehicle, LocalDateTime> getVehicles() {
		return vehicles;
	}

	public void setVehicles(TreeMap<Vehicle, LocalDateTime> vehicles) {
		this.vehicles = vehicles;
	}

	public ParkingManager() {
		this.vehicles = new TreeMap<Vehicle, LocalDateTime>();
	}

	public void addVehicle(Vehicle v,LocalDateTime l) {
		this.vehicles.put(v,l);
	}
		
	public void deleteVehicle(String placa) {
		Vehicle v = this.searchVehicle(placa);
		if (v!=null)
		this.vehicles.remove(v);
	}

	public Vehicle searchVehicle(String placa) {
		for(Map.Entry<Vehicle,LocalDateTime> entry : vehicles.entrySet()) {
		Vehicle key = entry.getKey(); 
		if(key.getPlaca().equals(placa)) {
				return key;
			}	
		}
		return null;
	}


	@Override
	public String toString() {
		return "ContactManager [vehicles=" + vehicles + "]";
	}

	
	
	
		
	
}
