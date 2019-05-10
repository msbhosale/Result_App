package com.hefshine.test;

import com.hefshine.beans.Student;
import com.hefshine.dao.StudentDAO;

public class TestApp {
	
	public static void main(String[] args) {
		
		StudentDAO sd = new StudentDAO();
		Student student = sd.getStudentByUsername("kalpna");
		
		System.out.println(student);
		
	}

}
