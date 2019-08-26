package com.ho.practice.java.collection;

public class Employee {

	private Department department;
	private Integer salary;
	private Integer grade;
	private String gender;
	
	public Employee(Department department) {
		this.department = department;
	}
	public Employee(Department department, String gender) {
		this.department = department;
		this.gender = gender;
	}
	public Employee(Department department, Integer salary) {
		this.department = department;
		this.salary = salary;
	}
	public Employee(Department department, Integer salary, Integer grade) {
		this.department = department;
		this.salary = salary;
		this.grade = grade;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}