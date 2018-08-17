package com.Rev.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Rev.Dao.PersonDao;
import com.Rev.Model.DummyPass;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChangePassServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PersonDao pd = new PersonDao();
		ObjectMapper mapper = new ObjectMapper();
		DummyPass p = mapper.readValue(req.getInputStream(), DummyPass.class);
		HttpSession session = req.getSession();
		pd.updatePass((String)session.getAttribute("uname"), p.getP_password());
		
	}
}
