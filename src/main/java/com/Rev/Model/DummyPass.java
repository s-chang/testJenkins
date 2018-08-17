package com.Rev.Model;

public class DummyPass {
	private String p_password;
	public DummyPass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DummyPass(String p_password) {
		super();
		
		this.p_password = p_password;
	}
	@Override
	public String toString() {
		return "DummyPersonPass [p_password=" + p_password + "]";
	}
	public String getP_password() {
		return p_password;
	}
	public void setP_password(String p_password) {
		this.p_password = p_password;
	}
	
}
