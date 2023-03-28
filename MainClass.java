package com.student;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentManagementImpl stud=new StudentManagementImpl();
		System.out.println("----------Enter Your Choice-----------");
		while(true)
		{
			System.out.println("1: To add Student \n2: To Remove Student\n3: To Remove All Student");
			System.out.println("4: To Update Student\n5: To Count Student\n6: To Display Student");
			System.out.println("7: To DisplayAll Student\n8: To Exit");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:stud.addStudent();
			break;
			case 2:stud.removeStudent();
			break;
			case 3:stud.removeAllStudent();
			break;
			case 4:stud.updateStudent();
			break;
			case 5:stud.countStudent();
			break;
			case 6:stud.displayStudent();
			break;
			case 7:stud.displayAllStudent();
			break;
			case 8:System.exit(0);
			break;
			default :System.out.println("Invallid Choice");
			}
			System.out.println("****************");
		}
	}

}
