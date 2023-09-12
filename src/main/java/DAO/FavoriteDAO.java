package DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.Favorite;
import Entity.User;
import Entity.Video;
import Utils.JpaUtils;

public class FavoriteDAO {
	private  EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}


	public void create(Favorite entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public void update(Favorite entity) {
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

	public Favorite findById(int id) {
		return em.find(Favorite.class, id);
	}

	public List<Favorite> findAll() {
		String jpql = "SELECT o FROM Favorite o";
		TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
		return query.getResultList();
	}
	
	public void saveLike(String userid, String videoid)
	{
		Favorite fa = new Favorite();
	    User u = em.find(User.class, userid);
	    Video v = em.find(Video.class, videoid);
	    fa.setUserId(u);
	    fa.setVideoId(v);
	    fa.setLikeDate(new Date());
	    	    	    
		try {
			em.getTransaction().begin();
			em.persist(fa);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Them moi that bai!");
		}
	}
	
	public void unLike(String userid, String videoid)
	{
		TypedQuery<Favorite> q = em.createQuery("SELECT o FROM Favorite o WHERE o.userId.id=:uid AND o.videoId.id=:vid", Favorite.class);
		q.setParameter("uid", userid);
		q.setParameter("vid", videoid);
		if (q.getResultList().size() > 0) {
			System.out.println("here ---------------" + q.getResultList().get(0).getId());
			try {
				em.getTransaction().begin();
				em.remove(em.merge(q.getResultList().get(0)));;
				em.getTransaction().commit();

			} catch (Exception e) {
				em.getTransaction().rollback();
				throw new RuntimeException();
			}

		}
	}
	
	public boolean isLike(String userid, String videoid) {
		TypedQuery<Favorite> q = em.createQuery("SELECT o FROM Favorite o WHERE o.userId.id=:uid AND o.videoId.id=:vid", Favorite.class);
		q.setParameter("uid", userid);
		q.setParameter("vid", videoid);
		return q.getResultList().size() > 0;
	}
	
	public Favorite checkVideoFavorite(String userid, String videoid) {
		try {
			String jpql = "SELECT o FROM Favorite o WHERE o.userId.id = :userId and o.videoId.id = :videoId";
			TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
			query.setParameter("userId", userid);
			query.setParameter("videoId", videoid);
			return query.getSingleResult();
		} catch (Exception e) {
			System.out.println(0);
			return null;
		}
		
	}
	
	public List<Video> findVideoFavoriteByUser(String userid) {
		TypedQuery<Video> query = em.createNamedQuery("Video.findByUser", Video.class);
		query.setParameter("userid", userid);
		return query.getResultList();
	}
}
