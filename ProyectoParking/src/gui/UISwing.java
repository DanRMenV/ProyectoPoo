package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import business.ParkingManager;

public class UISwing extends JFrame{
	
	private JPanel mainPanel;
	private ParkingManager pm;
	
	public UISwing(ParkingManager pm) {
		this.pm=pm;
		this.setTitle("MyContacts");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200, 100);
		this.setResizable(false);
		this.mainPanel=new JPanel();
		this.mainPanel.setBorder(new EmptyBorder(10,10,10,10));
		this.mainPanel.setLayout(new CardLayout(0,0));
		this.setContentPane(mainPanel);
		//initComponents();
		this.setVisible(true);
	}
	
}
