package principal.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import principal.controllers.ControladorArticulo;
import principal.controllers.ControladorProveedores;
import principal.entities.Articulo;
import principal.entities.Proveedor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class GestionArticulo extends JPanel {

	private static final long serialVersionUID = 1L;
	private static GestionArticulo instance = null;
	private JTextField jtfId;
	private JTextField jtfCodigo;
	private JTextField jtfDescripcion;
	private JTextField jtfUnidades;
	private JTextField jtfPrecio;
	private JTextField jtfColor;
	private JButton btnPrimero;
	JComboBox<Proveedor> jcbProveedor;
	JColorChooser jColorChooser;

	public static GestionArticulo getInstance() {
		if (instance == null) {
			instance = new GestionArticulo();
		}
		return instance;
	}

	/**
	 * Create the panel.
	 */
	public GestionArticulo() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Gestion De Articulos");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 9;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		btnPrimero.setIcon(new ImageIcon(
				GestionArticulo.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotostart.png")));
		GridBagConstraints gbc_btnPrimero = new GridBagConstraints();
		gbc_btnPrimero.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrimero.gridx = 1;
		gbc_btnPrimero.gridy = 1;
		add(btnPrimero, gbc_btnPrimero);

		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnterior();
			}
		});
		btnAnterior.setIcon(
				new ImageIcon(GestionArticulo.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/previous.png")));
		GridBagConstraints gbc_btnAnterior = new GridBagConstraints();
		gbc_btnAnterior.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnterior.gridx = 2;
		gbc_btnAnterior.gridy = 1;
		add(btnAnterior, gbc_btnAnterior);

		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSiguiente();
			}
		});
		btnSiguiente.setIcon(
				new ImageIcon(GestionArticulo.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/next.png")));
		GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
		gbc_btnSiguiente.insets = new Insets(0, 0, 5, 5);
		gbc_btnSiguiente.gridx = 3;
		gbc_btnSiguiente.gridy = 1;
		add(btnSiguiente, gbc_btnSiguiente);

		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUltimo();
			}
		});
		btnUltimo.setIcon(
				new ImageIcon(GestionArticulo.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotoend.png")));
		GridBagConstraints gbc_btnUltimo = new GridBagConstraints();
		gbc_btnUltimo.insets = new Insets(0, 0, 5, 5);
		gbc_btnUltimo.gridx = 4;
		gbc_btnUltimo.gridy = 1;
		add(btnUltimo, gbc_btnUltimo);

		JButton btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		btnNuevo.setIcon(
				new ImageIcon(GestionArticulo.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/nuevo.png")));
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevo.gridx = 5;
		gbc_btnNuevo.gridy = 1;
		add(btnNuevo, gbc_btnNuevo);

		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setIcon(
				new ImageIcon(GestionArticulo.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/guardar.png")));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 6;
		gbc_btnGuardar.gridy = 1;
		add(btnGuardar, gbc_btnGuardar);

		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(
				new ImageIcon(GestionArticulo.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/eliminar.png")));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 7;
		gbc_btnEliminar.gridy = 1;
		add(btnEliminar, gbc_btnEliminar);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 7;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridy = 2;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Codigo:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfCodigo = new JTextField();
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.gridwidth = 7;
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 3;
		add(jtfCodigo, gbc_jtfCodigo);
		jtfCodigo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 7;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 4;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Unidades en Stock:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfUnidades = new JTextField();
		GridBagConstraints gbc_jtfUnidades = new GridBagConstraints();
		gbc_jtfUnidades.gridwidth = 7;
		gbc_jtfUnidades.insets = new Insets(0, 0, 5, 5);
		gbc_jtfUnidades.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUnidades.gridx = 1;
		gbc_jtfUnidades.gridy = 5;
		add(jtfUnidades, gbc_jtfUnidades);
		jtfUnidades.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Precio:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfPrecio = new JTextField();
		GridBagConstraints gbc_jtfPrecio = new GridBagConstraints();
		gbc_jtfPrecio.gridwidth = 7;
		gbc_jtfPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrecio.gridx = 1;
		gbc_jtfPrecio.gridy = 6;
		add(jtfPrecio, gbc_jtfPrecio);
		jtfPrecio.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Color:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfColor = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.gridwidth = 7;
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 7;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);

		JButton btnColorPicker = new JButton("Selecciona Un Color");
		btnColorPicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
				;
			}
		});
		GridBagConstraints gbc_btnColorPicker = new GridBagConstraints();
		gbc_btnColorPicker.insets = new Insets(0, 0, 5, 5);
		gbc_btnColorPicker.gridx = 8;
		gbc_btnColorPicker.gridy = 7;
		add(btnColorPicker, gbc_btnColorPicker);

		JLabel lblNewLabel_7 = new JLabel("Proveedor:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		jcbProveedor = new JComboBox<Proveedor>();
		GridBagConstraints gbc_jcbProveedor = new GridBagConstraints();
		gbc_jcbProveedor.gridwidth = 7;
		gbc_jcbProveedor.insets = new Insets(0, 0, 0, 5);
		gbc_jcbProveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProveedor.gridx = 1;
		gbc_jcbProveedor.gridy = 8;
		add(jcbProveedor, gbc_jcbProveedor);
		
		JButton btnGestionProveedor = new JButton("Gestión Proveedor");
		btnGestionProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionProveedor();
			}
		});
		GridBagConstraints gbc_btnGestionProveedor = new GridBagConstraints();
		gbc_btnGestionProveedor.insets = new Insets(0, 0, 0, 5);
		gbc_btnGestionProveedor.gridx = 8;
		gbc_btnGestionProveedor.gridy = 8;
		add(btnGestionProveedor, gbc_btnGestionProveedor);
		cargarPrimero();
		cargarPProveedores();

	}
	
	private void gestionProveedor() {
		Proveedor p = (Proveedor) this.jcbProveedor.getSelectedItem();
		GestionProveedor gp = new GestionProveedor(p);
		gp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		gp.setVisible(true);
	}
	
	
	
	
	public  boolean esPrecioFloat() {
	    try {
	        Float.parseFloat(this.jtfPrecio.getText());
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	public boolean esStockValido() {
	
		try {
			Integer.parseInt(this.jtfUnidades.getText());
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
		
	}
	
	
	
	
	private void guardar() {
		if (this.jtfId.getText().isEmpty()) {
			if (isCodigoValido()) {
				if (esPrecioFloat()) {
					if (esStockValido()) {
						Articulo o = new Articulo();
						Proveedor p = (Proveedor) this.jcbProveedor.getSelectedItem();
						o.setCodigo(this.jtfCodigo.getText());
						o.setColor(this.jtfColor.getText());
						o.setDescripcion(this.jtfDescripcion.getText());
						o.setStock(Integer.valueOf(this.jtfUnidades.getText()));
						o.setPrecio(Float.valueOf(this.jtfPrecio.getText()));
						o.setIdProveedor(p.getId());
						ControladorArticulo.insert(o);
						JOptionPane.showMessageDialog(null, "Articulo creado con éxito");
					}
					else {
						JOptionPane.showMessageDialog(null, "Error al guardar, el stock no es válido");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al guardar, el precio no es válido");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al guardar, el codigo no es válido");
			}
			
			
			
		}
		else{
			Articulo o = ControladorArticulo.findArtById(Integer.valueOf(this.jtfId.getText()));
			if (isCodigoValido()) {
				
				if (esPrecioFloat()) {
					if (esStockValido()) {
						Proveedor p = (Proveedor) this.jcbProveedor.getSelectedItem();
						o.setCodigo(this.jtfCodigo.getText());
						o.setColor(this.jtfColor.getText());
						o.setDescripcion(this.jtfDescripcion.getText());
						o.setStock(Integer.valueOf(this.jtfUnidades.getText()));
						o.setPrecio(Float.valueOf(this.jtfPrecio.getText()));
						o.setIdProveedor(p.getId());
					}
					else {
						JOptionPane.showMessageDialog(null, "Error al guardar, el stock no es valido");
					}
					
				}
				JOptionPane.showMessageDialog(null, "Error al guardar, el precio no es valido");
			}
			else {
				
			}
			
			
			
			
			
			ControladorArticulo.update(o);
			
			
			
		}
			
		
		
	}
	
	
	private void nuevo() {
		this.jtfCodigo.setText("");
		this.jtfColor.setText("");
		this.jtfId.setText("");
		this.jtfDescripcion.setText("");
		this.jtfPrecio.setText("");
		this.jtfUnidades.setText("");

	}
	
	
	
	
	

	private boolean isCodigoValido() {
		String str = this.jtfCodigo.getText();

		if (str.length() < 6) {
			return false;

		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}

		}
		return true;

	}

	private void seleccionaColor() {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.setBackground(color);

		}
	}

	private void selProveedor(Articulo o) {
		for (int i = 0; i < this.jcbProveedor.getItemCount(); i++) {
			if (this.jcbProveedor.getItemAt(i).getId() == o.getIdProveedor()) {
				this.jcbProveedor.setSelectedIndex(i);
			}
		}
	}

	private void cargarPrimero() {

		Articulo o = ControladorArticulo.getPrimero();
		if (o != null) {
			this.jtfCodigo.setText(o.getCodigo());
			this.jtfColor.setText(o.getColor());
			this.jtfId.setText(String.valueOf(o.getId()));
			this.jtfDescripcion.setText(o.getDescripcion());
			this.jtfPrecio.setText(String.valueOf(o.getPrecio()));
			this.jtfUnidades.setText(String.valueOf(o.getStock()));
			selProveedor(o);
		}

	}

	private void cargarUltimo() {
		Articulo o = ControladorArticulo.getUltimo();
		if (o != null) {
			this.jtfCodigo.setText(o.getCodigo());
			this.jtfColor.setText(o.getColor());
			this.jtfId.setText(String.valueOf(o.getId()));
			this.jtfDescripcion.setText(o.getDescripcion());
			this.jtfPrecio.setText(String.valueOf(o.getPrecio()));
			this.jtfUnidades.setText(String.valueOf(o.getStock()));
			selProveedor(o);
		}

	}

	private void cargarSiguiente() {
		Articulo o = ControladorArticulo.getSiguiente(Integer.valueOf(this.jtfId.getText()));
		if (o != null) {
			this.jtfCodigo.setText(o.getCodigo());
			this.jtfColor.setText(o.getColor());
			this.jtfId.setText(String.valueOf(o.getId()));
			this.jtfDescripcion.setText(o.getDescripcion());
			this.jtfPrecio.setText(String.valueOf(o.getPrecio()));
			this.jtfUnidades.setText(String.valueOf(o.getStock()));
			selProveedor(o);
		}

	}

	private void cargarAnterior() {

		Articulo o = ControladorArticulo.getAnterior(Integer.valueOf(this.jtfId.getText()));
		if (o != null) {
			this.jtfCodigo.setText(o.getCodigo());
			this.jtfColor.setText(o.getColor());
			this.jtfId.setText(String.valueOf(o.getId()));
			this.jtfDescripcion.setText(o.getDescripcion());
			this.jtfPrecio.setText(String.valueOf(o.getPrecio()));
			this.jtfUnidades.setText(String.valueOf(o.getStock()));
			selProveedor(o);
		}

	}

	private void cargarPProveedores() {
		List<Proveedor> l = ControladorProveedores.findAll();
		for (Proveedor proveedor : l) {
			this.jcbProveedor.addItem(proveedor);
			;
		}

	}

}
