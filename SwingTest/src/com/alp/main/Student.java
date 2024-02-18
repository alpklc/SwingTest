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
	 * @return name
	 * This name returns student's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 * This method sets student's name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return surname
	 * This method returns student's surname.
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * @param surname
	 * This method sets student's surname.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * @return number
	 * This method returns student's number.
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * @param number
	 * This method sets student's number.
	 */
	public void setNumber(String number, String test) {
		this.number = number;
	}


	/**
	 *
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + ", number=" + number + "]";
	}
	
	/**
	 * This is a private dummy method of student class.
	 * This method is written for testing purposes.
	 * @return 5
	 */
	private static int test() {
		return 5;
	}
	
	
}
