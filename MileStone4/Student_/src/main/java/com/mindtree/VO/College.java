package com.mindtree.VO;

public class College
{

	
	private long id;
	private String name;
	private long totalStudents;
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
	public long getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(long totalStudents) {
		this.totalStudents = totalStudents;
	}
	public College(long id, String name, long totalStudents) {
		super();
		this.id = id;
		this.name = name;
		this.totalStudents = totalStudents;
	}
	
	
	public College ()
	{
		super();
	}
	
}
