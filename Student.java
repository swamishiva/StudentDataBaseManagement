package com.student;

public class Student {
private String name;
private int age;
private int id;
private int marks;
public Student(String name, int age, int id, int marks) {
	super();
	this.name = name;
	this.age = age;
	this.id = id;
	this.marks = marks;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
@Override
public String toString() {
	return "name: =" + name + ", age: =" + age + ", id: =" + id + ", marks: =" + marks;
}

}
