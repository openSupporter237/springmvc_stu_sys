package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.BaseDao;
//@Transactional
public class BaseDaoImpl implements BaseDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession();
	}

	public void releaseSession() {
		// TODO Auto-generated method stub
		getSession().close();
	}
	
	
}
