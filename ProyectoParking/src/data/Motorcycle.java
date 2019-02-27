package data;

public class Motorcycle extends Vehicle {

	
	@Override
	public int getPrice(int minutes) {
		return minutes*60*50;		
	}
	
	

}
