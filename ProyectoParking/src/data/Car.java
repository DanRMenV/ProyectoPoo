package data;

public class Car extends Vehicle{

	public Car(String marca, String placa) {
		super(marca, placa);
	}

	
	
	@Override
	public int getPrice(int minutes) {
		return minutes*60*90;		
	}
	
	@Override
	public String getNameClass() {
		return "Carro";
	}
	
}
