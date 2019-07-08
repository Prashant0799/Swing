package com.trainingbasket.bean;

import java.sql.SQLException;

public class CourseDetails {
	int id;
	String Name;
	String Course_ID;
	String Course_Description;
	String Instructor_Name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCourse_ID() {
		return Course_ID;
	}

	public void setCourse_ID(String course_ID) {
		Course_ID = course_ID;
	}

	public String getCourse_Description() {
		return Course_Description;
	}

	public void setCourse_Description(String course_Description) {
		Course_Description = course_Description;
	}

	public String getInstructor_Name() {
		return Instructor_Name;
	}

	public void setInstructor_Name(String instructor_Name) {
		Instructor_Name = instructor_Name;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
		Day = day;
	}

	String Time;
	String Day;
}
