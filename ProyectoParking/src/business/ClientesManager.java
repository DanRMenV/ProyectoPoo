package business;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;

import data.Cliente_Parking;

public class ClientesManager {
	private TreeSet<Cliente_Parking> clientes;
	private final String filePath = "clientes";

	public TreeSet<Cliente_Parking> getClientes() {
		return clientes;
	}

	public void setClientes(TreeSet<Cliente_Parking> clientes) {
		this.clientes = clientes;
	}

	public ClientesManager(TreeSet<Cliente_Parking> clientes) {
		this.clientes = clientes;
	}	
	public ClientesManager() {
		this.clientes=new TreeSet<Cliente_Parking>();
	}
		
	public void addCliente(Cliente_Parking c) {
		this.clientes.add(c);
	}
	
	public void saveContacts() {
		try {
			FileOutputStream fileOut =
					new FileOutputStream(this.filePath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(this.clientes);
			System.out.println(this.clientes.size() + " contacts saved");
			objectOut.close();
		}
		catch (IOException e) {
			System.out.println("Unable to save the contacts");
		}
	}

	public void loadContacts() {
		System.out.println("loading contacts");
		try {
			final FileInputStream fileIn =
					new FileInputStream(this.filePath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			this.clientes = (TreeSet<Cliente_Parking>) objectIn.readObject();
			System.out.println(this.clientes.size() + " contacts retrieved");
			objectIn.close();
		}
		catch (IOException e) {
			System.out.println(this.clientes.size() + " contacts retrieved");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
}
