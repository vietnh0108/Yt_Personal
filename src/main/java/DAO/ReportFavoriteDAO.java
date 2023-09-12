package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.ReportFavorite;
import Utils.JpaUtils;

public class ReportFavoriteDAO {
	private  EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public List<ReportFavorite> findAll() {
		String jpql = "SELECT NEW ReportFavorite(o.videoId.title, count(o),"
				+ " MIN(o.likeDate), MAX(o.likeDate))"
				+ " FROM Favorite o"
				+ " GROUP BY o.videoId.title";
		TypedQuery <ReportFavorite> query = em.createQuery(jpql, ReportFavorite.class);
		return query.getResultList();
	}
	
	
}
