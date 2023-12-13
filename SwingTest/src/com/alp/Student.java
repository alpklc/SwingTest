package com.alp;


public class Student {

	private String name;
	private String surname;
	private String number;
	
	/**
	 * @param name
	 * @param surname
	 * @param number
	 */
	public Student(String name, String surname, String number) {
		this.name = name;
		this.surname = surname;
		this.number = number;
	}
	
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * @return
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}


	/**
	 *
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + ", number=" + number + "]";
	}
	
	
}
