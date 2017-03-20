package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
private UUID SectionID;
private UUID StudentID;
private UUID EnrollmentId;
private double Grade;

private Enrollment() {
	
}

public Enrollment(UUID SectionID, UUID StudentID) {
	super();
	this.SectionID = SectionID;
	this.StudentID = StudentID;
	this.EnrollmentId = UUID.randomUUID();
			
}
public void setGrade(double Grade) {
	this.Grade=Grade;
}

public UUID getStudentID()
{
	return StudentID;
}

public UUID getSectionID()
{
	return SectionID;
}

public double getGrade()
{
	return Grade;
}
}
