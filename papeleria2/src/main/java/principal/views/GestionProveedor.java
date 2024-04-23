package principal.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import principal.controllers.ControladorProveedores;
import principal.entities.Proveedor;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionProveedor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField jtfId;
	private JTextField jtfCif;
	private JTextField jtfFechaAlta;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JCheckBox chkbxActivo;
	JRadioButton rdbtnExento;
	JRadioButton rdbtn10;
	JRadioButton rdbtn4;
	JRadioButton rdbtn21;
	private JComboBox jcbNacionalidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			GestionProveedor dialog = new GestionProveedor(p);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionProveedor(Proveedor p) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JButton btnNewButton = new JButton("Guardar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guardar();
				}
			});
			btnNewButton.setIcon(new ImageIcon(GestionProveedor.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/guardar.png")));
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 0;
			gbc_btnNewButton.gridy = 0;
			contentPanel.add(btnNewButton, gbc_btnNewButton);
		}
		{
			JLabel lblNewLabel = new JLabel("Gestion del Proveedor");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Id:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			jtfId = new JTextField();
			GridBagConstraints gbc_jtfId = new GridBagConstraints();
			gbc_jtfId.insets = new Insets(0, 0, 5, 5);
			gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtfId.gridx = 1;
			gbc_jtfId.gridy = 2;
			contentPanel.add(jtfId, gbc_jtfId);
			jtfId.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Cif:");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			jtfCif = new JTextField();
			GridBagConstraints gbc_jtfCif = new GridBagConstraints();
			gbc_jtfCif.insets = new Insets(0, 0, 5, 5);
			gbc_jtfCif.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtfCif.gridx = 1;
			gbc_jtfCif.gridy = 3;
			contentPanel.add(jtfCif, gbc_jtfCif);
			jtfCif.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Nacionalidad:");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 4;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			jcbNacionalidad = new JComboBox();
			GridBagConstraints gbc_jcbNacionalidad = new GridBagConstraints();
			gbc_jcbNacionalidad.insets = new Insets(0, 0, 5, 5);
			gbc_jcbNacionalidad.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcbNacionalidad.gridx = 1;
			gbc_jcbNacionalidad.gridy = 4;
			contentPanel.add(jcbNacionalidad, gbc_jcbNacionalidad);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Activo:");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 5;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			 chkbxActivo = new JCheckBox("");
			GridBagConstraints gbc_chkbxActivo = new GridBagConstraints();
			gbc_chkbxActivo.insets = new Insets(0, 0, 5, 5);
			gbc_chkbxActivo.gridx = 1;
			gbc_chkbxActivo.gridy = 5;
			contentPanel.add(chkbxActivo, gbc_chkbxActivo);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Fecha de Alta:");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 0;
			gbc_lblNewLabel_5.gridy = 6;
			contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			jtfFechaAlta = new JTextField();
			GridBagConstraints gbc_jtfFechaAlta = new GridBagConstraints();
			gbc_jtfFechaAlta.insets = new Insets(0, 0, 5, 5);
			gbc_jtfFechaAlta.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtfFechaAlta.gridx = 1;
			gbc_jtfFechaAlta.gridy = 6;
			contentPanel.add(jtfFechaAlta, gbc_jtfFechaAlta);
			jtfFechaAlta.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Tipo de Iva:");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 0;
			gbc_lblNewLabel_6.gridy = 7;
			contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			 rdbtnExento = new JRadioButton("Exento");
			buttonGroup.add(rdbtnExento);
			GridBagConstraints gbc_rdbtnExento = new GridBagConstraints();
			gbc_rdbtnExento.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnExento.gridx = 1;
			gbc_rdbtnExento.gridy = 7;
			contentPanel.add(rdbtnExento, gbc_rdbtnExento);
		}
		{
			 rdbtn10 = new JRadioButton("10%");
			buttonGroup.add(rdbtn10);
			GridBagConstraints gbc_rdbtn10 = new GridBagConstraints();
			gbc_rdbtn10.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtn10.gridx = 2;
			gbc_rdbtn10.gridy = 7;
			contentPanel.add(rdbtn10, gbc_rdbtn10);
		}
		{
			 rdbtn4 = new JRadioButton("4%");
			buttonGroup.add(rdbtn4);
			GridBagConstraints gbc_rdbtn4 = new GridBagConstraints();
			gbc_rdbtn4.insets = new Insets(0, 0, 0, 5);
			gbc_rdbtn4.gridx = 1;
			gbc_rdbtn4.gridy = 8;
			contentPanel.add(rdbtn4, gbc_rdbtn4);
		}
		{
			 rdbtn21 = new JRadioButton("21%");
			buttonGroup.add(rdbtn21);
			GridBagConstraints gbc_rdbtn21 = new GridBagConstraints();
			gbc_rdbtn21.gridx = 2;
			gbc_rdbtn21.gridy = 8;
			contentPanel.add(rdbtn21, gbc_rdbtn21);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarDatos(p);
		cargarNacionalidades();
	}
	
	public static String dateToString(Date fecha) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    return sdf.format(fecha);
	}
	

	private void cargarDatos(Proveedor p) {
		this.jtfId.setText(String.valueOf(p.getId()));
		this.jtfCif.setText(p.getCif());
		this.jtfFechaAlta.setText(dateToString(p.getFechaAlta()));
		if (p.isActivo()) {
			this.chkbxActivo.setSelected(true);
		}
		else {
			this.chkbxActivo.setSelected(false);
		}
		
		if (p.getIva() == 0) {
			this.rdbtnExento.setSelected(true);
		}
		if (p.getIva() == 4) {
			this.rdbtn4.setSelected(true);
		}
		if (p.getIva() == 10 ) {
			this.rdbtn10.setSelected(true);
		}
		if (p.getIva() == 21) {
			this.rdbtn21.setSelected(true);
		}
		
		for (int i = 0; i < this.jcbNacionalidad.getItemCount(); i++) {
			if (p.getNacionalidad() == String.valueOf(this.jcbNacionalidad.getItemAt(i)))  {
				this.jcbNacionalidad.setSelectedIndex(i);
				
			}
		}
	
		
	}
	
	public static boolean tieneFormatoFecha(String texto) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false); // Esto hace que la validación sea estricta

	    try {
	        Date fecha = sdf.parse(texto);
	        return true; // Si la cadena se puede parsear como fecha, entonces tiene el formato correcto
	    } catch (ParseException e) {
	        return false; // Si hay una excepción al parsear, significa que no tiene el formato correcto
	    }
	}
	
	public static Date deStringADate(String texto) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 
	    try {
	        Date fecha = sdf.parse(texto);
	        return fecha; // Si la cadena se puede parsear como fecha, entonces tiene el formato correcto
	    } catch (ParseException e) {
	    	JOptionPane.showMessageDialog(null, "Error, la fecha no tiene un formato valido");
	        return null; // Si hay una excepción al parsear, significa que no tiene el formato correcto
	    }
	}
	
	
	private void cargarNacionalidades() {

		this.jcbNacionalidad.addItem("España");
		this.jcbNacionalidad.addItem("Extranjero");
	}
	
	private void guardar() {
		
		Proveedor p = ControladorProveedores.findArtById(Integer.parseInt(this.jtfId.getText()));
		
		if (tieneFormatoFecha(this.jtfFechaAlta.getText())) {
			if (this.chkbxActivo.isSelected()) {
				p.setActivo(true);
			}
			else {
				p.setActivo(false);
			}
			p.setCif(this.jtfCif.getText());
			if (rdbtn10.isSelected()) {
				p.setIva(10);
			}
			if (rdbtn4.isSelected()) {
				p.setIva(4);
			}
			if (rdbtn21.isSelected()) {
				p.setIva(21);
			}
			if (rdbtnExento.isSelected()) {
				p.setIva(0);
			}
			
			p.setNacionalidad(String.valueOf(this.jcbNacionalidad.getSelectedItem()));
			p.setFechaAlta(deStringADate(this.jtfFechaAlta.getText()));
			
			
			ControladorProveedores.update(p);
			JOptionPane.showMessageDialog(null, "Registro modificado con éxito");
		}
		
		
		
		
		
	}
	
	

}
