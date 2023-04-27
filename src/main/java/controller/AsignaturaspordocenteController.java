package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignaturaspordocente;

public class AsignaturaspordocenteController {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("profesoresymaterias");

	/**
	 * Método para obtener varios registros por el idDocente
	 * @param id
	 * @return
	 */
	public static List<Asignaturaspordocente> findByIdDocente(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM asignaturaspordocente where idDocente = ?", Asignaturaspordocente.class);
		q.setParameter(1, id);
		List<Asignaturaspordocente> l = (List<Asignaturaspordocente>) q.getResultList();
		em.close();
		return l;
	}
	
	/**
	 * Método para insertar un registro
	 * @param o
	 */
	public static void insertar(Asignaturaspordocente o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Método para eliminar un registro
	 * @param o
	 */
	public static void eliminar (Asignaturaspordocente o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		o = em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

}
