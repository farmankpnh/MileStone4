package com.mindtree.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private long age;
	private String gender;
	private String stream;
	private long colg_id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public long getColg_id() {
		return colg_id;
	}
	public void setColg_id(long colg_id) {
		this.colg_id = colg_id;
	}
	
	public Student()
	{
		super();
	}
    
	
	
	public Student(long id, String name, long age, String gender, String stream, long colg_id) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.stream = stream;
		this.colg_id = colg_id;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", stream=" + stream
				+ ", colg_id=" + colg_id + "]";
	}
	
	
	
	
	
	
}
