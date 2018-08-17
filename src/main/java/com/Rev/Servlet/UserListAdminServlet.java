package com.Rev.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rev.Dao.PersonDao;
import com.Rev.Model.Person;

public class UserListAdminServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		//TODO: get persons insert into usersadmin page
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		PersonDao pd = new PersonDao();
		List<Person> users = pd.getAll();
		PrintWriter pw = res.getWriter();
		
		for(Person p: users) {
			System.out.println(p.toString());
			pw.println("<div>"
					+ p.getFirstName() + " " + p.getLastName() + " " + p.getEmail() + " "
					+ p.getDate() + " " + p.getUserName() 
					+ "</div><br/>"
					);
		}
		
		pw.close();
		
	}
}
