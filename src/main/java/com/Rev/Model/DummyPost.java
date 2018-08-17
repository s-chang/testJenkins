package com.Rev.Model;

public class DummyPost {
	private String po_title;
	private String po_post;	
		
	public DummyPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPo_title() {
		return po_title;
	}

	public void setPo_title(String po_title) {
		this.po_title = po_title;
	}

	public String getPo_post() {
		return po_post;
	}

	public void setPo_post(String po_post) {
		this.po_post = po_post;
	}

	public DummyPost(String po_title, String po_post) {
		super();
		this.po_title = po_title;
		this.po_post = po_post;
	}

	@Override
	public String toString() {
		return "DummyPost [po_title=" + po_title + ", po_post=" + po_post + "]";
	}
	
	
}
