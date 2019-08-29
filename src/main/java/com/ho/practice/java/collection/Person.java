package com.ho.practice.java.collection;

public class Person {

	private String name;
	
	public Person(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "name : " + name;
	}

}
