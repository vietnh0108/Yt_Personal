package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.User;
import Utils.JpaUtils;

public class UserDAO {
	private EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public void create(User entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			// Hoàn tất giao dịch
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	
	public void update(User entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			// Hoàn tất giao dịch
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	
	public void delete(String id) {
		try {
			em.getTransaction().begin();
			User entity = this.findById(id);
			em.remove(entity);
			// Hoàn tất giao dịch
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	
	public User findById(String id) {
		User entity = em.find(User.class, id);
		return entity;
	}
	
	public List<User> findAll() {
		String jpql = "SELECT o FROM User o";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		List<User> list = query.getResultList();
		return list;
	}
	
	public User checkLogin(String username, String password) {
//		User kq = null;
		try {
			String jpql = "SELECT o FROM User o WHERE o.id = :username and o.password=:password";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);

			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
}
