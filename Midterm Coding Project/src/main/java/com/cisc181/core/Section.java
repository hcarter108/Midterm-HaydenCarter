package com.cisc181.core;

import java.util.UUID;

public class Section {
private UUID CourseID;
private UUID SemesterID;
private UUID SectionID;
private int RoomID;

public Section()
{
	this.SectionID=UUID.randomUUID();
	
}
public void setCourseID(UUID id) {
this.CourseID=id;
}

public void setSectionID(UUID id){
	this.SectionID=id;
	
}

public void setSemesterID(UUID id){
	this.SemesterID=id;
	
}

public void setRoomID(int roomNum){
	this.RoomID=roomNum;
}

public UUID getSectionID()
{
	return SectionID;
}

}
