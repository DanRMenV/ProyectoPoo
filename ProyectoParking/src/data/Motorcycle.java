package data;

public class Motorcycle extends Vehicle {
	
	public Motorcycle(String marca, String placa) {
		super(marca, placa);
	}
	
	
	
	@Override
	public int getPrice(int minutes) {
		return minutes*60*50;		
	}
	
	@Override
	public String getNameClass() {
		return "Moto";
	}

}
