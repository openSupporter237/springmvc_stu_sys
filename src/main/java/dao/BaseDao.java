package dao;

import org.hibernate.Session;

public interface BaseDao {
	public Session getSession();
	public void releaseSession();
}
