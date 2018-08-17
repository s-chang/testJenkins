package com.Rev.Dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.Rev.Model.Post;
import com.Rev.Util.ConnectionUtil;


public class PostDao {
	public void deletePost(Post p) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			conn.setAutoCommit(false);
			String sql = "DELETE FROM POST WHERE po_userName = ? AND po_datetime = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getUserName());
			ps.setTimestamp(2, p.getDate());
			ps.execute();
			
			conn.commit();
			
			ps.close();
			conn.close();			
		}catch(Exception ex) {
			ex.printStackTrace();
		}		
	}
	
	public void deletePost(String userName, Timestamp datetime) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			conn.setAutoCommit(false);
			String sql = "DELETE FROM POST WHERE po_userName = ? AND po_datetime = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setTimestamp(2, datetime);
			ps.execute();
			
			conn.commit();
			
			ps.close();
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void savePost(Post p) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO POST VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setTimestamp(2, p.getDate());
			ps.setString(3, p.getUserName());
			ps.setString(4, p.getTitle());
			ps.setString(5, p.getPost());
			ps.setBlob(6,  p.getImage());
		
			ps.setInt(7,  p.getFlag());
			System.out.println(p.toString());
			ps.execute();
			conn.commit();
			System.out.println("Post saved");
			ps.close();
			conn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void savePost(int id, Timestamp date, String uName, String post, Blob image, int msgType, int flag ) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO POST VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setTimestamp(2, date);
			ps.setString(3, uName);
			ps.setString(4, post);
			ps.setBlob(5,  image);
			ps.setInt(6, msgType);
			ps.setInt(7,  flag);
			
			ps.execute();
			conn.commit();
			
			ps.close();
			conn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Post> getAll(){
		List<Post> posts = new ArrayList<>();
		Post p = null;
		PreparedStatement ps = null;		
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM POST";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//System.out.println("in getAll()");
			
			while(rs.next()) {
				//System.out.println("Entered loop");
				int id = rs.getInt("po_id");
			//	System.out.println(id);
				Timestamp date = rs.getTimestamp("po_datetime");
				//System.out.println(date.toString());
				String userName = rs.getString("po_userName");
				//System.out.println(userName);
				String title = rs.getString("po_title");
				//System.out.println(title);
				String post = rs.getString("po_post");
				//System.out.println(post);
				Blob image = rs.getBlob("po_image");
				//System.out.println(image.toString());
				int flag = rs.getInt("po_flag");
				//System.out.println(flag);				
				
				p = new Post(id, date, userName, title, post, image, flag);				
				//System.out.println(p.toString());
				posts.add(p);
			}
			rs.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}		
		
		return posts;
	}
	
	public List<Post> getPostByUser(String user) {
		List<Post> posts = new ArrayList<>();
		Post p = null;
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM POST WHERE po_userName = ? ORDER BY po_datetime DESC";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("po_id");
				Timestamp date = rs.getTimestamp("po_datetime");
				String uName = rs.getString("po_userName");
				String title = rs.getString("po_title");
				String post = rs.getString("po_post");
				Blob image = rs.getBlob("po_image");
				
				int flag = rs.getInt("po_flag");
				
				p = new Post(id, date, uName, title, post, image,  flag);
				posts.add(p);
			}
			rs.close();
			ps.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return posts;
	}
	
	public List<Post> getPostByMostRecent(){
		List<Post> posts = new ArrayList<>();
		PreparedStatement ps = null;
		Post p = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM POST ORDER BY po_datetime DESC";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) {
				int id = rs.getInt("po_id");
				Timestamp date = rs.getTimestamp("po_datetime");
				String uName = rs.getString("po_userName");
				String title = rs.getString("po_title");
				String post = rs.getString("po_post");
				Blob image = rs.getBlob("po_image");				
				int flag = rs.getInt("po_flag");
				
				p = new Post(id, date, uName, title, post, image, flag);
				posts.add(p);				
			}			
			rs.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return posts;
	}
	
	public List<Post> getPostByFlag(){
		List<Post> posts = new ArrayList<>();
		PreparedStatement ps = null;
		Post p = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM POST WHERE po_flag = 1 ORDER BY po_datetime DESC";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("po_id");
				Timestamp date = rs.getTimestamp("po_datetime");
				String uName = rs.getString("po_userName");
				String title = rs.getString("po_title");
				String post = rs.getString("po_post");
				Blob image = rs.getBlob("po_image");
				
				int flag = rs.getInt("po_flag");
				
				p = new Post(id, date, uName, title, post, image,  flag);
				posts.add(p);
			}
			
			rs.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}		
		
		return posts;
	}
}