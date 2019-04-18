package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="stu_tb")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sid;
	private String name;
	private Boolean gender;
	private Integer age;
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Student(){
		super();
	}
	public Student(Long sid, String name, Boolean gender, Integer age) {
		super();
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj==this) {
			return true;
		} 
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other=(Student)obj;
		if (other.sid==this.sid) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.sid.intValue();
	}
}
