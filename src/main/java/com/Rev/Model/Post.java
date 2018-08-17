package com.Rev.Model;

import java.sql.Blob;
import java.sql.Timestamp;

public class Post {
	@Override
	public String toString() {
		return "Post [id=" + id + ", date=" + date + ", userName=" + userName + ", title=" + title + ", post=" + post
				+ ", image=" + image + ", flag=" + flag + "]";
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(int id, Timestamp date, String userName, String title, String post, Blob image,  int flag) {
		super();
		this.id = id;
		this.date = date;
		this.userName = userName;
		this.post = post;
		this.image = image;
		this.title = title;
		this.flag = flag;
	}
	private int id;
	private Timestamp date;
	private String userName;
	private String title;
	private String post;
	private Blob image;	
	private int flag;
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
}