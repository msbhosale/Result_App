package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.beans.Student;
import com.hefshine.dao.StudentDAO;

public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		StudentDAO sd = new StudentDAO();
		PrintWriter pw = response.getWriter();

		String username = session.getAttribute("username").toString();

		Student student = sd.getStudentByUsername(username);

		pw.write("<table>");

		pw.write("<tr>");
			pw.write("<td>");
			pw.write("Roll Number");
			pw.write("</td>");
			pw.write("<td>");
			pw.write(student.getRollNumber()+"");
			pw.write("</td>");
		pw.write("</tr>");
		pw.write("<tr>");
			pw.write("<td>");
			pw.write("Name");
			pw.write("</td>");
			
			pw.write("<td>");
			pw.write(student.getName());
			pw.write("</td>");
		pw.write("</tr>");
		pw.write("<tr>");
			pw.write("<td>");
			pw.write("DOB");
			pw.write("</td>");			
			pw.write("<td>");
			pw.write(student.getBirthdate()+"");
			pw.write("</td>");
		pw.write("</tr>");
		pw.write("<tr>");
		pw.write("<td>");
		pw.write("Marks 1");
		pw.write("</td>");
		pw.write("<td>");
		pw.write(student.getMarks1()+"");
		pw.write("</td>");
		pw.write("</tr>");
		pw.write("<tr>");
		pw.write("<td>");
		pw.write("Marks 2");
		pw.write("</td>");
		pw.write("<td>");
		pw.write(student.getMarks2()+"");
		pw.write("</td>");
		pw.write("</tr>");
		pw.write("<tr>");
		pw.write("<td>");
		pw.write("Marks 3");
		pw.write("</td>");
		pw.write("<td>");
		pw.write(student.getMarks3()+"");
		pw.write("</td>");
		pw.write("</tr>");

		pw.write("</table>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
	}

}
