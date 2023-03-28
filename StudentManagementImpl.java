package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentManagementImpl implements StudentManagement{
	Scanner sc=new Scanner(System.in);
	@Override
	public void addStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsys","root","root");
			PreparedStatement state=con.prepareStatement("insert into student values(?,?,?,?)");
			System.out.println("enter Student Name");
			state.setString(1,sc.next());
			System.out.println("enter Student Age");
			state.setInt(2,sc.nextInt());
			System.out.println("enter Student ID");
			state.setInt(3, sc.nextInt());
			System.out.println("enter Student Marks");
			state.setInt(4,sc.nextInt());
			state.executeUpdate();
			con.close();
			System.out.println("Student Record Inserted Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsys","root","root");
			PreparedStatement state=con.prepareStatement("delete from student where id=?");
			System.out.println("Enter student Id To Delete");
			int ID=sc.nextInt();
			state.setInt(1,ID);
			state.executeUpdate();
			System.out.println("Student with id: "+ID+" is Deleted");
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void removeAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsys","root","root");
			PreparedStatement state=con.prepareStatement("delete table student");
			state.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsys","root","root");
				PreparedStatement state=con.prepareStatement("update student set marks=? where id=?");
				System.out.println("Enter The ID of Student ");
				state.setInt(2, sc.nextInt());
				System.out.println("Enter Student Marks To Be Updated");
				int marks=sc.nextInt();
				state.setInt(1, marks);
				state.executeUpdate();
				con.close();
				System.out.println("Marks Updated successfully");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	@Override
	public void countStudent() {
		try {
			int count=0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsys","root","root");
			Statement state=con.createStatement();
			ResultSet set= state.executeQuery("select * from student");
			while(set.next())
			{
				count++;
			}
			System.out.println("Total No of Students are:-->"+count);
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void displayStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsys","root","root");
			PreparedStatement state=con.prepareStatement("select * from student where id=?");
			System.out.println("Enter Student ID ");
			int id=sc.nextInt();
			state.setInt(1, id);
			ResultSet set= state.executeQuery();
			while(set.next())
			{
				System.out.println("Student name is:: "+set.getString(1));
				System.out.println("Student age is:: "+set.getInt(2));
				System.out.println("Student id is:: "+set.getInt(3));
				System.out.println("Student marks are:: "+set.getInt(4));
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void displayAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsys","root","root");
			Statement state=con.createStatement();
			ResultSet set= state.executeQuery("select * from student");
			while(set.next())
			{
				System.out.println("Student name is:: "+set.getString(1));
				System.out.println("Student age is:: "+set.getInt(2));
				System.out.println("Student id is:: "+set.getInt(3));
				System.out.println("Student marks are:: "+set.getInt(4));
				System.out.println("***********-----------***************");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
