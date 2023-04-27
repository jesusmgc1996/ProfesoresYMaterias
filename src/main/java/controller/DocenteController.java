package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Docente;

public class DocenteController {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("profesoresymaterias");
	
	/**
	 * Método para obtener varios registros a partir del nombre
	 * @param name
	 * @return
	 */
	public static List<Docente> findByLikeName(String name) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM docente where lower(nombreCompleto) like ?", Docente.class);
		q.setParameter(1, "%" + name.toLowerCase() + "%");
		List<Docente> l = (List<Docente>) q.getResultList();
		em.close();
		return l;
	}

}
