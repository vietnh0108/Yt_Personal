package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.ReportFavorite;
import Entity.ReportFavoriteUser;
import Utils.JpaUtils;

public class ReportFavoriteUserDAO {
	private  EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public List<ReportFavoriteUser> findAll() {
		String jpql = "SELECT DISTINCT NEW ReportFavoriteUser(o.videoId.title, o.userId.id, o.userId.password,"
				+ " o.userId.fullname, o.userId.email )"
				+ " FROM Favorite o";
		TypedQuery <ReportFavoriteUser> query = em.createQuery(jpql, ReportFavoriteUser.class);
		return query.getResultList();
	}
	
	public List<ReportFavoriteUser> findByTitle(String title) {
		String jpql = "SELECT DISTINCT NEW ReportFavoriteUser(o.videoId.title, o.userId.id, o.userId.password,"
				+ " o.userId.fullname, o.userId.email )"
				+ " FROM Favorite o WHERE o.videoId.title LIKE :title";
		TypedQuery <ReportFavoriteUser> query = em.createQuery(jpql, ReportFavoriteUser.class);
		query.setParameter("title", "%" + title + "%");
		return query.getResultList();
	}
}
