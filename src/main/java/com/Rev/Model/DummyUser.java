package com.Rev.Model;

public class DummyUser {
	public DummyUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DummyUser(String p_username, String p_password) {
		super();
		this.p_username = p_username;
		this.p_password = p_password;
	}
	private String p_username;
	private String p_password;
	public String getP_username() {
		return p_username;
	}
	public void setP_username(String p_username) {
		this.p_username = p_username;
	}
	public String getP_password() {
		return p_password;
	}
	public void setP_password(String p_password) {
		this.p_password = p_password;
	}
	
}
