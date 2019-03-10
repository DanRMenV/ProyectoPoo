package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Insets;
import javax.swing.JButton;

public class Estado extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Estado() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 2;
		gbc_lblEstado.gridy = 0;
		add(lblEstado, gbc_lblEstado);
		
		String[] columnNames = {"Nombre",
                "Apellido",
                "Carrera",
                "# de Matrícula	",
                "PAES?"};
		//Data is initialized and stored in a two-dimensional Object array
				Object[][] data = {
			    {"Santiago", "Suárez",
			     "Ingeniería Eléctrica	", new Integer(3), new Boolean(false)},
			    {"Juan", " Cáceres",
			     "Estadística", new Integer(4), new Boolean(true)},
			    {"Valeria", "González",
			     "Economía", new Integer(1), new Boolean(false)},
			    {"Steven", "Peña",
			     "Farmacia", new Integer(9), new Boolean(true)},
			    {"María", "Alarcón",
			     "Arquitectura", new Integer(7), new Boolean(false)}
		        };

		        //The Table is constructed using these data and columnNames
		        
		
		final JTable table;
		//data?
		table = new JTable(null, columnNames);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 2;
		gbc_table.gridy = 2;
		add(table, gbc_table);
		
		JButton btnVolver = new JButton("Volver");
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolver.gridx = 2;
		gbc_btnVolver.gridy = 3;
		add(btnVolver, gbc_btnVolver);

	}

}
