package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import dao.StuDao;
import domain.Student;
@Repository
public class StuDaoImpl extends BaseDaoImpl implements StuDao{
	
	public List<Student> getStudentList(int offset, int size) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=getSession();
			List<Student> list =(List<Student>)session.createQuery("from Student order by sid desc").setFirstResult(offset).setMaxResults(size).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		
		/*List<Student> stulist = new ArrayList<Student>();
		Student stu = new Student((long)1,"jack","ÄÐ",25);
		stulist.add(stu);
		return stulist;*/
	}

	public Student getOneStudent(long sid) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=getSession();
			return session.get(Student.class, sid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

	public void addStudent(Student stu) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=getSession();
			session.save(stu);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public List<Student> getOneStudent(String name) {
		Session session=null;
		try {
			session=getSession();
			return session.createQuery("from Student s where s.name=?")
			.setParameter(0, name)
			.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

}
