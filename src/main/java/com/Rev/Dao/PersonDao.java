package com.Rev.Dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Rev.Model.DummyUser;
import com.Rev.Model.Person;
import com.Rev.Util.ConnectionUtil;

public class PersonDao {
	public int getLastIdNumber() {
		return getAll().size();
	}
	
	public void updatePass(String user, String pass) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			conn.setAutoCommit(false);
			String sql = "UPDATE PERSON SET p_password = ? WHERE p_userName = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2,  user);
			ps.executeQuery();
			
			conn.commit();
			conn.close();
			ps.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void savePerson(Person p) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO PERSON VALUES(?,?,?,?,?,?,?,?)";
						
			ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getFirstName());
			ps.setString(3, p.getLastName());
			ps.setString(4, p.getPassword());
			ps.setString(5, p.getEmail());
			ps.setDate(6,  p.getDate());
			ps.setInt(7, p.isAdmin());
			ps.setString(8, p.getUserName());
			
			ps.execute();
			conn.commit();
			
			conn.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void savePerson(int id, String firstName, String lastName, String password, String email, Date bday, int admin, String userName) {
PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO PERSON VALUES(?,?,?,?,?,?,?,?)";
						
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, password);
			ps.setString(5, email);
			ps.setDate(6, bday);
			ps.setInt(7, admin);
			ps.setString(8, userName);
			
			ps.execute();
			conn.commit();
			
			conn.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Person> getAll(){
		PreparedStatement ps = null;
		List<Person> people = new ArrayList<>();
		Person p = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM PERSON";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("p_id");
				String fname = rs.getString("p_firstName");
				String lname = rs.getString("p_lastName");
				String pass = rs.getString("p_password");
				String email = rs.getString("p_email");
				Date date = rs.getDate("p_bday");
				int admin = rs.getInt("p_admin");				
				String uname = rs.getString("p_userName");
				
				p = new Person(id, fname, lname, pass, email, date ,admin,uname);
				people.add(p);
				
			}
			rs.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return people;
	}
	
	public Person getPersonByUserName(String user) {
		PreparedStatement ps = null;
		Person p = null;
				
		try(Connection conn = ConnectionUtil.getConnection()){
			//TODO: check if user exists
			String sql = "SELECT * FROM PERSON WHERE p_userName = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();		
			
			while(rs.next()) {
				int id = rs.getInt("p_id");
				String fname = rs.getString("p_firstName");
				String lname = rs.getString("p_lastName");
				String email = rs.getString("p_email");
				Date bday = rs.getDate("p_bday");
				int admin = rs.getInt("p_admin");				
				
				//TODO: Generate random password
				String tempPass = "";
				p = new Person(id, fname, lname, tempPass, email, bday,admin,user);
			}
			rs.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}		
		
		return p;
	}
	
	public Person getPersonByEmail(String email) {
		PreparedStatement ps = null;
		Person p = null;
				
		try(Connection conn = ConnectionUtil.getConnection()){
			//TODO: check if user exists
			String sql = "SELECT * FROM PERSON WHERE p_email = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();		
			
			while(rs.next()) {
				int id = rs.getInt("p_id");
				String fname = rs.getString("p_firstName");
				String lname = rs.getString("p_lastName");
				String uname = rs.getString("p_userName");
				Date bday = rs.getDate("p_bday");
				int admin = rs.getInt("p_admin");				
				
				//TODO: Generate random password
				String tempPass = "";
				p = new Person(id, fname, lname, tempPass, email, bday,admin,uname);
			}
			rs.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}		
		
		return p;
	}
	
	public List<Person> getAdmin() {
		PreparedStatement ps = null;
		Person p = null;
		List<Person> people = new ArrayList<>();
				
		try(Connection conn = ConnectionUtil.getConnection()){
			//TODO: check if user exists
			String sql = "SELECT * FROM PERSON WHERE p_admin = 1";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();		
			
			while(rs.next()) {
				int id = rs.getInt("p_id");
				String fname = rs.getString("p_firstName");
				String lname = rs.getString("p_lastName");
				String email = rs.getString("p_email");
				String uname = rs.getString("p_userName");
				String pass = rs.getString("p_password");
				Date bday = rs.getDate("p_bday");
				int admin = rs.getInt("p_admin");				
				
				p = new Person(id, fname, lname, pass, email, bday,admin,uname);
				
				people.add(p);
				
			}
			rs.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}		
		
		return people;
	}
	
	public boolean checkUser(DummyUser p) {
		boolean found = false;
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			//TODO: check if user exists
			String sql = "SELECT * FROM PERSON WHERE p_userName = ? AND p_password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getP_username());
			ps.setString(2,  p.getP_password());
			ResultSet rs = ps.executeQuery();		
			
			while(rs.next()) {
						
				String fname = rs.getString("p_userName");
				String password = rs.getString("p_password");				
								
				if((fname != null) && (password != null)) {
					found = true;
				}
				
			}
			rs.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}		
		
		return found;
	}
	
	public boolean checkUser(String name, String pass) {
		boolean found = false;
		PreparedStatement ps = null;
			
		try(Connection conn = ConnectionUtil.getConnection()){
			//TODO: check if user exists
			String sql = "SELECT * FROM PERSON WHERE p_userName = ? AND p_password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();		
			
			while(rs.next()) {
						
				String uname = rs.getString("p_userName");
				String password = rs.getString("p_password");				
								
				if((uname != null) && (password != null)) {
					found = true;
				}				
			}
			rs.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}		
		
		return found;
	}
}