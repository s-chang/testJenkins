package com.Rev.Dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.Rev.Model.Reply;
import com.Rev.Util.ConnectionUtil;

public class ReplyDao {
	public void deleteReply(Reply r) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM REPLY WHERE r_datetime = ? AND r_userName = ?, r_replyTo = ?";
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, r.getDate());
			ps.setString(2, r.getUser());
			ps.setInt(3, r.getReplyTo());
			
			ps.execute();
			conn.commit();
			
			ps.close();
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteReply(Timestamp date, String name, int user) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM REPLY WHERE r_datetime = ? AND r_userName = ?, r_replyTo = ?";
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, date);
			ps.setString(2, name);
			ps.setInt(3, user);
			
			ps.execute();
			conn.commit();
			
			ps.close();
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void saveReply(Reply r) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO REPLY VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getId());
			ps.setTimestamp(2, r.getDate());
			ps.setString(3, r.getUser());
			ps.setString(4, r.getPost());
			ps.setBlob(5,  r.getImage());
		
			ps.setInt(6,  r.getFlag());
			ps.setInt(7,  r.getReplyTo());
			
			ps.execute();
			conn.commit();
			
			ps.close();
			conn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void saveReply(int id, Timestamp date, String user, String post, Blob image, int flag, int replyTo) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO REPLY VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setTimestamp(2, date);
			ps.setString(3, user);
			ps.setString(4, post);
			ps.setBlob(5,  image);
		
			ps.setInt(6,  flag);
			ps.setInt(7,  replyTo);
			
			ps.execute();
			conn.commit();
			
			ps.close();
			conn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private List<Reply> getListRepliesByQuery(String sql) {
		List<Reply> replies = new ArrayList<>();
		Reply reply = null;
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("r_id");
				Timestamp time = rs.getTimestamp("r_datetime");
				String user = rs.getString("r_userName");
				String msg = rs.getString("r_post");
				Blob image = rs.getBlob("r_image");
				int flag = rs.getInt("r_flag");
				int replyTo = rs.getInt("r_replyTo");
				
				reply = new Reply(id, time, user, msg, image, flag, replyTo);
				replies.add(reply);
			}
			rs.close();
			ps.close();			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return replies;
	}
	
	
	public List<Reply> getAllReplies(){
		//List<Reply> replies = getListRepliesByQuery("SELECT * FROM REPLY");
		System.out.println("In get all replies");
		List<Reply> replies = new ArrayList<>();
		Reply reply = null;
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM REPLY";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("r_id");
				Timestamp time = rs.getTimestamp("r_datetime");
				String user = rs.getString("r_userName");
				String msg = rs.getString("r_post");
				Blob image = rs.getBlob("r_image");
				int flag = rs.getInt("r_flag");
				int replyTo = rs.getInt("r_replyTo");
				
				reply = new Reply(id, time, user, msg, image, flag, replyTo);
				replies.add(reply);
			}
			rs.close();
			ps.close();			
		}catch(Exception ex) {
			ex.printStackTrace();
		}		
		
		for(Reply r: replies) {
			System.out.println(r.toString());
		}
		System.out.println("in All replies");
		return replies;
	}
	
	public List<Reply> getRepliesByUser(String name){
		List<Reply> replies = getListRepliesByQuery("SELECT * FROM REPLY WHERE r_userName = '" + name + "' ORDER BY r_id DESC");
		return replies;
	}
	
	public List<Reply> getRepliesByFlag(){
		List<Reply> replies = getListRepliesByQuery("SELECT * FROM REPLY WHERE r_flag = 2");
		return replies;
	}
	
}
