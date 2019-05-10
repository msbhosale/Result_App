package com.hefshine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hefshine.beans.Student;

public class StudentDAO {

	public boolean isValidStudent(Student student) {

		int records = 0;

		System.out.println(student);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hefshine", "root", "root");

			PreparedStatement pst = connection
					.prepareStatement("SELECT * FROM student_master WHERE username = ? AND password = ?");

			pst.setString(1, student.getUsername());
			pst.setString(2, student.getPassword());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				records++;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return records > 0;

	}

	public Student getStudentByUsername(String username) {

		System.out.println(username);
		
		Student student = new Student();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hefshine", "root", "root");

			PreparedStatement pst = connection
					.prepareStatement("select s.roll_number, r.marks1,r.marks2,r.marks3,s.name,s.dob from student_master s join result_master r on s.roll_number = r.roll_number where s.username=?");

			pst.setString(1, username);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				
				student.setName(rs.getString("name"));
				student.setRollNumber(rs.getInt("roll_number"));
				student.setBirthdate(rs.getDate("dob"));
				student.setMarks1(rs.getInt("marks1"));
				student.setMarks2(rs.getInt("marks2"));
				student.setMarks3(rs.getInt("marks3"));
				
			}
			
			System.out.println(student);

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return student;
	}

}
