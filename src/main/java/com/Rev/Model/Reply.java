package com.Rev.Model;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reply {
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reply(int id, Timestamp date, String user, String post, Blob image, int flag, int replyTo) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
		this.post = post;
		this.image = image;
		this.flag = flag;
		this.replyTo = replyTo;
	}
	private int id;
	private Timestamp date;
	private String user;
	private String post;
	private Blob image;
	private int flag;
	private int replyTo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getReplyTo() {
		return replyTo;
	}
	public void setReplyTo(int replyTo) {
		this.replyTo = replyTo;
	}
	@Override
	public String toString() {
		return "Reply [id=" + id + ", date=" + date + ", user=" + user + ", post=" + post + ", flag=" + flag
				+ ", replyTo=" + replyTo + "]";
	}
}
