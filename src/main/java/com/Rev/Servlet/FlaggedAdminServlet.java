package com.Rev.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.Rev.Dao.PostDao;
import com.Rev.Model.Post;

public class FlaggedAdminServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		//TODO: get flagged posts and reply insert into flaggedadmin page
		PostDao poster = new PostDao();
		PrintWriter pw = res.getWriter();
		List<Post> posts = poster.getAll();
				
		//TODO: filter out only the user's posts
		for(Post p: posts) {
			if(p.getFlag() == 1) {
				pw.println("<div><h3>" + p.getTitle() + "</h3>   <h4>by "
					+ p.getUserName() +"      " + p.getDate() +"</h4><br/>"
					+ "<p>" + p.getPost() + "</p></div><br/>"
					);
			}
		}
		
		pw.close();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
	}
}
