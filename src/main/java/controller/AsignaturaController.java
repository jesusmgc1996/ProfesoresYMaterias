package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignatura;

public class AsignaturaController {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("profesoresymaterias");

	/** 
	 * Método para obtener todos los registros
	 * @return
	 */
	public static List<Asignatura> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("Asignatura.findAll");
		List<Asignatura> l = (List<Asignatura>) q.getResultList();
		em.close();
		return l;
	}

}
