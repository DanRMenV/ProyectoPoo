package data;

public class Car extends Vehicle{

	@Override
	public int getPrice(int minutes) {
		return minutes*60*90;		
	}
	
	
}
