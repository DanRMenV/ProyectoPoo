package data;

public class Car extends Vehicle{

	public Car(String marca, String placa) {
		super(marca, placa);
	}

	
	
	@Override
	public int getPrice(int seconds) {
		return seconds*90;		
	}
	
	@Override
	public String getNameClass() {
		return "Carro";
	}
	
}
