package business;

import java.io.File;

import gui.UISwing;

public class Execute {

	private static ParkingManager pmr;
	private static ClientesManager cmr;
	private static UISwing uiSwing;
	
	public static void main(String[] args) {
		pmr = new ParkingManager();
		cmr = new ClientesManager(); 
		uiSwing = new UISwing(pmr,cmr);
		File tmpDir = new File("clientes");
		if(tmpDir.exists()) cmr.loadClients();
		uiSwing.showPanelMenu();

		
	}

}
