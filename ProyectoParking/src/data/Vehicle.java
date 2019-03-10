package data;

public class Vehicle implements Comparable<Vehicle>{
	private String marca;
	private String placa;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public int getPrice(int minutes) {
		return 0;
	}
	
	public Vehicle(String marca, String placa) {
		super();
		this.marca = marca;
		this.placa = placa;
	}
		
	public int compareTo(Vehicle other) {
		return this.placa.compareTo(other.placa);
	}
	
	@Override
	public String toString() {
		return "Vehicle [marca=" + marca + ", placa=" + placa+"]";
	}
	
	
	
	
	
}
