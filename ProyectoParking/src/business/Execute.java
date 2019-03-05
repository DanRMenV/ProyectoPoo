package business;

import gui.UISwing;

public class Execute {

	private static ParkingManager pmr;
	private static UISwing uiSwing;
	
	public static void main(String[] args) {
		pmr = new ParkingManager();
		uiSwing = new UISwing();
		uiSwing.showPanelMenu();

		
	}

}
