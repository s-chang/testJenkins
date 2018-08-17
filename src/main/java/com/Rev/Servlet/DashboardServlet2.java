package com.Rev.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Rev.Dao.ReplyDao;
import com.Rev.Model.Reply;

public class DashboardServlet2 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		//TODO: get replies insert into Dashboard page
		ReplyDao poster = new ReplyDao();
		PrintWriter pw = res.getWriter();
		List<Reply> posts = poster.getAllReplies();
		res.setContentType("text/html");
		HttpSession session = req.getSession();
		
		System.out.println("in get Reply");
		//TODO: filter out only the user's replies
		for(Reply p: posts) {
			if(p.getUser().equals(session.getAttribute("uname"))) {
				pw.println("<div> Reply <h4>"
					+ p.getUser() +"      " + p.getDate() +"</h4><br>"
					+ "<p>" + p.getPost() + "</p></div>"
					);
			}
		}
		
		pw.close();
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
	}
}

