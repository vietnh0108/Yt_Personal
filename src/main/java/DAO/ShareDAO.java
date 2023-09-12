package DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.Favorite;
import Entity.Share;
import Entity.User;
import Entity.Video;
import Utils.JpaUtils;

public class ShareDAO {
	private  EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}


	public void create(Share entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public void update(Share entity) {
		try {
			em.getTransaction().begin(); 
			em.merge(entity);
			em.getTransaction().commit(); 

		} catch (Exception e) {
			em.getTransaction().rollback(); 
			throw new RuntimeException();
		}

	}

	public void remove(int id) {
		try {
			Favorite entity = em.find(Favorite.class,id);
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}

	}

	public Share findById(int id) {
		return em.find(Share.class, id);
	}

	public List<Share> findAll() {
		String jpql = "SELECT o FROM Share o";
		TypedQuery<Share> query = em.createQuery(jpql, Share.class);
		return query.getResultList();
	}


}
