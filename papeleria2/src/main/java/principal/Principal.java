package principal;

import java.awt.Menu;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;

import principal.views.GestionArticulo;


public class Principal extends JFrame{

	static Principal instance = null;
	GestionArticulo ga = GestionArticulo.getInstance();
	

	public static Principal getInstance() {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	

	public Principal() {
		super("Gestion de Articulo");
		this.setBounds(0,0,800,600);
		this.getContentPane().add(ga);
		
		
	}
	
	


	public static void main(String[] args) {

		Principal.getInstance().setVisible(true);
		
	}

}
