package me.sk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
	@Autowired
	private SessionFactory sessionFactory;

	Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(Object entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public void update(Object entity) {
		sessionFactory.getCurrentSession().update(entity);
		;
	}

	public void saveOrUpdate(Object entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		;
	}

	public void merge(Object entity) {
		sessionFactory.getCurrentSession().merge(entity);
	}

	public void delete(Object entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}
	
	public <T> List<T> query(String hql, Object[] param) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return query.getResultList();
	}

}
