package com.Rev.Model;

import java.sql.Date;

public class DummyPerson {
	public DummyPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DummyPerson(String p_firstName, String p_lastName, String p_password, String p_email, Date p_bday,
			String p_username) {
		super();
		this.p_firstName = p_firstName;
		this.p_lastName = p_lastName;
		this.p_password = p_password;
		this.p_email = p_email;
		this.p_bday = p_bday;
		this.p_username = p_username;
	}
	private String p_firstName;
	private String p_lastName;
	private String p_password;
	private String p_email;
	private Date p_bday;
	private String p_username;
	public String getP_firstName() {
		return p_firstName;
	}
	public void setP_firstName(String p_firstName) {
		this.p_firstName = p_firstName;
	}
	public String getP_lastName() {
		return p_lastName;
	}
	public void setP_lastName(String p_lastName) {
		this.p_lastName = p_lastName;
	}
	public String getP_password() {
		return p_password;
	}
	public void setP_password(String p_password) {
		this.p_password = p_password;
	}
	public String getP_email() {
		return p_email;
	}
	public void setP_email(String p_email) {
		this.p_email = p_email;
	}
	public Date getP_bday() {
		return p_bday;
	}
	public void setP_bday(Date p_bday) {
		this.p_bday = p_bday;
	}
	public String getP_username() {
		return p_username;
	}
	public void setP_username(String p_username) {
		this.p_username = p_username;
	}
	@Override
	public String toString() {
		return "DummyPerson [p_firstName=" + p_firstName + ", p_lastName=" + p_lastName + ", p_password=" + p_password
				+ ", p_email=" + p_email + ", p_bday=" + p_bday + ", p_username=" + p_username + "]";
	}
	
}
