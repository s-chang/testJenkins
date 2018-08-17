package com.Rev.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rev.Dao.PersonDao;
import com.Rev.Model.DummyPerson;
import com.Rev.Model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//TODO: insert data into DB
		PersonDao pd = new PersonDao();
		ObjectMapper mapper = new ObjectMapper();
		List<Person> peeps = pd.getAll();
		DummyPerson p = mapper.readValue(req.getInputStream(), DummyPerson.class);
		Person a = new Person(peeps.size()+1, p.getP_firstName(), p.getP_lastName(), p.getP_password(), p.getP_email(), p.getP_bday(), 0, p.getP_username());
		pd.savePerson(a);
		
		PrintWriter pw = res.getWriter();
		pw.print("index.html");
		pw.close();	
		
		
	}
}
