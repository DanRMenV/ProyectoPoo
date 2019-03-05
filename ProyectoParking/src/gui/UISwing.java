package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import business.ParkingManager;
import data.Car;
import data.Motorcycle;
import data.Vehicle;

public class UISwing extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JPanel panelMenu;
	/*private JPanel panelIngreso;
	private JPanel panelEstado;
	private JPanel panelPagos;
	private JPanel panelStats;
	private JPanel panelPrecios;
	private JPanel panelRegistro;
	private JPanel panelFacturas;*/
	
	
	private ParkingManager pm;
	
	public UISwing(ParkingManager pm) {
		this.pm=pm;
		this.setTitle("Parking Manager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,100);
		this.setResizable(false);
		this.mainPanel = new JPanel();
		this.mainPanel.setBorder(new EmptyBorder(10,10,10,10));
		this.mainPanel.setLayout(new CardLayout(0,0));
		this.setContentPane(mainPanel);
		initComponents();
		this.setVisible(true);
	}
	
	private void initComponents() {
		this.setupPanelMenu();
		/*this.setupPanelIngreso();
		this.setupPanelEstado();
		this.setupPanelPagos();
		this.setupPanelStats();
		this.setupPanelPrecios();
		this.setupPanelRegistro();
		this.setupPanelFactura();	*/
	}
	
	//Setup menu
	private void setupPanelMenu() {
		this.panelMenu = new JPanel();
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panelMenu.setLayout(gbl_contentPane);
		
		JLabel labelParking = new JLabel("Parking");
		labelParking.setFont(new Font("Bodoni MT", Font.PLAIN, 24));
		GridBagConstraints gbc_labelParking = new GridBagConstraints();
		gbc_labelParking.insets = new Insets(0, 0, 5, 5);
		gbc_labelParking.gridx = 5;
		gbc_labelParking.gridy = 0;
		this.panelMenu.add(labelParking, gbc_labelParking);
		
		JLabel lblHoraActual = new JLabel("Hora actual");
		lblHoraActual.setFont(new Font("Bodoni MT", Font.PLAIN, 12));
		GridBagConstraints gbc_lblHoraActual = new GridBagConstraints();
		gbc_lblHoraActual.insets = new Insets(0, 0, 5, 0);
		gbc_lblHoraActual.gridx = 9;
		gbc_lblHoraActual.gridy = 0;
		this.panelMenu.add(lblHoraActual, gbc_lblHoraActual);
		
		JButton btnIngreso = new JButton("Ingreso");
		GridBagConstraints gbc_btnIngreso = new GridBagConstraints();
		gbc_btnIngreso.insets = new Insets(0, 0, 5, 5);
		gbc_btnIngreso.gridx = 1;
		gbc_btnIngreso.gridy = 2;
		this.panelMenu.add(btnIngreso, gbc_btnIngreso);
		
		JButton btnEstado = new JButton("Estado");
		GridBagConstraints gbc_btnEstado = new GridBagConstraints();
		gbc_btnEstado.insets = new Insets(0, 0, 5, 5);
		gbc_btnEstado.gridx = 5;
		gbc_btnEstado.gridy = 2;
		this.panelMenu.add(btnEstado, gbc_btnEstado);
		
		JButton btnPagos = new JButton("Pagos");
		GridBagConstraints gbc_btnPagos = new GridBagConstraints();
		gbc_btnPagos.insets = new Insets(0, 0, 5, 0);
		gbc_btnPagos.gridx = 9;
		gbc_btnPagos.gridy = 2;
		this.panelMenu.add(btnPagos, gbc_btnPagos);
		
		JButton btnRegistroClienteFrecuente = new JButton("Registro Cliente Frecuente");
		GridBagConstraints gbc_btnRegistroClienteFrecuente = new GridBagConstraints();
		gbc_btnRegistroClienteFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistroClienteFrecuente.gridx = 5;
		gbc_btnRegistroClienteFrecuente.gridy = 5;
		this.panelMenu.add(btnRegistroClienteFrecuente, gbc_btnRegistroClienteFrecuente);
		
		JButton btnStats = new JButton("Stats");
		GridBagConstraints gbc_btnStats = new GridBagConstraints();
		gbc_btnStats.insets = new Insets(0, 0, 5, 5);
		gbc_btnStats.gridx = 1;
		gbc_btnStats.gridy = 6;
		this.panelMenu.add(btnStats, gbc_btnStats);
		
		JButton btnPrecios = new JButton("Precios");
		GridBagConstraints gbc_btnPrecios = new GridBagConstraints();
		gbc_btnPrecios.insets = new Insets(0, 0, 5, 0);
		gbc_btnPrecios.gridx = 9;
		gbc_btnPrecios.gridy = 6;
		this.panelMenu.add(btnPrecios, gbc_btnPrecios);
		
		JButton btnSalidaPrograma = new JButton("Salida Programa");
		GridBagConstraints gbc_btnSalidaPrograma = new GridBagConstraints();
		gbc_btnSalidaPrograma.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalidaPrograma.gridx = 5;
		gbc_btnSalidaPrograma.gridy = 7;
		this.panelMenu.add(btnSalidaPrograma, gbc_btnSalidaPrograma);	
	
	// Listeners
			btnIngreso.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					//showPanelIngreso();
				}
				});
			
			btnEstado.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					//selectContact(cmr.getIds());
				}
				});
			btnRegistroClienteFrecuente.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					//showPanelRegistro();
				}
				});
			btnPagos.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					//showPanelPagos();
				}
				});
			btnStats.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					//showPanelStats();
				}
				});
			btnPrecios.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					//showPanelPrecios();
				}
				});
			
			
			
			btnSalidaPrograma.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					System.exit(0);;
				}
				});
		}
	// Setup del panel Ingreso
	/*private void setupPanelIngreso() {
		this.panelIngreso = new JPanel();
		
		JLabel lblIngreso = new JLabel("Ingreso");
		lblIngreso.setFont(new Font("Bodoni MT", Font.PLAIN, 24));
		GridBagConstraints gbc_lblIngreso = new GridBagConstraints();
		gbc_lblIngreso.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreso.gridx = 6;
		gbc_lblIngreso.gridy = 0;
		this.panelIngreso.add(lblIngreso, gbc_lblIngreso);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPlaca = new GridBagConstraints();
		gbc_lblPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlaca.gridx = 2;
		gbc_lblPlaca.gridy = 2;
		this.panelIngreso.add(lblPlaca, gbc_lblPlaca);
		
		final JTextField txtPlaca = new JTextField();
		txtPlaca.setHorizontalAlignment(SwingConstants.LEFT);
		txtPlaca.setText("Ingrese el número de placa");
		GridBagConstraints gbc_txtPlaca = new GridBagConstraints();
		gbc_txtPlaca.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlaca.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlaca.gridx = 7;
		gbc_txtPlaca.gridy = 2;
		this.panelIngreso.add(txtPlaca, gbc_txtPlaca);
		txtPlaca.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 2;
		gbc_lblMarca.gridy = 4;
		this.panelIngreso.add(lblMarca, gbc_lblMarca);
		
		final JTextField txtMarca = new JTextField();
		txtMarca.setText("Ingrese la marca");
		GridBagConstraints gbc_txtMarca = new GridBagConstraints();
		gbc_txtMarca.insets = new Insets(0, 0, 5, 0);
		gbc_txtMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMarca.gridx = 7;
		gbc_txtMarca.gridy = 4;
		this.panelIngreso.add(txtMarca, gbc_txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblTipoVehculo = new JLabel("Tipo Vehículo");
		lblTipoVehculo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblTipoVehculo = new GridBagConstraints();
		gbc_lblTipoVehculo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoVehculo.gridx = 2;
		gbc_lblTipoVehculo.gridy = 5;
		this.panelIngreso.add(lblTipoVehculo, gbc_lblTipoVehculo);
		
		JComboBox comboBoxTipoV = new JComboBox();
		comboBoxTipoV.setToolTipText("");
		GridBagConstraints gbc_comboBoxTipoV = new GridBagConstraints();
		gbc_comboBoxTipoV.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxTipoV.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTipoV.gridx = 7;
		gbc_comboBoxTipoV.gridy = 5;
		this.panelIngreso.add(comboBoxTipoV, gbc_comboBoxTipoV);
		comboBoxTipoV.addItem("Moto");
		comboBoxTipoV.addItem("Carro");
		
		JButton btnIngresar = new JButton("Ingresar");
		GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
		gbc_btnIngresar.insets = new Insets(0, 0, 0, 5);
		gbc_btnIngresar.gridx = 6;
		gbc_btnIngresar.gridy = 8;
		this.panelIngreso.add(btnIngresar, gbc_btnIngresar);
		
		//Listeners
		btnIngresar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Vehicle v = new Vehicle(txtPlaca.getText(), txtMarca.getText());
				txtPlaca.setText("");
				txtMarca.setText("");
				remove(panelIngreso);
				//pm.addVehicle(v, 1);
			showPanelMenu();
			}
			
			});
		comboBoxTipoV.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				//???
				showPanelMenu();
			}
		});
	}*/
	
	/*private void setupPanelEstado() {
		this.panelEstado = new JPanel();
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 2;
		gbc_lblEstado.gridy = 0;
		this.panelEstado.add(lblEstado, gbc_lblEstado);
		
		String[] columnNames = {"# Parking",
                "Placa",
                "Tipo Vehículo",
                "Tiempo",
                "Hora Entrada"};
		
		final JTable table;
		//data?
		table = new JTable(null, columnNames);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 2;
		gbc_table.gridy = 2;
		this.panelEstado.add(table, gbc_table);
		
		
		JButton btnVolver = new JButton("Volver");
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolver.gridx = 2;
		gbc_btnVolver.gridy = 3;
		this.panelEstado.add(btnVolver, gbc_btnVolver);
		
		//listeners
		btnVolver.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				remove(panelEstado);
				showPanelMenu();
			}
			});	
	}*/
	
	public void showPanelMenu() {
		this.setSize(450, 200);
		this.add(this.panelMenu);
	}
	
	
	
}
