package com.cisc181.core;

import java.util.UUID;

public class Course {
private UUID CourseID;
private String CourseName;
private int GradePoints;

public Course()
{
}

public Course(String CourseName)
{
	this();
	this.CourseID=UUID.randomUUID();
	this.CourseName=CourseName;
	
}
public void setGradePoints(int GradePoints)
{
	this.GradePoints=GradePoints;
}

public UUID getCourseID()
{
	return CourseID;
}

}
