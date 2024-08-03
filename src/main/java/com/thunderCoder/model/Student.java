package com.thunderCoder.model;

public class Student {


	private int id;
	private String name;
	private int marks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "StudentController [id=" + id + ", name=" + name + ", marks=" + marks + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getMarks()=" + getMarks() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Student(int id, String name, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
}
