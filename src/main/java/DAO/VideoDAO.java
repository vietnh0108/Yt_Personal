package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.Video;
import Utils.JpaUtils;

public class VideoDAO {
	private  EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}


	public void create(Video entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public void update(Video entity) {
		try {
			em.getTransaction().begin(); 
			em.merge(entity);
			em.getTransaction().commit(); 

		} catch (Exception e) {
			em.getTransaction().rollback(); 
			throw new RuntimeException();
		}

	}

	public void remove(String id) {
		try {
			Video entity = this.findById(id);
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}

	}

	public Video findById(String id) {
		return em.find(Video.class, id);
	}

	public List<Video> findAll() {
		String jpql = "SELECT o FROM Video o";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		return query.getResultList();
	}
	
	public List<Video> findByTitle(String title) {
		TypedQuery<Video> query = em.createNamedQuery("Video.findByTitle", Video.class);
		query.setParameter("title", "%" + title + "%");
		return query.getResultList();
	}
	
	
	
	
	
	
}
