package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import business.ParkingManager;
import data.Car;
import data.Motorcycle;
import data.Vehicle;

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
		/*this.setupPanelStats();
		this.setupPanelPrecios();
		this.setupPanelRegistro();
			*/
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
					showPanelEstado();
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
					showPanelPagos();
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
				//pm.addVehicle(v);
			showPanelMenu();
			}
			
			});
		
		comboBoxTipoV.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				//???
				showPanelMenu();
			}
			
		});
	}
	
	private void setupPanelEstado() {
		
		this.panelEstado = new JPanel();
		GridBagLayout gridBagLayoutEstado = new GridBagLayout();
		gridBagLayoutEstado.columnWidths = new int[]{0, 30, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutEstado.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutEstado.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayoutEstado.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panelEstado.setLayout(gridBagLayoutEstado);
		
		final JTable  tableEstado;
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 5;
		gbc_lblEstado.gridy = 1;
		this.panelEstado.add(lblEstado, gbc_lblEstado);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		this.panelEstado.add(scrollPane, gbc_scrollPane);
		
		tableEstado = new JTable();
		tableEstado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"# Parking", "Placa", "Tipo Vehículo", "Tiempo (minutos)"
			}
		));
		scrollPane.setViewportView(tableEstado);
		
		JButton btnVolver = new JButton("Volver");
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.insets = new Insets(0, 0, 5, 5);
		gbc_btnVolver.gridx = 5;
		gbc_btnVolver.gridy = 10;
		this.panelEstado.add(btnVolver, gbc_btnVolver);
		
		//listeners
		btnVolver.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
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
		
		final JTable  tablePagos;
		JLabel lblPagos = new JLabel("Pagos");
		lblPagos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPagos = new GridBagConstraints();
		gbc_lblPagos.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagos.gridx = 5;
		gbc_lblPagos.gridy = 1;
		this.panelPagos.add(lblPagos, gbc_lblPagos);
		
		JScrollPane scrollPanePagos = new JScrollPane();
		GridBagConstraints gbc_scrollPanePagos = new GridBagConstraints();
		gbc_scrollPanePagos.gridwidth = 7;
		gbc_scrollPanePagos.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPanePagos.fill = GridBagConstraints.BOTH;
		gbc_scrollPanePagos.gridx = 1;
		gbc_scrollPanePagos.gridy = 4;
		this.panelPagos.add(scrollPanePagos, gbc_scrollPanePagos);
		
		tablePagos = new JTable();
		tablePagos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"# Parking", "Placa", "Tipo Vehículo", "Tiempo (minutos)"
			}
		));
		scrollPanePagos.setViewportView(tablePagos);
		
		JButton btnPagar = new JButton("Pagar");
		GridBagConstraints gbc_btnPagar = new GridBagConstraints();
		gbc_btnPagar.insets = new Insets(0, 0, 5, 5);
		gbc_btnPagar.gridx = 5;
		gbc_btnPagar.gridy = 10;
		this.panelPagos.add(btnPagar, gbc_btnPagar);
		
		//listeners
		btnPagar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				remove(panelPagos);
				showPanelFactura();
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
		gbc_textFieldDinero.gridx = 3;
		gbc_textFieldDinero.gridy = 14;
		this.panelFactura.add(textFieldDinero, gbc_textFieldDinero);
		textFieldDinero.setColumns(10);
		
		JButton btnRealizarPago = new JButton("Realizar Pago");
		GridBagConstraints gbc_btnRealizarPago = new GridBagConstraints();
		gbc_btnRealizarPago.insets = new Insets(0, 0, 0, 5);
		gbc_btnRealizarPago.gridx = 3;
		gbc_btnRealizarPago.gridy = 16;
		this.panelFactura.add(btnRealizarPago, gbc_btnRealizarPago);
		
		JButton btnVolverPago = new JButton("Volver");
		GridBagConstraints gbc_btnVolverPago = new GridBagConstraints();
		gbc_btnVolverPago.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolverPago.gridx = 4;
		gbc_btnVolverPago.gridy = 16;
		this.panelFactura.add(btnVolverPago, gbc_btnVolverPago);
		
		//listeners
				btnRealizarPago.addActionListener(new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						remove(panelFactura);
						showPanelPagos();
					}
					});
				btnVolverPago.addActionListener(new ActionListener () {
					public void actionPerformed (ActionEvent e) {
						remove(panelFactura);
						showPanelPagos();
					}
					});
		
		

	}
	
	
	public void showPanelMenu() {
		this.add(this.panelMenu);
		this.pack();
	}
	
	public void showPanelIngreso() {
		this.add(this.panelIngreso);
		this.pack();
	}
	
	public void showPanelEstado() {
		this.add(this.panelEstado);
		this.pack();
	}
	public void showPanelPagos() {
		this.add(this.panelPagos);
		this.pack();
	}
	public void showPanelFactura() {
		this.add(this.panelFactura);
		this.pack();
	}
	
	
	
}
