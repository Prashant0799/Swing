package com.trainingbasket.bean;

public class Transcript {
	int id;
	int Roll_Number;
	double Course_ID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoll_Number() {
		return Roll_Number;
	}

	public void setRoll_Number(int roll_Number) {
		Roll_Number = roll_Number;
	}

	public double getCourse_ID() {
		return Course_ID;
	}

	public void setCourse_ID(double course_ID) {
		Course_ID = course_ID;
	}

	public char getGrade() {
		return Grade;
	}

	public void setGrade(char grade) {
		Grade = grade;
	}

	char Grade;

}