package gui;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Dimension2D;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import business.ParkingManager;
import data.*;

public class UISwing extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JPanel panelMenu;
	private JPanel panelIngreso;
	private JPanel panelEstado;
	private JPanel panelPagos;
	private JPanel panelStats;
	private JPanel panelPrecios;
	private JPanel panelRegistro;
	private JPanel panelFactura;
	private JPanel panelFacturaFrecuente;
	
	
	private ParkingManager pm;
	
	public UISwing(ParkingManager pm) {
		this.pm=pm;
		this.setTitle("Parking Manager");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,100);
		this.setResizable(true);
		this.mainPanel = new JPanel();
		this.mainPanel.setBorder(new EmptyBorder(10,10,10,10));
		this.mainPanel.setLayout(new CardLayout(0,0));
		this.setContentPane(mainPanel);
		initComponents();
		this.setVisible(true);
	}
	
	private void initComponents() {
		this.setupPanelMenu();
		this.setupPanelIngreso();
		this.setupPanelEstado();
		this.setupPanelPagos();
		this.setupPanelFactura();
		this.setupPanelFacturaFrecuente();
		this.setupPanelPrecios();
		this.setupPanelStats();
		this.setupPanelRegistro();
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
		
		LocalDateTime locaDate = LocalDateTime.now();
		int hours  = locaDate.getHour();
		int minutes = locaDate.getMinute();
		int seconds = locaDate.getSecond();
		
		JLabel lblHoraActual = new JLabel("Hora actual:"+ hours+":"+minutes+":"+seconds);
		
		lblHoraActual.setFont(new Font("Bodoni MT", Font.PLAIN, 12));
		GridBagConstraints gbc_lblHoraActual = new GridBagConstraints();
		gbc_lblHoraActual.insets = new Insets(0, 0, 5, 0);
		gbc_lblHoraActual.gridx = 9;
		gbc_lblHoraActual.gridy = 0;
		this.panelMenu.add(lblHoraActual, gbc_lblHoraActual);
		
		JButton btnIngreso = new JButton("Ingreso");
		GridBagConstraints gbc_btnIngreso = new GridBagConstraints();
		gbc_btnIngreso.insets = new Insets(0, 0, 0, 0);
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
					showPanelIngreso();
				}
				});
			
			btnEstado.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					//selectContact(cmr.getIds());
					//showPanelEstado();
					showCars(pm.getVehicles());
				}
				});
			btnRegistroClienteFrecuente.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					showPanelRegistro();
				}
				});
			btnPagos.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					//showPanelPagos();
					payCars(pm.getVehicles());
				}
				});
			btnStats.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					showPanelStats();
				}
				});
			btnPrecios.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					showPanelPrecios();
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
	private void setupPanelIngreso() {
		this.panelIngreso = new JPanel();
		GridBagLayout gbl_contentPaneIngreso = new GridBagLayout();
		gbl_contentPaneIngreso.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPaneIngreso.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPaneIngreso.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPaneIngreso.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panelIngreso.setLayout(gbl_contentPaneIngreso);
		
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
		
		
		String[] opc= {"Moto","Carro"};
		
		JComboBox<String> comboBoxTipoV = new JComboBox<String>(opc);
		comboBoxTipoV.setToolTipText("");
		GridBagConstraints gbc_comboBoxTipoV = new GridBagConstraints();
		gbc_comboBoxTipoV.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxTipoV.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTipoV.gridx = 7;
		gbc_comboBoxTipoV.gridy = 5;
		this.panelIngreso.add(comboBoxTipoV, gbc_comboBoxTipoV);
		/*comboBoxTipoV.addItem("Moto");
		comboBoxTipoV.addItem("Carro");*/
		
		JButton buttonBackIngreso = new JButton("<-");
		GridBagConstraints gbc_buttonBackIngreso = new GridBagConstraints();
		gbc_buttonBackIngreso.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBackIngreso.gridx = 0;
		gbc_buttonBackIngreso.gridy = 0;
		this.panelIngreso.add(buttonBackIngreso, gbc_buttonBackIngreso);
		
		JButton btnIngresar = new JButton("Ingresar");
		GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
		gbc_btnIngresar.insets = new Insets(0, 0, 0, 5);
		gbc_btnIngresar.gridx = 6;
		gbc_btnIngresar.gridy = 8;
		this.panelIngreso.add(btnIngresar, gbc_btnIngresar);
		
		//Listeners
		buttonBackIngreso.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				remove(panelIngreso);
				showPanelMenu();
				}
				});
		
		btnIngresar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				LocalDateTime l=LocalDateTime.now();
				String tipo=(String) comboBoxTipoV.getSelectedItem();
				if(tipo.equals("Moto")){
					Motorcycle m = new Motorcycle(txtPlaca.getText(), txtMarca.getText());
					pm.addVehicle(m,l);
				}else {
					Car c = new Car(txtPlaca.getText(), txtMarca.getText());
					pm.addVehicle(c,l);
				}	
				txtPlaca.setText("");
				txtMarca.setText("");	
				System.out.println(pm);
				remove(panelIngreso);
			showPanelMenu();
			}
		});	
		/*comboBoxTipoV.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				//???
				showPanelMenu();
			}
			
		});*/
	}
	
	private void setupPanelEstado() {
		this.panelEstado = new JPanel();
		GridBagLayout gridBagLayoutEstado = new GridBagLayout();
		gridBagLayoutEstado.columnWidths = new int[]{0, 30, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutEstado.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutEstado.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayoutEstado.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panelEstado.setLayout(gridBagLayoutEstado);
		
		//final JTable  tableEstado;
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 5;
		gbc_lblEstado.gridy = 1;
		this.panelEstado.add(lblEstado, gbc_lblEstado);
	
	}
	
	
	public void showCars(TreeMap<Vehicle, LocalDateTime> tabla) {
		final JTable  tableEstado;
		JScrollPane scrollPane = new JScrollPane();
		JButton buttonBackEstado = new JButton("<-");
		JLabel lblNoAuto = new JLabel("No hay autos");
		
		GridBagConstraints gbc_buttonBackEstado = new GridBagConstraints();
		gbc_buttonBackEstado.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBackEstado.gridx = 0;
		gbc_buttonBackEstado.gridy = 0;
		this.panelEstado.add(buttonBackEstado, gbc_buttonBackEstado);
		
		if(tabla.size()>0) {
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		this.panelEstado.add(scrollPane, gbc_scrollPane);
		
		Object[][] rows = new Object[tabla.size()][4];
		 String[] cabeza={"Marca", "Placa", "Tipo Vehículo", "Tiempo (minutos)"};
		 int i=0;
		 for(Map.Entry<Vehicle,LocalDateTime> entry : tabla.entrySet()) {
				Vehicle key = entry.getKey(); 
				LocalDateTime value = entry.getValue();
				
				rows[i][0]=key.getPlaca();
				rows[i][1]=key.getMarca();
				rows[i][2]=key.getNameClass();
				rows[i][3]=value;
				i++;
		}		 
		 
		tableEstado = new JTable(rows,cabeza);
		scrollPane.setViewportView(tableEstado);
		}else {
			
			lblNoAuto.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblEstado = new GridBagConstraints();
			gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
			gbc_lblEstado.gridx = 5;
			gbc_lblEstado.gridy = 5;
			this.panelEstado.add(lblNoAuto, gbc_lblEstado);
		}
		
		this.add(this.panelEstado);
		this.pack();
		
				//listeners
		buttonBackEstado.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				panelEstado.remove(buttonBackEstado);
				panelEstado.remove(scrollPane);
				panelEstado.remove(lblNoAuto);
				
				remove(panelEstado);
				showPanelMenu();
				
				}
				});
		
	}
		
	private void setupPanelPagos() {
		this.panelPagos = new JPanel();
		GridBagLayout gridBagLayoutPagos = new GridBagLayout();
		gridBagLayoutPagos.columnWidths = new int[]{0, 30, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutPagos.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutPagos.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayoutPagos.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panelPagos.setLayout(gridBagLayoutPagos);
		
		//final JTable  tablePagos;
		JLabel lblPagos = new JLabel("Pagos");
		lblPagos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPagos = new GridBagConstraints();
		gbc_lblPagos.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagos.gridx = 5;
		gbc_lblPagos.gridy = 1;
		this.panelPagos.add(lblPagos, gbc_lblPagos);
	}
	
		public void payCars (TreeMap<Vehicle, LocalDateTime> tablaP) {
			final JTable  tablePagos;
			JScrollPane scrollPanePagos = new JScrollPane();
			JButton buttonBackPagos = new JButton("<-");
			JLabel lblNoAutoPagos = new JLabel("No hay autos");
			
			GridBagConstraints gbc_buttonBackPagos = new GridBagConstraints();
			gbc_buttonBackPagos.insets = new Insets(0, 0, 5, 5);
			gbc_buttonBackPagos.gridx = 0;
			gbc_buttonBackPagos.gridy = 0;
			this.panelPagos.add(buttonBackPagos, gbc_buttonBackPagos);
			
			if(tablaP.size()>0) {
			
			GridBagConstraints gbc_scrollPanePagos = new GridBagConstraints();
			gbc_scrollPanePagos.gridwidth = 7;
			gbc_scrollPanePagos.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPanePagos.fill = GridBagConstraints.BOTH;
			gbc_scrollPanePagos.gridx = 1;
			gbc_scrollPanePagos.gridy = 4;
			this.panelPagos.add(scrollPanePagos, gbc_scrollPanePagos);
			
			Object[][] rows = new Object[tablaP.size()][4];
			 String[] cabezal={"Marca", "Placa", "Tipo Vehículo", "Tiempo (minutos)"};
			 int i=0;
			 for(Map.Entry<Vehicle,LocalDateTime> entry : tablaP.entrySet()) {
					Vehicle key = entry.getKey(); 
					LocalDateTime value = entry.getValue();
					
					rows[i][0]=key.getPlaca();
					rows[i][1]=key.getMarca();
					rows[i][2]=key.getNameClass();
					rows[i][3]=value;
					i++;
			}		 
			 
			tablePagos = new JTable(rows,cabezal);
			scrollPanePagos.setViewportView(tablePagos);
			}else {
				
				lblNoAutoPagos.setFont(new Font("Tahoma", Font.PLAIN, 15));
				GridBagConstraints gbc_lblPagos2 = new GridBagConstraints();
				gbc_lblPagos2.insets = new Insets(0, 0, 5, 5);
				gbc_lblPagos2.gridx = 5;
				gbc_lblPagos2.gridy = 5;
				this.panelPagos.add(lblNoAutoPagos, gbc_lblPagos2);
			}
			
			JButton btnPagar = new JButton("Pagar");
			GridBagConstraints gbc_btnPagar = new GridBagConstraints();
			gbc_btnPagar.insets = new Insets(0, 0, 5, 5);
			gbc_btnPagar.gridx = 5;
			gbc_btnPagar.gridy = 10;
			this.panelPagos.add(btnPagar, gbc_btnPagar);
			
			this.add(this.panelPagos);
			this.pack();
		
		//listeners
		btnPagar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				if(tablaP.size()>0) {
					panelPagos.remove(buttonBackPagos);
					panelPagos.remove(scrollPanePagos);
					panelPagos.remove(lblNoAutoPagos);
					
					remove(panelPagos);
				int resp = JOptionPane.showConfirmDialog(null, "¿Cliente frecuente?");
				if (resp == 0) {
					showPanelFacturaFrecuente();
				} else if (resp == 1) {
					showPanelFactura();
				} else if (resp == 2) {
					//showPanelPagos();
					payCars(pm.getVehicles());
				}
			} else {
				panelPagos.remove(buttonBackPagos);
				panelPagos.remove(scrollPanePagos);
				panelPagos.remove(lblNoAutoPagos);
				
				remove(panelPagos);
				JOptionPane.showMessageDialog(null, "No hay autos para realizar el pago");
				showPanelMenu();
				}
			}
			});
		buttonBackPagos.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				panelPagos.remove(buttonBackPagos);
				panelPagos.remove(scrollPanePagos);
				panelPagos.remove(lblNoAutoPagos);
				
				remove(panelPagos);
				showPanelMenu();
				
				}
				});
		
	}
	
	private void setupPanelFactura() {
		this.panelFactura = new JPanel();
		GridBagLayout gridBagLayoutFactura = new GridBagLayout();
		gridBagLayoutFactura.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutFactura.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutFactura.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayoutFactura.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panelFactura.setLayout(gridBagLayoutFactura);
		
		JLabel lblPagoParking = new JLabel("Pago Parking");
		lblPagoParking.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPagoParking = new GridBagConstraints();
		gbc_lblPagoParking.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagoParking.gridx = 3;
		gbc_lblPagoParking.gridy = 0;
		this.panelFactura.add(lblPagoParking, gbc_lblPagoParking);
		
		JLabel lblTipoVehiculo = new JLabel("Tipo Veh\u00EDculo");
		GridBagConstraints gbc_lblTipoVehiculo = new GridBagConstraints();
		gbc_lblTipoVehiculo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoVehiculo.gridx = 1;
		gbc_lblTipoVehiculo.gridy = 2;
		this.panelFactura.add(lblTipoVehiculo, gbc_lblTipoVehiculo);
		
		JTextArea textAreaTipoVehículo = new JTextArea();
		textAreaTipoVehículo.setEditable(false);
		textAreaTipoVehículo.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaTipoVehículo = new GridBagConstraints();
		gbc_textAreaTipoVehículo.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaTipoVehículo.fill = GridBagConstraints.BOTH;
		gbc_textAreaTipoVehículo.gridx = 4;
		gbc_textAreaTipoVehículo.gridy = 2;
		this.panelFactura.add(textAreaTipoVehículo, gbc_textAreaTipoVehículo);
		
		JLabel lblPlaca = new JLabel("Placa");
		GridBagConstraints gbc_lblPlaca = new GridBagConstraints();
		gbc_lblPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlaca.gridx = 1;
		gbc_lblPlaca.gridy = 4;
		this.panelFactura.add(lblPlaca, gbc_lblPlaca);
		
		JTextArea textAreaPlaca = new JTextArea();
		textAreaPlaca.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textAreaPlaca.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaPlaca = new GridBagConstraints();
		gbc_textAreaPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaPlaca.fill = GridBagConstraints.BOTH;
		gbc_textAreaPlaca.gridx = 4;
		gbc_textAreaPlaca.gridy = 4;
		this.panelFactura.add(textAreaPlaca, gbc_textAreaPlaca);
		
		JLabel lblHoraEntrada = new JLabel("Hora Entrada");
		GridBagConstraints gbc_lblHoraEntrada = new GridBagConstraints();
		gbc_lblHoraEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraEntrada.gridx = 1;
		gbc_lblHoraEntrada.gridy = 6;
		this.panelFactura.add(lblHoraEntrada, gbc_lblHoraEntrada);
		
		JTextArea textAreaHoraEntrada = new JTextArea();
		textAreaHoraEntrada.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaHoraEntrada = new GridBagConstraints();
		gbc_textAreaHoraEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaHoraEntrada.fill = GridBagConstraints.BOTH;
		gbc_textAreaHoraEntrada.gridx = 4;
		gbc_textAreaHoraEntrada.gridy = 6;
		this.panelFactura.add(textAreaHoraEntrada, gbc_textAreaHoraEntrada);
		
		JLabel lblHoraSalida = new JLabel("Hora Salida");
		GridBagConstraints gbc_lblHoraSalida = new GridBagConstraints();
		gbc_lblHoraSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraSalida.gridx = 1;
		gbc_lblHoraSalida.gridy = 8;
		this.panelFactura.add(lblHoraSalida, gbc_lblHoraSalida);
		
		JTextArea textAreaHoraSalida = new JTextArea();
		textAreaHoraSalida.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaHoraSalida = new GridBagConstraints();
		gbc_textAreaHoraSalida.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaHoraSalida.fill = GridBagConstraints.BOTH;
		gbc_textAreaHoraSalida.gridx = 4;
		gbc_textAreaHoraSalida.gridy = 8;
		this.panelFactura.add(textAreaHoraSalida, gbc_textAreaHoraSalida);
		
		JLabel lblTiempominutos = new JLabel("Tiempo(Minutos)");
		GridBagConstraints gbc_lblTiempominutos = new GridBagConstraints();
		gbc_lblTiempominutos.insets = new Insets(0, 0, 5, 5);
		gbc_lblTiempominutos.gridx = 1;
		gbc_lblTiempominutos.gridy = 10;
		this.panelFactura.add(lblTiempominutos, gbc_lblTiempominutos);
		
		JTextArea textAreaTiempo = new JTextArea();
		textAreaTiempo.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaTiempo = new GridBagConstraints();
		gbc_textAreaTiempo.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaTiempo.fill = GridBagConstraints.BOTH;
		gbc_textAreaTiempo.gridx = 4;
		gbc_textAreaTiempo.gridy = 10;
		this.panelFactura.add(textAreaTiempo, gbc_textAreaTiempo);
		
		JLabel lblPrecioTotal = new JLabel("Precio Total");
		GridBagConstraints gbc_lblPrecioTotal = new GridBagConstraints();
		gbc_lblPrecioTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioTotal.gridx = 1;
		gbc_lblPrecioTotal.gridy = 12;
		this.panelFactura.add(lblPrecioTotal, gbc_lblPrecioTotal);
		
		JTextArea textAreaPrecio = new JTextArea();
		textAreaPrecio.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaPrecio = new GridBagConstraints();
		gbc_textAreaPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaPrecio.fill = GridBagConstraints.BOTH;
		gbc_textAreaPrecio.gridx = 4;
		gbc_textAreaPrecio.gridy = 12;
		this.panelFactura.add(textAreaPrecio, gbc_textAreaPrecio);
		
		JLabel lblDineroIngresado = new JLabel("Dinero ingresado");
		GridBagConstraints gbc_lblDineroIngresado = new GridBagConstraints();
		gbc_lblDineroIngresado.insets = new Insets(0, 0, 5, 5);
		gbc_lblDineroIngresado.gridx = 1;
		gbc_lblDineroIngresado.gridy = 14;
		this.panelFactura.add(lblDineroIngresado, gbc_lblDineroIngresado);
		
		JTextField textFieldDinero = new JTextField();
		GridBagConstraints gbc_textFieldDinero = new GridBagConstraints();
		gbc_textFieldDinero.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDinero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDinero.gridx = 4;
		gbc_textFieldDinero.gridy = 14;
		this.panelFactura.add(textFieldDinero, gbc_textFieldDinero);
		textFieldDinero.setColumns(10);
		
		JButton btnRealizarPago = new JButton("Realizar Pago");
		GridBagConstraints gbc_btnRealizarPago = new GridBagConstraints();
		gbc_btnRealizarPago.insets = new Insets(0, 0, 0, 5);
		gbc_btnRealizarPago.gridx = 3;
		gbc_btnRealizarPago.gridy = 16;
		this.panelFactura.add(btnRealizarPago, gbc_btnRealizarPago);
		
		JButton buttonBackFactura = new JButton("<-");
		GridBagConstraints gbc_buttonBackFactura = new GridBagConstraints();
		gbc_buttonBackFactura.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBackFactura.gridx = 0;
		gbc_buttonBackFactura.gridy = 0;
		this.panelFactura.add(buttonBackFactura, gbc_buttonBackFactura);
		
		//listeners
		btnRealizarPago.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				remove(panelFactura);
				JOptionPane.showMessageDialog(null, "Pago realizado con éxito, su cambio es:");
				showPanelMenu();
				}
				});
		buttonBackFactura.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				remove(panelFactura);
				//showPanelPagos();
				payCars(pm.getVehicles());
				}
				});
		}
	
	private void setupPanelFacturaFrecuente() {
		this.panelFacturaFrecuente = new JPanel();
		GridBagLayout gridBagLayoutFacturaFrecuente = new GridBagLayout();
		gridBagLayoutFacturaFrecuente.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutFacturaFrecuente.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutFacturaFrecuente.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayoutFacturaFrecuente.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panelFacturaFrecuente.setLayout(gridBagLayoutFacturaFrecuente);
		
		JLabel lblPagoParkingFrecuente = new JLabel("Pago Parking Frecuente");
		lblPagoParkingFrecuente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPagoParkingFrecuente = new GridBagConstraints();
		gbc_lblPagoParkingFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagoParkingFrecuente.gridx = 3;
		gbc_lblPagoParkingFrecuente.gridy = 0;
		this.panelFacturaFrecuente.add(lblPagoParkingFrecuente, gbc_lblPagoParkingFrecuente);
		
		JLabel lblPuntosClienteFrecuente = new JLabel("Puntos Cliente");
		GridBagConstraints gbc_lblPuntosClienteFrecuente = new GridBagConstraints();
		gbc_lblPuntosClienteFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntosClienteFrecuente.gridx = 1;
		gbc_lblPuntosClienteFrecuente.gridy = 2;
		this.panelFacturaFrecuente.add(lblPuntosClienteFrecuente, gbc_lblPuntosClienteFrecuente);
		
		JTextArea textAreaPuntosClienteFrecuente = new JTextArea();
		textAreaPuntosClienteFrecuente.setEditable(false);
		textAreaPuntosClienteFrecuente.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaPuntosClienteFrecuente = new GridBagConstraints();
		gbc_textAreaPuntosClienteFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaPuntosClienteFrecuente.fill = GridBagConstraints.BOTH;
		gbc_textAreaPuntosClienteFrecuente.gridx = 4;
		gbc_textAreaPuntosClienteFrecuente.gridy = 2;
		this.panelFacturaFrecuente.add(textAreaPuntosClienteFrecuente, gbc_textAreaPuntosClienteFrecuente);
		
		JLabel lblTipoVehiculoFrecuente = new JLabel("Tipo Vehículo");
		GridBagConstraints gbc_lblTipoVehiculoFrecuente = new GridBagConstraints();
		gbc_lblTipoVehiculoFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoVehiculoFrecuente.gridx = 1;
		gbc_lblTipoVehiculoFrecuente.gridy = 4;
		this.panelFacturaFrecuente.add(lblTipoVehiculoFrecuente, gbc_lblTipoVehiculoFrecuente);
		
		JTextArea textAreaTipoVehículoFrecuente = new JTextArea();
		textAreaTipoVehículoFrecuente.setEditable(false);
		textAreaTipoVehículoFrecuente.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaTipoVehículoFrecuente = new GridBagConstraints();
		gbc_textAreaTipoVehículoFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaTipoVehículoFrecuente.fill = GridBagConstraints.BOTH;
		gbc_textAreaTipoVehículoFrecuente.gridx = 4;
		gbc_textAreaTipoVehículoFrecuente.gridy = 4;
		this.panelFacturaFrecuente.add(textAreaTipoVehículoFrecuente, gbc_textAreaTipoVehículoFrecuente);
		
		JLabel lblPlacaFrecuente = new JLabel("Placa");
		GridBagConstraints gbc_lblPlacaFrecuente = new GridBagConstraints();
		gbc_lblPlacaFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlacaFrecuente.gridx = 1;
		gbc_lblPlacaFrecuente.gridy = 6;
		this.panelFacturaFrecuente.add(lblPlacaFrecuente, gbc_lblPlacaFrecuente);
		
		JTextArea textAreaPlacaFrecuente = new JTextArea();
		textAreaPlacaFrecuente.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textAreaPlacaFrecuente.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaPlacaFrecuente = new GridBagConstraints();
		gbc_textAreaPlacaFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaPlacaFrecuente.fill = GridBagConstraints.BOTH;
		gbc_textAreaPlacaFrecuente.gridx = 4;
		gbc_textAreaPlacaFrecuente.gridy = 6;
		this.panelFacturaFrecuente.add(textAreaPlacaFrecuente, gbc_textAreaPlacaFrecuente);
		
		JLabel lblHoraEntradaFrecuente = new JLabel("Hora Entrada");
		GridBagConstraints gbc_lblHoraEntradaFrecuente = new GridBagConstraints();
		gbc_lblHoraEntradaFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraEntradaFrecuente.gridx = 1;
		gbc_lblHoraEntradaFrecuente.gridy = 8;
		this.panelFacturaFrecuente.add(lblHoraEntradaFrecuente, gbc_lblHoraEntradaFrecuente);
		
		JTextArea textAreaHoraEntradaFrecuente = new JTextArea();
		textAreaHoraEntradaFrecuente.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaHoraEntradaFrecuente = new GridBagConstraints();
		gbc_textAreaHoraEntradaFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaHoraEntradaFrecuente.fill = GridBagConstraints.BOTH;
		gbc_textAreaHoraEntradaFrecuente.gridx = 4;
		gbc_textAreaHoraEntradaFrecuente.gridy = 8;
		this.panelFacturaFrecuente.add(textAreaHoraEntradaFrecuente, gbc_textAreaHoraEntradaFrecuente);
		
		JLabel lblHoraSalidaFrecuente = new JLabel("Hora Salida");
		GridBagConstraints gbc_lblHoraSalidaFrecuente = new GridBagConstraints();
		gbc_lblHoraSalidaFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraSalidaFrecuente.gridx = 1;
		gbc_lblHoraSalidaFrecuente.gridy = 10;
		this.panelFacturaFrecuente.add(lblHoraSalidaFrecuente, gbc_lblHoraSalidaFrecuente);
		
		JTextArea textAreaHoraSalidaFrecuente = new JTextArea();
		textAreaHoraSalidaFrecuente.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaHoraSalidaFrecuente = new GridBagConstraints();
		gbc_textAreaHoraSalidaFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaHoraSalidaFrecuente.fill = GridBagConstraints.BOTH;
		gbc_textAreaHoraSalidaFrecuente.gridx = 4;
		gbc_textAreaHoraSalidaFrecuente.gridy = 10;
		this.panelFacturaFrecuente.add(textAreaHoraSalidaFrecuente, gbc_textAreaHoraSalidaFrecuente);
		
		JLabel lblTiempominutosFrecuente = new JLabel("Tiempo(Minutos)");
		GridBagConstraints gbc_lblTiempominutosFrecuente = new GridBagConstraints();
		gbc_lblTiempominutosFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblTiempominutosFrecuente.gridx = 1;
		gbc_lblTiempominutosFrecuente.gridy = 12;
		this.panelFacturaFrecuente.add(lblTiempominutosFrecuente, gbc_lblTiempominutosFrecuente);
		
		JTextArea textAreaTiempoFrecuente = new JTextArea();
		textAreaTiempoFrecuente.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaTiempoFrecuente = new GridBagConstraints();
		gbc_textAreaTiempoFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaTiempoFrecuente.fill = GridBagConstraints.BOTH;
		gbc_textAreaTiempoFrecuente.gridx = 4;
		gbc_textAreaTiempoFrecuente.gridy = 12;
		this.panelFacturaFrecuente.add(textAreaTiempoFrecuente, gbc_textAreaTiempoFrecuente);
		
		JLabel lblPrecioTotalFrecuente = new JLabel("Precio Total");
		GridBagConstraints gbc_lblPrecioTotalFrecuente = new GridBagConstraints();
		gbc_lblPrecioTotalFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioTotalFrecuente.gridx = 1;
		gbc_lblPrecioTotalFrecuente.gridy = 14;
		this.panelFacturaFrecuente.add(lblPrecioTotalFrecuente, gbc_lblPrecioTotalFrecuente);
		
		JTextArea textAreaPrecioFrecuente = new JTextArea();
		textAreaPrecioFrecuente.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaPrecioFrecuente = new GridBagConstraints();
		gbc_textAreaPrecioFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaPrecioFrecuente.fill = GridBagConstraints.BOTH;
		gbc_textAreaPrecioFrecuente.gridx = 4;
		gbc_textAreaPrecioFrecuente.gridy = 14;
		this.panelFacturaFrecuente.add(textAreaPrecioFrecuente, gbc_textAreaPrecioFrecuente);
		
		JLabel lblRedencionPuntos = new JLabel("Redención Puntos");
		GridBagConstraints gbc_lblRedencionPuntos = new GridBagConstraints();
		gbc_lblRedencionPuntos.insets = new Insets(0, 0, 5, 5);
		gbc_lblRedencionPuntos.gridx = 1;
		gbc_lblRedencionPuntos.gridy = 16;
		this.panelFacturaFrecuente.add(lblRedencionPuntos, gbc_lblRedencionPuntos);
		
		JRadioButton rdbtnRadioButton = new JRadioButton("");
		GridBagConstraints gbc_rdbtnRadioButton = new GridBagConstraints();
		gbc_rdbtnRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnRadioButton.gridx = 4;
		gbc_rdbtnRadioButton.gridy = 16;
		this.panelFacturaFrecuente.add(rdbtnRadioButton, gbc_rdbtnRadioButton);
		
		JLabel lblNumeroARedimir = new JLabel("Número a redimir");
		GridBagConstraints gbc_lblNumeroARedimir = new GridBagConstraints();
		gbc_lblNumeroARedimir.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroARedimir.gridx = 1;
		gbc_lblNumeroARedimir.gridy = 18;
		this.panelFacturaFrecuente.add(lblNumeroARedimir, gbc_lblNumeroARedimir);
		
		JFormattedTextField formattedTextFieldPuntos = new JFormattedTextField();
		GridBagConstraints gbc_formattedTextFieldPuntos = new GridBagConstraints();
		gbc_formattedTextFieldPuntos.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldPuntos.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldPuntos.gridx = 4;
		gbc_formattedTextFieldPuntos.gridy = 18;
		this.panelFacturaFrecuente.add(formattedTextFieldPuntos, gbc_formattedTextFieldPuntos);
		
		JLabel lblDescuento = new JLabel("Descuento");
		GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
		gbc_lblDescuento.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescuento.gridx = 1;
		gbc_lblDescuento.gridy = 20;
		this.panelFacturaFrecuente.add(lblDescuento, gbc_lblDescuento);
		
		JTextArea textAreaDescuento = new JTextArea();
		GridBagConstraints gbc_textAreaDescuento = new GridBagConstraints();
		textAreaDescuento.setBackground(SystemColor.menu);
		gbc_textAreaDescuento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAreaDescuento.gridx = 4;
		gbc_textAreaDescuento.gridy = 20;
		this.panelFacturaFrecuente.add(textAreaDescuento, gbc_textAreaDescuento);	
		
		JLabel lblDineroIngresadoFrecuente = new JLabel("Dinero ingresado");
		GridBagConstraints gbc_lblDineroIngresadoFrecuente = new GridBagConstraints();
		gbc_lblDineroIngresadoFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblDineroIngresadoFrecuente.gridx = 1;
		gbc_lblDineroIngresadoFrecuente.gridy = 22;
		this.panelFacturaFrecuente.add(lblDineroIngresadoFrecuente, gbc_lblDineroIngresadoFrecuente);
		
		JTextField textFieldDineroFrecuente = new JTextField();
		GridBagConstraints gbc_textFieldDineroFrecuente = new GridBagConstraints();
		gbc_textFieldDineroFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDineroFrecuente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDineroFrecuente.gridx = 4;
		gbc_textFieldDineroFrecuente.gridy = 22;
		this.panelFacturaFrecuente.add(textFieldDineroFrecuente, gbc_textFieldDineroFrecuente);
		textFieldDineroFrecuente.setColumns(10);
		
		JButton btnRealizarPagoFrecuente = new JButton("Realizar Pago");
		GridBagConstraints gbc_btnRealizarPagoFrecuente = new GridBagConstraints();
		gbc_btnRealizarPagoFrecuente.insets = new Insets(0, 0, 0, 5);
		gbc_btnRealizarPagoFrecuente.gridx = 3;
		gbc_btnRealizarPagoFrecuente.gridy = 24;
		this.panelFacturaFrecuente.add(btnRealizarPagoFrecuente, gbc_btnRealizarPagoFrecuente);
		
		JButton buttonBackFactura = new JButton("<-");
		GridBagConstraints gbc_buttonBackFactura = new GridBagConstraints();
		gbc_buttonBackFactura.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBackFactura.gridx = 0;
		gbc_buttonBackFactura.gridy = 0;
		this.panelFacturaFrecuente.add(buttonBackFactura, gbc_buttonBackFactura);
		
		//listeners
		btnRealizarPagoFrecuente.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				remove(panelFacturaFrecuente);
				JOptionPane.showMessageDialog(null, "Pago realizado con éxito, su cambio es:");
				showPanelMenu();
				}
				});
		buttonBackFactura.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				remove(panelFacturaFrecuente);
				//showPanelPagos();
				payCars(pm.getVehicles());
				}
				});
		}
	private void setupPanelPrecios() {
		this.panelPrecios = new JPanel();
		GridBagLayout gridBagLayoutPrecios = new GridBagLayout();
		gridBagLayoutPrecios.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 175, 0, 0};
		gridBagLayoutPrecios.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutPrecios.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayoutPrecios.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panelPrecios.setLayout(gridBagLayoutPrecios);
		
		JLabel lblEditorPrecios = new JLabel("Precios actuales");
		lblEditorPrecios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEditorPrecios = new GridBagConstraints();
		gbc_lblEditorPrecios.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditorPrecios.gridx = 4;
		gbc_lblEditorPrecios.gridy = 0;
		this.panelPrecios.add(lblEditorPrecios, gbc_lblEditorPrecios);
		
		JLabel lblPrecioCarro = new JLabel("Precio carro");
		GridBagConstraints gbc_lblPrecioCarro = new GridBagConstraints();
		gbc_lblPrecioCarro.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioCarro.gridx = 2;
		gbc_lblPrecioCarro.gridy = 2;
		this.panelPrecios.add(lblPrecioCarro, gbc_lblPrecioCarro);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBackground(Color.WHITE);
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.gridx = 6;
		gbc_formattedTextField.gridy = 2;
		this.panelPrecios.add(formattedTextField, gbc_formattedTextField);
		
		JLabel lblPrecioMoto = new JLabel("Precio moto");
		GridBagConstraints gbc_lblPrecioMoto = new GridBagConstraints();
		gbc_lblPrecioMoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioMoto.gridx = 2;
		gbc_lblPrecioMoto.gridy = 4;
		this.panelPrecios.add(lblPrecioMoto, gbc_lblPrecioMoto);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		GridBagConstraints gbc_formattedTextField_1 = new GridBagConstraints();
		gbc_formattedTextField_1.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_1.gridx = 6;
		gbc_formattedTextField_1.gridy = 4;
		this.panelPrecios.add(formattedTextField_1, gbc_formattedTextField_1);
		
		JButton btnRealizarCambios = new JButton("Realizar cambios");
		GridBagConstraints gbc_btnRealizarCambios = new GridBagConstraints();
		gbc_btnRealizarCambios.insets = new Insets(0, 0, 0, 5);
		gbc_btnRealizarCambios.gridx = 4;
		gbc_btnRealizarCambios.gridy = 6;
		this.panelPrecios.add(btnRealizarCambios, gbc_btnRealizarCambios);
		
		JButton buttonBackPrecios = new JButton("<-");
		GridBagConstraints gbc_buttonBackPrecios = new GridBagConstraints();
		gbc_buttonBackPrecios.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBackPrecios.gridx = 0;
		gbc_buttonBackPrecios.gridy = 0;
		this.panelPrecios.add(buttonBackPrecios, gbc_buttonBackPrecios);
		//listeners
				btnRealizarCambios.addActionListener(new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						remove(panelPrecios);
						JOptionPane.showMessageDialog(null, "Los nuevos precios han sido fijados");
						showPanelMenu();
						}
						});
				buttonBackPrecios.addActionListener(new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						remove(panelPrecios);
						showPanelMenu();
						}
						});
				
	}
	private void setupPanelStats() {
		this.panelStats = new JPanel();
		setBackground(SystemColor.menu);
		GridBagLayout gridBagLayoutStats = new GridBagLayout();
		gridBagLayoutStats.columnWidths = new int[]{0, 18, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutStats.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutStats.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayoutStats.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		this.panelStats.setLayout(gridBagLayoutStats);
		
		JLabel lblEstadisticas = new JLabel("Estadisticas");
		lblEstadisticas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEstadisticas = new GridBagConstraints();
		gbc_lblEstadisticas.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstadisticas.gridx = 3;
		gbc_lblEstadisticas.gridy = 0;
		this.panelStats.add(lblEstadisticas, gbc_lblEstadisticas);
		
		JLabel lblVehiculosIngresados = new JLabel("Vehiculos ingresados");
		GridBagConstraints gbc_lblVehiculosIngresados = new GridBagConstraints();
		gbc_lblVehiculosIngresados.insets = new Insets(0, 0, 5, 5);
		gbc_lblVehiculosIngresados.gridx = 2;
		gbc_lblVehiculosIngresados.gridy = 2;
		this.panelStats.add(lblVehiculosIngresados, gbc_lblVehiculosIngresados);
		
		JTextArea textAreaVehiculosIngreso = new JTextArea();
		textAreaVehiculosIngreso.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaVehiculosIngreso = new GridBagConstraints();
		gbc_textAreaVehiculosIngreso.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaVehiculosIngreso.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAreaVehiculosIngreso.gridx = 4;
		gbc_textAreaVehiculosIngreso.gridy = 2;
		this.panelStats.add(textAreaVehiculosIngreso, gbc_textAreaVehiculosIngreso);
		
		JLabel lblCarrosIngresados = new JLabel("Carros ingresados");
		GridBagConstraints gbc_lblCarrosIngresados = new GridBagConstraints();
		gbc_lblCarrosIngresados.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarrosIngresados.gridx = 2;
		gbc_lblCarrosIngresados.gridy = 4;
		this.panelStats.add(lblCarrosIngresados, gbc_lblCarrosIngresados);
		
		JTextArea textAreaCarrosIngreso = new JTextArea();
		textAreaCarrosIngreso.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaCarrosIngreso = new GridBagConstraints();
		gbc_textAreaCarrosIngreso.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaCarrosIngreso.fill = GridBagConstraints.BOTH;
		gbc_textAreaCarrosIngreso.gridx = 4;
		gbc_textAreaCarrosIngreso.gridy = 4;
		this.panelStats.add(textAreaCarrosIngreso, gbc_textAreaCarrosIngreso);
		
		JLabel lblMotosIngresadas = new JLabel("Motos ingresadas");
		GridBagConstraints gbc_lblMotosIngresadas = new GridBagConstraints();
		gbc_lblMotosIngresadas.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotosIngresadas.gridx = 2;
		gbc_lblMotosIngresadas.gridy = 6;
		this.panelStats.add(lblMotosIngresadas, gbc_lblMotosIngresadas);
		
		JButton buttonBackStats = new JButton("<-");
		GridBagConstraints gbc_buttonBackStats = new GridBagConstraints();
		gbc_buttonBackStats.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBackStats.gridx = 0;
		gbc_buttonBackStats.gridy = 0;
		this.panelStats.add(buttonBackStats, gbc_buttonBackStats);
		
		JTextArea textAreaMotosIngreso = new JTextArea();
		textAreaMotosIngreso.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaMotosIngreso = new GridBagConstraints();
		gbc_textAreaMotosIngreso.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaMotosIngreso.fill = GridBagConstraints.BOTH;
		gbc_textAreaMotosIngreso.gridx = 4;
		gbc_textAreaMotosIngreso.gridy = 6;
		this.panelStats.add(textAreaMotosIngreso, gbc_textAreaMotosIngreso);
		
		JLabel lblGananciasDa = new JLabel("Ganancias día");
		GridBagConstraints gbc_lblGananciasDa = new GridBagConstraints();
		gbc_lblGananciasDa.insets = new Insets(0, 0, 0, 5);
		gbc_lblGananciasDa.gridx = 2;
		gbc_lblGananciasDa.gridy = 8;
		this.panelStats.add(lblGananciasDa, gbc_lblGananciasDa);
		
		JTextArea textAreaGanancias = new JTextArea();
		textAreaGanancias.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaGanancias = new GridBagConstraints();
		gbc_textAreaGanancias.insets = new Insets(0, 0, 0, 5);
		gbc_textAreaGanancias.fill = GridBagConstraints.BOTH;
		gbc_textAreaGanancias.gridx = 4;
		gbc_textAreaGanancias.gridy = 8;
		this.panelStats.add(textAreaGanancias, gbc_textAreaGanancias);
		//listeners
		buttonBackStats.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				remove(panelStats);
				showPanelMenu();
				}
				});
	}
	private void setupPanelRegistro() {
		this.panelRegistro = new JPanel();
		GridBagLayout gridBagLayoutRegistro = new GridBagLayout();
		gridBagLayoutRegistro.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayoutRegistro.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutRegistro.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayoutRegistro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panelRegistro.setLayout(gridBagLayoutRegistro);
		
		JButton buttonBack = new JButton("<-");
		GridBagConstraints gbc_buttonBack = new GridBagConstraints();
		gbc_buttonBack.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBack.gridx = 0;
		gbc_buttonBack.gridy = 0;
		this.panelRegistro.add(buttonBack, gbc_buttonBack);
		
		JLabel lblRegistroClienteFrecuente = new JLabel("Registro Cliente Frecuente");
		lblRegistroClienteFrecuente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblRegistroClienteFrecuente = new GridBagConstraints();
		gbc_lblRegistroClienteFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistroClienteFrecuente.gridx = 2;
		gbc_lblRegistroClienteFrecuente.gridy = 1;
		this.panelRegistro.add(lblRegistroClienteFrecuente, gbc_lblRegistroClienteFrecuente);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		this.panelRegistro.add(lblNombre, gbc_lblNombre);
		
		JTextField textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.gridx = 3;
		gbc_textFieldNombre.gridy = 3;
		this.panelRegistro.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblPlacaVehculo = new JLabel("Placa Veh\u00EDculo");
		GridBagConstraints gbc_lblPlacaVehculo = new GridBagConstraints();
		gbc_lblPlacaVehculo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlacaVehculo.gridx = 1;
		gbc_lblPlacaVehculo.gridy = 5;
		this.panelRegistro.add(lblPlacaVehculo, gbc_lblPlacaVehculo);
		
		JTextField textFieldPlacaVehiculo = new JTextField();
		GridBagConstraints gbc_textFieldPlacaVehiculo = new GridBagConstraints();
		gbc_textFieldPlacaVehiculo.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPlacaVehiculo.gridx = 3;
		gbc_textFieldPlacaVehiculo.gridy = 5;
		this.panelRegistro.add(textFieldPlacaVehiculo, gbc_textFieldPlacaVehiculo);
		textFieldPlacaVehiculo.setColumns(10);
		
		JLabel lblNmeroDeCdula = new JLabel("N\u00FAmero de C\u00E9dula");
		GridBagConstraints gbc_lblNmeroDeCdula = new GridBagConstraints();
		gbc_lblNmeroDeCdula.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroDeCdula.gridx = 1;
		gbc_lblNmeroDeCdula.gridy = 7;
		this.panelRegistro.add(lblNmeroDeCdula, gbc_lblNmeroDeCdula);
		
		JTextField textFieldCC = new JTextField();
		GridBagConstraints gbc_textFieldCC = new GridBagConstraints();
		gbc_textFieldCC.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCC.gridx = 3;
		gbc_textFieldCC.gridy = 7;
		this.panelRegistro.add(textFieldCC, gbc_textFieldCC);
		textFieldCC.setColumns(10);
		
		JButton btnRegistro = new JButton("Registrar");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnRegistro = new GridBagConstraints();
		gbc_btnRegistro.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistro.gridx = 2;
		gbc_btnRegistro.gridy = 9;
		this.panelRegistro.add(btnRegistro, gbc_btnRegistro);
		
		//listeners
				buttonBack.addActionListener(new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						remove(panelRegistro);
						showPanelMenu();
						}
						});
				btnRegistro.addActionListener(new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						remove(panelRegistro);
						JOptionPane.showMessageDialog(null, "El usuario ha sido registrado correctamente");
						showPanelMenu();
						}
						});
		

	}
	
	public void showPanelMenu() {
		this.setSize(400, 210);
		this.add(this.panelMenu);
		this.pack();
	}
	
	public void showPanelIngreso() {
		this.add(this.panelIngreso);
		this.pack();
	}
	
	/*public void showPanelEstado() {
		this.add(this.panelEstado);
		this.pack();
	}*/
	
	/*public void showPanelPagos() {
		this.add(this.panelPagos);
		this.pack();
	}*/
	public void showPanelFactura() {
		this.add(this.panelFactura);
		this.pack();
	}
	public void showPanelFacturaFrecuente() {
		this.add(this.panelFacturaFrecuente);
		this.pack();
	}
	public void showPanelPrecios() {
		this.add(this.panelPrecios);
		this.pack();
	}
	public void showPanelStats() {
		this.add(this.panelStats);
		this.pack();
	}
	public void showPanelRegistro() {
		this.add(this.panelRegistro);
		this.pack();
	}
	
	
	
}
