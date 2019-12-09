package com.ho.practice.java.collection;

import java.util.Date;

public class Employee {

	private String employeeId;
	private String name;
	private Department department;
	private Integer salary;
	private Integer grade;
	private String gender;
	private Date hireDate;
	
	public Employee() {
	}
	public Employee(String employeeId, String name) {
		this.employeeId = employeeId;
		this.name = name;
	}
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
	public Employee(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String toString() {
		return "HireDate : " + hireDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
