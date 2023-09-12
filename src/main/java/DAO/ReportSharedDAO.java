package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.ReportFavoriteUser;
import Entity.ReportShared;
import Utils.JpaUtils;

public class ReportSharedDAO {
	private  EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public List<ReportShared> findAll() {
		String jpql = "SELECT NEW ReportShared(o.videoId.title, o.userId.fullname, o.userId.email,"
				+ " o.email, o.shareDate)"
				+ " FROM Share o";
		TypedQuery <ReportShared> query = em.createQuery(jpql, ReportShared.class);
		return query.getResultList();
	}
	
	public List<ReportShared> findByTitle(String title) {
		String jpql = "SELECT NEW ReportShared(o.videoId.title, o.userId.fullname, o.userId.email,"
				+ " o.email, o.shareDate)"
				+ " FROM Share o WHERE o.videoId.title LIKE :title";
		TypedQuery <ReportShared> query = em.createQuery(jpql, ReportShared.class);
		query.setParameter("title", "%" + title + "%");
		return query.getResultList();
	}
}
