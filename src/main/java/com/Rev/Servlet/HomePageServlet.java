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

public class HomePageServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		//TODO: get posts insert into home page
		PostDao poster = new PostDao();
		PrintWriter pw = res.getWriter();
		List<Post> posts = poster.getAll();
		res.setContentType("text/html");
		
		for(Post p: posts) {
			pw.println("<div><h3>" + p.getTitle() + "</h3>   <h4> by "
					+ p.getUserName() +"      " + p.getDate() +"</h4><br/>"
					+ "<p>" + p.getPost() + "</p></div><br/>"
					);
		}
		
		pw.close();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
	}
}