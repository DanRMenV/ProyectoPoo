package data;

public class Cliente_Parking extends Persona{
	private int puntos;
	private String placa;
	
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos= this.puntos+ puntos;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Cliente_Parking(String cedula, String nombre, String apellido, int puntos, String placa) {
		super(cedula, nombre, apellido);
		this.puntos = puntos;
		this.placa = placa;
	}
	@Override
	public String toString() {
		return placa;
	}
	
	
}
