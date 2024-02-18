package com.alp.model;

public class Student {

	String name;
	String surname;
	String number;
	
	public Student(String name, String surname, String number) {
		this.name = name;
		this.surname = surname;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + ", number=" + number + "]";
	}
	
	
}
