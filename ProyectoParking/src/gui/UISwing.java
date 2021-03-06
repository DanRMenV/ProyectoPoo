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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
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
import javax.swing.text.MaskFormatter;

import business.*;
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
	private JPanel panelClientes;
	
	
	private ParkingManager pm;
	private ClientesManager cm;
	
	public UISwing(ParkingManager pm, ClientesManager cm) {
		this.pm=pm;
		this.cm=cm;
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
		this.setupPanelRegistro();
		this.setupPanelClientes();
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
					if(pm.getVehicles().size()>0) {
					payCars(pm.getVehicles());}
					else {
					noCars();
					}
				}
				});
	
			btnSalidaPrograma.addActionListener(new ActionListener () {
				public void actionPerformed (ActionEvent e) {
					remove(panelMenu);
					cm.saveClients();
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
	
		
		MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("UUU-###");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JFormattedTextField txtPlaca = new JFormattedTextField(mask);
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
		
		JLabel lblTipoVehculo = new JLabel("Tipo Veh�culo");
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
					Motorcycle m = new Motorcycle( txtMarca.getText(),txtPlaca.getText());
					pm.addVehicle(m,l);
				}else {
					Car c = new Car(txtMarca.getText(),txtPlaca.getText());
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
		 String[] cabeza={ "Placa", "Marca", "Tipo Veh�culo", "Tiempo (minutos)"};
		 int i=0;
		 for(Map.Entry<Vehicle,LocalDateTime> entry : tabla.entrySet()) {
				Vehicle key = entry.getKey(); 
				LocalDateTime value = entry.getValue();
				int hours  = value.getHour();
				int minutes = value.getMinute();
				int seconds = value.getSecond();
				String Hora = (""+ hours+":"+minutes+":"+seconds);			
					
				rows[i][0]=key.getPlaca();
				rows[i][1]=key.getMarca();
				rows[i][2]=key.getNameClass();
				rows[i][3]=Hora;
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
	
	public void noCars() {
		JButton buttonBackPagos = new JButton("<-");
		GridBagConstraints gbc_buttonBackPagos = new GridBagConstraints();
		gbc_buttonBackPagos.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBackPagos.gridx = 0;
		gbc_buttonBackPagos.gridy = 0;
		this.panelPagos.add(buttonBackPagos, gbc_buttonBackPagos);
		
		JLabel lblNoAutoPagos = new JLabel("No hay autos");
		lblNoAutoPagos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPagos2 = new GridBagConstraints();
		gbc_lblPagos2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagos2.gridx = 5;
		gbc_lblPagos2.gridy = 5;
		this.panelPagos.add(lblNoAutoPagos, gbc_lblPagos2);
		
		this.add(this.panelPagos);
		this.pack();		
		
		buttonBackPagos.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				panelPagos.remove(buttonBackPagos);
				//panelPagos.remove(scrollPanePagos);
				panelPagos.remove(lblNoAutoPagos);
				
				remove(panelPagos);
				showPanelMenu();
				
				}
				});
			
		
	}
		public void payCars (TreeMap<Vehicle, LocalDateTime> tablaP) {
			
			JTable  tablePagos;
			JScrollPane scrollPanePagos = new JScrollPane();
			JButton buttonBackPagos = new JButton("<-");
			
			GridBagConstraints gbc_buttonBackPagos = new GridBagConstraints();
			gbc_buttonBackPagos.insets = new Insets(0, 0, 5, 5);
			gbc_buttonBackPagos.gridx = 0;
			gbc_buttonBackPagos.gridy = 0;
			this.panelPagos.add(buttonBackPagos, gbc_buttonBackPagos);
			
			GridBagConstraints gbc_scrollPanePagos = new GridBagConstraints();
			gbc_scrollPanePagos.gridwidth = 7;
			gbc_scrollPanePagos.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPanePagos.fill = GridBagConstraints.BOTH;
			gbc_scrollPanePagos.gridx = 1;
			gbc_scrollPanePagos.gridy = 4;
			this.panelPagos.add(scrollPanePagos, gbc_scrollPanePagos);
			
			Object[][] rows = new Object[tablaP.size()][4];
			 String[] cabezal={"Placa","Marca", "Tipo Veh�culo", "Tiempo (minutos)"};
			 int i=0;
			 for(Map.Entry<Vehicle,LocalDateTime> entry : tablaP.entrySet()) {
					Vehicle key = entry.getKey(); 
					LocalDateTime value = entry.getValue();	
					int hours  = value.getHour();
					int minutes = value.getMinute();
					int seconds = value.getSecond();
					String HoraPago = (""+ hours+":"+minutes+":"+seconds);
					rows[i][0]=key.getPlaca();
					rows[i][1]=key.getMarca();
					rows[i][2]=key.getNameClass();
					rows[i][3]=HoraPago;
					i++;
			}		 
			 
			tablePagos = new JTable(rows,cabezal);
			scrollPanePagos.setViewportView(tablePagos);
						
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
					
				if(tablePagos.getSelectedRow()!=-1) {
					panelPagos.remove(buttonBackPagos);
					panelPagos.remove(scrollPanePagos);
					
					String placa=(String) tablePagos.getModel().getValueAt(tablePagos.getSelectedRow(), 0);
					Vehicle v=pm.searchVehicle(placa);
					
					Cliente_Parking c =cm.searchClient(placa);
					System.out.println(c);
					if(c!=null) {
						facturaCF(v,c);
					}else {
						facturaN(v);
					}				
					remove(panelPagos);
			}		
			
			}
			});
		
		buttonBackPagos.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				panelPagos.remove(buttonBackPagos);
				panelPagos.remove(scrollPanePagos);		
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
		
		}
	
	private void facturaN(Vehicle v) {
		
		JLabel lblPagoParking = new JLabel("Pago Parking");
		lblPagoParking.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPagoParking = new GridBagConstraints();
		gbc_lblPagoParking.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagoParking.gridx = 3;
		gbc_lblPagoParking.gridy = 0;
		this.panelFactura.add(lblPagoParking, gbc_lblPagoParking);
		
		JLabel lblTipoVehiculo = new JLabel("Tipo Veh\u00EDculo: "+ v.getNameClass());
		GridBagConstraints gbc_lblTipoVehiculo = new GridBagConstraints();
		gbc_lblTipoVehiculo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoVehiculo.gridx = 1;
		gbc_lblTipoVehiculo.gridy = 2;
		this.panelFactura.add(lblTipoVehiculo, gbc_lblTipoVehiculo);
		
		JLabel lblPlaca = new JLabel("Placa: "+v.getPlaca());
		GridBagConstraints gbc_lblPlaca = new GridBagConstraints();
		gbc_lblPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlaca.gridx = 1;
		gbc_lblPlaca.gridy = 4;
		this.panelFactura.add(lblPlaca, gbc_lblPlaca);
		
		LocalDateTime localDateE = pm.getVehicles().get(v);
		int hoursE  = localDateE.getHour();
		int minutesE = localDateE.getMinute();
		int secondsE = localDateE.getSecond();
		String horaFacturaE = (""+ hoursE+":"+minutesE+":"+secondsE);
		JLabel lblHoraEntrada = new JLabel("Hora Entrada: "+ horaFacturaE);
		GridBagConstraints gbc_lblHoraEntrada = new GridBagConstraints();
		gbc_lblHoraEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraEntrada.gridx = 1;
		gbc_lblHoraEntrada.gridy = 6;
		this.panelFactura.add(lblHoraEntrada, gbc_lblHoraEntrada);
		
		LocalDateTime localDate = LocalDateTime.now();
		int hours  = localDate.getHour();
		int minutos = localDate.getMinute();
		int seconds = localDate.getSecond();
		String horaFactura = (""+ hours+":"+minutos+":"+seconds);
		JLabel lblHoraSalida = new JLabel("Hora Salida: "+ horaFactura);
		GridBagConstraints gbc_lblHoraSalida = new GridBagConstraints();
		gbc_lblHoraSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraSalida.gridx = 1;
		gbc_lblHoraSalida.gridy = 8;
		this.panelFactura.add(lblHoraSalida, gbc_lblHoraSalida);
		
		int secdif=0;
		if(seconds>=secondsE) {
			secdif=seconds-secondsE;
		}else {
			secdif=60-secondsE;
		}
		
		int segundos=(hours-hoursE)*60*60+(minutos-minutesE)*60+secdif;
		
		JLabel lblTiempominutos = new JLabel("Tiempo(segundos): "+segundos );
		GridBagConstraints gbc_lblTiempominutos = new GridBagConstraints();
		gbc_lblTiempominutos.insets = new Insets(0, 0, 5, 5);
		gbc_lblTiempominutos.gridx = 1;
		gbc_lblTiempominutos.gridy = 10;
		this.panelFactura.add(lblTiempominutos, gbc_lblTiempominutos);
		
		
		JLabel lblPrecioTotal = new JLabel("Precio Total"+ v.getPrice(segundos));
		GridBagConstraints gbc_lblPrecioTotal = new GridBagConstraints();
		gbc_lblPrecioTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioTotal.gridx = 1;
		gbc_lblPrecioTotal.gridy = 12;
		this.panelFactura.add(lblPrecioTotal, gbc_lblPrecioTotal);
		
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
		
		this.add(this.panelFactura);
		this.pack();
		
		//Listeners
		buttonBackFactura.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				panelFactura.remove(buttonBackFactura);
				panelFactura.remove(lblPagoParking);
				panelFactura.remove(lblTipoVehiculo);
				panelFactura.remove(lblPlaca);
				panelFactura.remove(lblHoraEntrada);
				panelFactura.remove(lblHoraSalida);
				panelFactura.remove(lblTiempominutos);
				panelFactura.remove(lblPrecioTotal);
				panelFactura.remove(lblDineroIngresado);
				panelFactura.remove(textFieldDinero);
				panelFactura.remove(btnRealizarPago);
				panelFactura.remove(buttonBackFactura);
				remove(panelFactura);
				
				payCars(pm.getVehicles());
				}
				});
		
		btnRealizarPago.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				int monto=Integer.parseInt(textFieldDinero.getText());
				int total=v.getPrice(segundos);
				if(monto>=total) {
				panelFactura.remove(buttonBackFactura);
				panelFactura.remove(lblPagoParking);
				panelFactura.remove(lblTipoVehiculo);
				panelFactura.remove(lblPlaca);
				panelFactura.remove(lblHoraEntrada);
				panelFactura.remove(lblHoraSalida);
				panelFactura.remove(lblTiempominutos);
				panelFactura.remove(lblPrecioTotal);
				panelFactura.remove(lblDineroIngresado);
				panelFactura.remove(textFieldDinero);
				panelFactura.remove(btnRealizarPago);
				panelFactura.remove(buttonBackFactura);
				remove(panelFactura);
				JOptionPane.showMessageDialog(null, "Pago realizado con �xito, su cambio es: "+(monto-total));
				pm.deleteVehicle(v.getPlaca());
				showPanelMenu();
				}else {
				panelFactura.remove(buttonBackFactura);
				panelFactura.remove(lblPagoParking);
				panelFactura.remove(lblTipoVehiculo);
				panelFactura.remove(lblPlaca);
				panelFactura.remove(lblHoraEntrada);
				panelFactura.remove(lblHoraSalida);
				panelFactura.remove(lblTiempominutos);
				panelFactura.remove(lblPrecioTotal);
				panelFactura.remove(lblDineroIngresado);
				panelFactura.remove(textFieldDinero);
				panelFactura.remove(btnRealizarPago);
				panelFactura.remove(buttonBackFactura);
				remove(panelFactura);
				JOptionPane.showMessageDialog(null, "Dinero Insufusciente");
				facturaN(v);
				}
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
		
		}
	
	private void facturaCF(Vehicle v, Cliente_Parking cp) {
		
		JLabel lblPagoParkingFrecuente = new JLabel("Pago Parking Frecuente");
		lblPagoParkingFrecuente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPagoParkingFrecuente = new GridBagConstraints();
		gbc_lblPagoParkingFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagoParkingFrecuente.gridx = 3;
		gbc_lblPagoParkingFrecuente.gridy = 0;
		this.panelFacturaFrecuente.add(lblPagoParkingFrecuente, gbc_lblPagoParkingFrecuente);
		
		JLabel lblPuntosClienteFrecuente = new JLabel("Puntos Cliente:"+ cp.getPuntos());
		GridBagConstraints gbc_lblPuntosClienteFrecuente = new GridBagConstraints();
		gbc_lblPuntosClienteFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntosClienteFrecuente.gridx = 1;
		gbc_lblPuntosClienteFrecuente.gridy = 2;
		this.panelFacturaFrecuente.add(lblPuntosClienteFrecuente, gbc_lblPuntosClienteFrecuente);
		
		JLabel lblTipoVehiculoFrecuente = new JLabel("Tipo Veh�culo: "+v.getNameClass());
		GridBagConstraints gbc_lblTipoVehiculoFrecuente = new GridBagConstraints();
		gbc_lblTipoVehiculoFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoVehiculoFrecuente.gridx = 1;
		gbc_lblTipoVehiculoFrecuente.gridy = 4;
		this.panelFacturaFrecuente.add(lblTipoVehiculoFrecuente, gbc_lblTipoVehiculoFrecuente);
		
		JLabel lblPlacaFrecuente = new JLabel("Placa: "+ v.getPlaca());
		GridBagConstraints gbc_lblPlacaFrecuente = new GridBagConstraints();
		gbc_lblPlacaFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlacaFrecuente.gridx = 1;
		gbc_lblPlacaFrecuente.gridy = 6;
		this.panelFacturaFrecuente.add(lblPlacaFrecuente, gbc_lblPlacaFrecuente);
		
		
		LocalDateTime localDateE = pm.getVehicles().get(v);
		int hoursE  = localDateE.getHour();
		int minutesE = localDateE.getMinute();
		int secondsE = localDateE.getSecond();
		String horaFacturaE = (""+ hoursE+":"+minutesE+":"+secondsE);
		JLabel lblHoraEntradaFrecuente = new JLabel("Hora Entrada: "+ horaFacturaE);
		GridBagConstraints gbc_lblHoraEntradaFrecuente = new GridBagConstraints();
		gbc_lblHoraEntradaFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraEntradaFrecuente.gridx = 1;
		gbc_lblHoraEntradaFrecuente.gridy = 8;
		this.panelFacturaFrecuente.add(lblHoraEntradaFrecuente, gbc_lblHoraEntradaFrecuente);
		
		LocalDateTime localDate = LocalDateTime.now();
		int hours  = localDate.getHour();
		int minutes = localDate.getMinute();
		int seconds = localDate.getSecond();
		String horaFacturaC = (""+ hours+":"+minutes+":"+seconds);
		JLabel lblHoraSalidaFrecuente = new JLabel("Hora Salida: "+ horaFacturaC);
		GridBagConstraints gbc_lblHoraSalidaFrecuente = new GridBagConstraints();
		gbc_lblHoraSalidaFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraSalidaFrecuente.gridx = 1;
		gbc_lblHoraSalidaFrecuente.gridy = 10;
		this.panelFacturaFrecuente.add(lblHoraSalidaFrecuente, gbc_lblHoraSalidaFrecuente);
		
		int secdif=0;
		if(seconds>=secondsE) {
			secdif=seconds-secondsE;
		}else {
			secdif=60-secondsE;
		}
		int segundos=(hours-hoursE)*60*60+(minutes-minutesE)*60+secdif;

		JLabel lblTiempominutosFrecuente = new JLabel("Tiempo(Minutos): "+ segundos);
		GridBagConstraints gbc_lblTiempominutosFrecuente = new GridBagConstraints();
		gbc_lblTiempominutosFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblTiempominutosFrecuente.gridx = 1;
		gbc_lblTiempominutosFrecuente.gridy = 12;
		this.panelFacturaFrecuente.add(lblTiempominutosFrecuente, gbc_lblTiempominutosFrecuente);
		
		JLabel lblPrecioTotalFrecuente = new JLabel("Precio Total: "+ v.getPrice(segundos));
		GridBagConstraints gbc_lblPrecioTotalFrecuente = new GridBagConstraints();
		gbc_lblPrecioTotalFrecuente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioTotalFrecuente.gridx = 1;
		gbc_lblPrecioTotalFrecuente.gridy = 14;
		this.panelFacturaFrecuente.add(lblPrecioTotalFrecuente, gbc_lblPrecioTotalFrecuente);
	
		JLabel lblRedencionPuntos = new JLabel("Redenci�n Puntos");
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
		
		JLabel lblNumeroARedimir = new JLabel("N�mero a redimir");
		GridBagConstraints gbc_lblNumeroARedimir = new GridBagConstraints();
		gbc_lblNumeroARedimir.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroARedimir.gridx = 1;
		gbc_lblNumeroARedimir.gridy = 18;
		this.panelFacturaFrecuente.add(lblNumeroARedimir, gbc_lblNumeroARedimir);
		
		JFormattedTextField formattedTextFieldPuntos = new JFormattedTextField("0");
		GridBagConstraints gbc_formattedTextFieldPuntos = new GridBagConstraints();
		gbc_formattedTextFieldPuntos.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldPuntos.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldPuntos.gridx = 4;
		gbc_formattedTextFieldPuntos.gridy = 18;
		this.panelFacturaFrecuente.add(formattedTextFieldPuntos, gbc_formattedTextFieldPuntos);
		
		int desc=Integer.parseInt(formattedTextFieldPuntos.getText());
		JLabel lblDescuento = new JLabel("Descuento: "+ desc*50);
		GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
		gbc_lblDescuento.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescuento.gridx = 1;
		gbc_lblDescuento.gridy = 20;
		this.panelFacturaFrecuente.add(lblDescuento, gbc_lblDescuento);
		
		JLabel lblDineroIngresadoFrecuente = new JLabel("Dinero ingresado: ");
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
		
		this.add(this.panelFacturaFrecuente);
		this.pack();		
		//listeners
		btnRealizarPagoFrecuente.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				int puntTrans=segundos;
				int punt=Integer.parseInt(formattedTextFieldPuntos.getText());
				int nuevosPuntos=puntTrans-punt;
				int monto=Integer.parseInt(textFieldDineroFrecuente.getText());
				int total=v.getPrice(segundos);
				
				if(punt<=cp.getPuntos() && monto>=total) {
				panelFacturaFrecuente.remove(lblPagoParkingFrecuente);
				panelFacturaFrecuente.remove(lblPuntosClienteFrecuente);
				panelFacturaFrecuente.remove(lblTipoVehiculoFrecuente);
				panelFacturaFrecuente.remove(lblPlacaFrecuente);
				panelFacturaFrecuente.remove(lblHoraEntradaFrecuente);
				panelFacturaFrecuente.remove(lblHoraSalidaFrecuente);
				panelFacturaFrecuente.remove(lblTiempominutosFrecuente);
				panelFacturaFrecuente.remove(lblPrecioTotalFrecuente);
				panelFacturaFrecuente.remove(lblRedencionPuntos);
				panelFacturaFrecuente.remove(rdbtnRadioButton);
				panelFacturaFrecuente.remove(lblNumeroARedimir);
				panelFacturaFrecuente.remove(formattedTextFieldPuntos);
				panelFacturaFrecuente.remove(lblDescuento);
				panelFacturaFrecuente.remove(lblDineroIngresadoFrecuente);
				panelFacturaFrecuente.remove(textFieldDineroFrecuente);
				panelFacturaFrecuente.remove(btnRealizarPagoFrecuente);
				panelFacturaFrecuente.remove(buttonBackFactura);
				
				remove(panelFacturaFrecuente);
				cp.setPuntos(nuevosPuntos);
				JOptionPane.showMessageDialog(null, "Pago realizado con �xito, su cambio es: "+(monto-total));				
				pm.deleteVehicle(v.getPlaca());
				showPanelMenu();
				}
				
				if(punt>cp.getPuntos()) {
				panelFacturaFrecuente.remove(lblPagoParkingFrecuente);
				panelFacturaFrecuente.remove(lblPuntosClienteFrecuente);
				panelFacturaFrecuente.remove(lblTipoVehiculoFrecuente);
				panelFacturaFrecuente.remove(lblPlacaFrecuente);
				panelFacturaFrecuente.remove(lblHoraEntradaFrecuente);
				panelFacturaFrecuente.remove(lblHoraSalidaFrecuente);
				panelFacturaFrecuente.remove(lblTiempominutosFrecuente);
				panelFacturaFrecuente.remove(lblPrecioTotalFrecuente);
				panelFacturaFrecuente.remove(lblRedencionPuntos);
				panelFacturaFrecuente.remove(rdbtnRadioButton);
				panelFacturaFrecuente.remove(lblNumeroARedimir);
				panelFacturaFrecuente.remove(formattedTextFieldPuntos);
				panelFacturaFrecuente.remove(lblDescuento);
				panelFacturaFrecuente.remove(lblDineroIngresadoFrecuente);
				panelFacturaFrecuente.remove(textFieldDineroFrecuente);
				panelFacturaFrecuente.remove(btnRealizarPagoFrecuente);
				panelFacturaFrecuente.remove(buttonBackFactura);
					remove(panelFacturaFrecuente);
					JOptionPane.showMessageDialog(null, "Datos incorrectos. Intente nuevamente");
					facturaCF(v,cp);
				}
				
				if(monto<total) {
					{
						panelFacturaFrecuente.remove(lblPagoParkingFrecuente);
						panelFacturaFrecuente.remove(lblPuntosClienteFrecuente);
						panelFacturaFrecuente.remove(lblTipoVehiculoFrecuente);
						panelFacturaFrecuente.remove(lblPlacaFrecuente);
						panelFacturaFrecuente.remove(lblHoraEntradaFrecuente);
						panelFacturaFrecuente.remove(lblHoraSalidaFrecuente);
						panelFacturaFrecuente.remove(lblTiempominutosFrecuente);
						panelFacturaFrecuente.remove(lblPrecioTotalFrecuente);
						panelFacturaFrecuente.remove(lblRedencionPuntos);
						panelFacturaFrecuente.remove(rdbtnRadioButton);
						panelFacturaFrecuente.remove(lblNumeroARedimir);
						panelFacturaFrecuente.remove(formattedTextFieldPuntos);
						panelFacturaFrecuente.remove(lblDescuento);
						panelFacturaFrecuente.remove(lblDineroIngresadoFrecuente);
						panelFacturaFrecuente.remove(textFieldDineroFrecuente);
						panelFacturaFrecuente.remove(btnRealizarPagoFrecuente);
						panelFacturaFrecuente.remove(buttonBackFactura);
						remove(panelFacturaFrecuente);
						JOptionPane.showMessageDialog(null, "Dinero Insufusciente");
						facturaCF(v,cp);
						}
				}
				
			}
			
		});
		
		buttonBackFactura.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				panelFacturaFrecuente.remove(lblPagoParkingFrecuente);
				panelFacturaFrecuente.remove(lblPuntosClienteFrecuente);
				panelFacturaFrecuente.remove(lblTipoVehiculoFrecuente);
				panelFacturaFrecuente.remove(lblPlacaFrecuente);
				panelFacturaFrecuente.remove(lblHoraEntradaFrecuente);
				panelFacturaFrecuente.remove(lblHoraSalidaFrecuente);
				panelFacturaFrecuente.remove(lblTiempominutosFrecuente);
				panelFacturaFrecuente.remove(lblPrecioTotalFrecuente);
				panelFacturaFrecuente.remove(lblRedencionPuntos);
				panelFacturaFrecuente.remove(rdbtnRadioButton);
				panelFacturaFrecuente.remove(lblNumeroARedimir);
				panelFacturaFrecuente.remove(formattedTextFieldPuntos);
				panelFacturaFrecuente.remove(lblDescuento);
				panelFacturaFrecuente.remove(lblDineroIngresadoFrecuente);
				panelFacturaFrecuente.remove(textFieldDineroFrecuente);
				panelFacturaFrecuente.remove(btnRealizarPagoFrecuente);
				panelFacturaFrecuente.remove(buttonBackFactura);
				remove(panelFacturaFrecuente);
				//showPanelPagos();
				payCars(pm.getVehicles());
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
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 5;
		this.panelRegistro.add(lblApellido, gbc_lblApellido);
		
		JTextField textFieldApellido = new JTextField();
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellido.gridx = 3;
		gbc_textFieldApellido.gridy = 5;
		this.panelRegistro.add(textFieldApellido, gbc_textFieldApellido);
		textFieldApellido.setColumns(10);
		
		
		JLabel lblPlacaVehculo = new JLabel("Placa Veh\u00EDculo");
		GridBagConstraints gbc_lblPlacaVehculo = new GridBagConstraints();
		gbc_lblPlacaVehculo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlacaVehculo.gridx = 1;
		gbc_lblPlacaVehculo.gridy = 7;
		this.panelRegistro.add(lblPlacaVehculo, gbc_lblPlacaVehculo);
		
		MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("UUU-###");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JFormattedTextField textFieldPlacaVehiculo = new JFormattedTextField(mask);
		GridBagConstraints gbc_textFieldPlacaVehiculo = new GridBagConstraints();
		gbc_textFieldPlacaVehiculo.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPlacaVehiculo.gridx = 3;
		gbc_textFieldPlacaVehiculo.gridy = 7;
		this.panelRegistro.add(textFieldPlacaVehiculo, gbc_textFieldPlacaVehiculo);
		textFieldPlacaVehiculo.setColumns(10);
		
		JLabel lblNmeroDeCdula = new JLabel("N\u00FAmero de C\u00E9dula");
		GridBagConstraints gbc_lblNmeroDeCdula = new GridBagConstraints();
		gbc_lblNmeroDeCdula.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroDeCdula.gridx = 1;
		gbc_lblNmeroDeCdula.gridy = 9;
		this.panelRegistro.add(lblNmeroDeCdula, gbc_lblNmeroDeCdula);
		
		JTextField textFieldCC = new JTextField();
		GridBagConstraints gbc_textFieldCC = new GridBagConstraints();
		gbc_textFieldCC.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCC.gridx = 3;
		gbc_textFieldCC.gridy = 9;
		this.panelRegistro.add(textFieldCC, gbc_textFieldCC);
		textFieldCC.setColumns(10);
		
		JButton btnRegistro = new JButton("Registrar");
		GridBagConstraints gbc_btnRegistro = new GridBagConstraints();
		gbc_btnRegistro.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistro.gridx = 2;
		gbc_btnRegistro.gridy = 11;
		this.panelRegistro.add(btnRegistro, gbc_btnRegistro);
		
		JButton btnVerClientes = new JButton("Ver clientes");
		GridBagConstraints gbc_btnVerClientes = new GridBagConstraints();
		gbc_btnVerClientes.insets = new Insets(0, 0, 0, 5);
		gbc_btnVerClientes.gridx = 2;
		gbc_btnVerClientes.gridy = 13;
		this.panelRegistro.add(btnVerClientes, gbc_btnVerClientes);
		
		//listeners
				buttonBack.addActionListener(new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						remove(panelRegistro);
						showPanelMenu();
						}
						});
				btnRegistro.addActionListener(new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						Cliente_Parking c=new Cliente_Parking(textFieldCC.getText(),textFieldNombre.getText(),textFieldApellido.getText(),0,textFieldPlacaVehiculo.getText());
						remove(panelRegistro);
						textFieldNombre.setText("");
						textFieldPlacaVehiculo.setText("");	
						textFieldCC.setText("");
						textFieldApellido.setText("");
						cm.addCliente(c);
						JOptionPane.showMessageDialog(null, "El usuario ha sido registrado correctamente");
						remove(panelIngreso);
						showPanelMenu();
							}
						});	
						
				btnVerClientes.addActionListener(new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						remove(panelRegistro);
						showClients(cm.getClientes());
						}
						});
		

	}
	
	private void setupPanelClientes() {
		this.panelClientes = new JPanel();
		GridBagLayout gridBagLayoutClientes = new GridBagLayout();
		gridBagLayoutClientes.columnWidths = new int[]{0, 30, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutClientes.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutClientes.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayoutClientes.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panelClientes.setLayout(gridBagLayoutClientes);
		
		//final JTable  tablePagos;
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblClientes = new GridBagConstraints();
		gbc_lblClientes.insets = new Insets(0, 0, 5, 5);
		gbc_lblClientes.gridx = 5;
		gbc_lblClientes.gridy = 1;
		this.panelClientes.add(lblClientes, gbc_lblClientes);
	}
	
	public void showClients(TreeSet<Cliente_Parking> tablaclientes) {
		final JTable  tableClientes;
		JScrollPane scrollPaneClientes = new JScrollPane();
		JButton buttonBackClientes = new JButton("<-");
		JLabel lblNoAutoClientes = new JLabel("No hay clientes");
		
		GridBagConstraints gbc_buttonBackClientes = new GridBagConstraints();
		gbc_buttonBackClientes.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBackClientes.gridx = 0;
		gbc_buttonBackClientes.gridy = 0;
		this.panelClientes.add(buttonBackClientes, gbc_buttonBackClientes);
		
		
		if(tablaclientes.size()>0) {
		GridBagConstraints gbc_scrollPaneClientes = new GridBagConstraints();
		gbc_scrollPaneClientes.gridwidth = 7;
		gbc_scrollPaneClientes.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneClientes.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneClientes.gridx = 1;
		gbc_scrollPaneClientes.gridy = 4;
		this.panelClientes.add(scrollPaneClientes, gbc_scrollPaneClientes);
		
		 Object[][] rows = new Object[tablaclientes.size()][4];
		 String[] cabeza={"Nombre", "Apellido", "N�mero de c�dula", "Placa"};
		 int i=0;
			 
		 for(Cliente_Parking c: tablaclientes) {
			 	rows[i][0]=c.getNombre();
				rows[i][1]=c.getApellido();
				rows[i][2]=c.getCedula();
				rows[i][3]=c.getPlaca();
				i++;
		 }
		 
		tableClientes = new JTable(rows,cabeza);
		scrollPaneClientes.setViewportView(tableClientes);
		}else {
			
			lblNoAutoClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblClientes = new GridBagConstraints();
			gbc_lblClientes.insets = new Insets(0, 0, 5, 5);
			gbc_lblClientes.gridx = 5;
			gbc_lblClientes.gridy = 5;
			this.panelClientes.add(lblNoAutoClientes, gbc_lblClientes);
		}
		
		this.add(this.panelClientes);
		this.pack();
		
				//listeners
		buttonBackClientes.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				panelClientes.remove(buttonBackClientes);
				panelClientes.remove(scrollPaneClientes);
				panelClientes.remove(lblNoAutoClientes);
				
				remove(panelClientes);
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
	/*public void showPanelFactura() {
		this.add(this.panelFactura);
		this.pack();
	}*/
	public void showPanelFacturaFrecuente() {
		this.add(this.panelFacturaFrecuente);
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
	/*public void showPanelClientes() {
		this.add(this.panelClientes);
		this.pack();
	}*/
	
	
	
}
