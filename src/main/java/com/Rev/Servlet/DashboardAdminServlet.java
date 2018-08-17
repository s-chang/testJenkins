package com.Rev.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rev.Dao.ReplyDao;

import com.Rev.Model.Reply;

public class DashboardAdminServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		//TODO: get posts and replies insert into dashadmin page
		ReplyDao rd = new ReplyDao();
		List<Reply> replies = rd.getAllReplies();
		PrintWriter pw = res.getWriter();
		
		for(Reply r: replies) {
			pw.println("<div> Reply <h4>"
					+ r.getUser() +"      " + r.getDate() +"</h4><br/>"
					+ "<p>" + r.getPost() + "</p></div>"
					);
			System.out.println(r.toString());
		}
		pw.close();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
	}
}
