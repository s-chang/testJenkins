package com.Rev.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Rev.Dao.PersonDao;
import com.Rev.Model.Person;

public class ProfilePageServlet4 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		HttpSession session = req.getSession();
		
		PersonDao pd = new PersonDao();
		Person p = pd.getPersonByUserName((String)session.getAttribute("uname"));
		
		PrintWriter pw = res.getWriter();
		pw.print(p.getUserName());
		pw.close();
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		//TODO: insert information from person - allow user to change email/password
		
	}
}

