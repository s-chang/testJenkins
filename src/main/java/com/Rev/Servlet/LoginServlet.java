package com.Rev.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Rev.Dao.PersonDao;
import com.Rev.Model.DummyUser;
import com.Rev.Model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{		
		//HttpSession session = req.getSession();
		//res.sendRedirect("signup.html");
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.print("signup.html");
		pw.close();
		//System.out.println("Get success");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		HttpSession session = req.getSession();
		PersonDao pd = new PersonDao();
		ObjectMapper mapper = new ObjectMapper();
		DummyUser p = mapper.readValue(req.getInputStream(), DummyUser.class);
		//List<Person> peeps= pd.getAll();
		boolean found = pd.checkUser(p);
		PrintWriter pw = res.getWriter();
		
		//TODO: log in, create session, check if admin, forward to home page
		
		Person temp = null;				
		res.setContentType("text/html");
		
		if(found){
			temp = pd.getPersonByUserName(p.getP_username());
			session.setAttribute("uname", temp.getUserName());
			if(temp.isAdmin() == 1) {
				pw.print("admin");			
				pw.close();
			}else{
				pw.print("user");
				pw.close();
			}
		}else {			
			session = req.getSession(false);
			pw.print("<style='text/css'>User name and/or password not found.</style>");
			pw.close();			
		}		
		
		//System.out.println("Made it to the Servlet");
		//System.out.println(p.getP_username() + " " + p.getP_password());
		//for(Person a : peeps) {
			//System.out.println(a.toString());
		//}
		//System.out.println(found);
	}	
}