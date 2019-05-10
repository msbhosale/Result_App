package com.hefshine.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.beans.Student;
import com.hefshine.dao.StudentDAO;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Student student = new Student();
		
		student.setUsername(username);
		student.setPassword(password);
		
		
		StudentDAO sd = new StudentDAO();
		
		if(sd.isValidStudent(student)) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("username", username);
			
			response.sendRedirect("Profile");
			
		}
		
		
		

	}

}
