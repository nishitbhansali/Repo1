package com.nishit;

public class Student {

	String name;
	int rollNo;
	public Student(String name,int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
	
	public String toString() {
		
		return name + "....." + rollNo;
	}
	public static void main(String[] args) {
		Student s1 = new Student("Durga",101);
		Student s2 = new Student("Ravi",102);
		System.out.println(s1);
		System.out.println(s1.toString());
		System.out.println(s2);

	}

}
