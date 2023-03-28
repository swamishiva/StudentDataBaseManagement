package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateStudentTable {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsys","root","root");
			Statement state=con.createStatement();
			state.executeUpdate("create table student(name varchar(10) primary key,age int(5) not null,id int(5) not null,marks int(5) not null)");
			System.out.println("table created");
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
