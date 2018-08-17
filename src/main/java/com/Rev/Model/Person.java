package com.Rev.Model;

import java.sql.Date;

public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private Date bday;
	private int admin;
	private String userName;
	
	public Person() {}
	public Person(int id, String firstName, String lastName, String password, String email, Date bday, int admin, String userName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.bday = bday;
		this.admin = admin;
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return bday;
	}
	public void setDate(Date date) {
		this.bday = date;
	}	
	public int isAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + ", bday=" + bday + ", admin=" + admin + ", userName=" + userName + "]";
	}
	
	
}
