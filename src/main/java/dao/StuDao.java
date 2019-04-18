package dao;

import java.util.List;

import domain.Student;

public interface StuDao {
	public List<Student> getStudentList(int offset,int size);
	public Student getOneStudent(long sid);
	public List<Student> getOneStudent(String name);
	public void addStudent(Student stu);
}
