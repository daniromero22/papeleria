package principal.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import principal.entities.Articulo;
import principal.entities.Proveedor;


public class ControladorProveedores {
private static EntityManager em =  Persistence.createEntityManagerFactory("Papeleria").createEntityManager();
	
	private static String nombreTabla = "proveedor";
	
	public static Proveedor findArtById(int id) {
		try {
			Proveedor entidad = (Proveedor) em.find(Proveedor.class, id);
			return entidad;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	public static List<Proveedor> findAll() {
		return (List<Proveedor>) em.createNativeQuery("SELECT * FROM " + nombreTabla, Proveedor.class)
				.getResultList();
		
		

	}
	
	
	public static void update(Proveedor e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}

}
