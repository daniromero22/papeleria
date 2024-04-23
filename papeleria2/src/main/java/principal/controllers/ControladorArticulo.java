package principal.controllers;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import principal.entities.Articulo;



public class ControladorArticulo {
	

	private static EntityManager em =  Persistence.createEntityManagerFactory("Papeleria").createEntityManager();
	
	private static String nombreTabla = "articulo";
	
	
	public static Articulo findArtById(int id) {
		try {
			Articulo entidad = (Articulo) em.find(Articulo.class, id);
			return entidad;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	

	public static void insert (Articulo o) {
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		
		
		
		
	}
	
	public static void update(Articulo e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	
	
	
	
	
	public static Articulo getPrimero() {
		Query q  = em.createNativeQuery("Select min(id) from "  + nombreTabla);
		int primerId = (int) q.getSingleResult();
		Articulo c = em.find(Articulo.class, primerId);
		return c;
	}
	
	public static Articulo getUltimo() {
		Query q  = em.createNativeQuery("Select max(id) from "  + nombreTabla);
		int primerId = (int) q.getSingleResult();
		Articulo c = em.find(Articulo.class, primerId);
		return c;
	}
	
	public static Articulo getSiguiente(int id) {
	    Articulo c = null;
	    Query q = em.createNativeQuery("SELECT MIN(id) FROM " + nombreTabla + " WHERE id > ?id");
	    q.setParameter("id", id);
	    Integer siguienteId = (Integer) q.getSingleResult();
	    
	    if (siguienteId != null) {
	        c = em.find(Articulo.class, siguienteId);
	    } else {
	        c = getPrimero();
	    }
	    
	    return c;
	}


	
	public static Articulo getAnterior(int id) {
	    Articulo c = null;
	    Query q = em.createNativeQuery("SELECT MAX(id) FROM " + nombreTabla + " WHERE id < ?id");
	    q.setParameter("id", id);
	    Integer anteriorId = (Integer) q.getSingleResult();
	    
	    if (anteriorId != null) {
	        c = em.find(Articulo.class, anteriorId);
	    } else {
	        c = getUltimo();
	    }
	    
	    return c;
	}

	
	
	
	
	

}
