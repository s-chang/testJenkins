package com.Rev.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Rev.Dao.PostDao;
import com.Rev.Model.DummyPost;
import com.Rev.Model.Post;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unused")
public class PostSubmitServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		//TODO: get Topic and message insert into POST table
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		System.out.println("Entered postsubmitservlet");
		PostDao pd = new PostDao();
		List<Post> posts = pd.getAll();
		ObjectMapper mapper = new ObjectMapper();
		int nextPost = posts.size() + 1;
		//mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DummyPost p = mapper.readValue(req.getInputStream(), DummyPost.class);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		HttpSession session = req.getSession();
		String uname = (String)session.getAttribute("uname");
		Post a = new Post(nextPost, timestamp, uname, p.getPo_title(), p.getPo_post(), null, 0);
		pd.savePost(a);
		
		PrintWriter pw = res.getWriter();
		pw.print("home.html");
		pw.close();	
	}
}