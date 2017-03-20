package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	// For the Course average, I'm assuming Section 1,2 are Course 1, then 3,4
	// are Course 2,  and 5,6 are Course 3. I didn't see a particular way specified. 
	private static ArrayList<Course> arrayCour = new ArrayList<Course>();
	private static ArrayList<Semester> arraySem = new ArrayList<Semester>();
	private static ArrayList<Section> arraySec = new ArrayList<Section>();
	private static ArrayList<Student> arrayStu = new ArrayList<Student>();
	private static ArrayList<Enrollment> arrayEnr = new ArrayList<Enrollment>();
	private static ArrayList<Double> arrayGPAstu = new ArrayList<Double>();
	private static ArrayList<Double> arraycAVG = new ArrayList<Double>(3);

	@BeforeClass
	public static void setup() throws PersonException {
		// not sure if necessary, but the attribute exists
		String[] courseTitles = {"PHYS424", "PHYS310", "CISC320"};
		for (int i = 0; i < 3; i++) {
			arrayCour.add(new Course(courseTitles[i]));
		}
		for (int i = 0; i < 2; i++) {
			arraySem.add(new Semester());
		}
		for (int i = 0; i < 6; i++) {
			arraySec.add(new Section());
		}
		
		// Associate course and semester with each section, unsure if necessary
		int j=0;
		for (Section s : arraySec)
		{
			s.setCourseID(arrayCour.get((int)Math.floor(j/2)).getCourseID());
			s.setSemesterID(arraySem.get((int)j++%2).getSemesterID());
		}

		for (int i = 0; i < 10; i++) {
			arrayStu.add(
					new Student("A", "B", "C", new Date(), eMajor.PHYSICS, "1st Street", "3022222222", "ABC@udel.edu"));
		}

		for (Student st : arrayStu) {
			for (Section sc : arraySec) {
				Enrollment e = new Enrollment(sc.getSectionID(), st.getStudentID());
				e.setGrade(3.0);
				arrayEnr.add(e);
			}
		}

		// initialized with zeros, else set method fails
		for (int i = 0; i < 10; i++)
			arrayGPAstu.add(0.0);

		for (int i = 0; i < 60; i++) {
			if (arrayEnr.get(i).getStudentID() == arrayStu.get(0).getStudentID())
				arrayGPAstu.set(0, arrayGPAstu.get(0) + arrayEnr.get(i).getGrade());

			else if (arrayEnr.get(i).getStudentID() == arrayStu.get(1).getStudentID())
				arrayGPAstu.set(1, arrayGPAstu.get(1) + arrayEnr.get(i).getGrade());

			else if (arrayEnr.get(i).getStudentID() == arrayStu.get(2).getStudentID())
				arrayGPAstu.set(2, arrayGPAstu.get(2) + arrayEnr.get(i).getGrade());

			else if (arrayEnr.get(i).getStudentID() == arrayStu.get(3).getStudentID())
				arrayGPAstu.set(3, arrayGPAstu.get(3) + arrayEnr.get(i).getGrade());

			else if (arrayEnr.get(i).getStudentID() == arrayStu.get(4).getStudentID())
				arrayGPAstu.set(4, arrayGPAstu.get(4) + arrayEnr.get(i).getGrade());

			else if (arrayEnr.get(i).getStudentID() == arrayStu.get(5).getStudentID())
				arrayGPAstu.set(5, arrayGPAstu.get(5) + arrayEnr.get(i).getGrade());

			else if (arrayEnr.get(i).getStudentID() == arrayStu.get(6).getStudentID())
				arrayGPAstu.set(6, arrayGPAstu.get(6) + arrayEnr.get(i).getGrade());

			else if (arrayEnr.get(i).getStudentID() == arrayStu.get(7).getStudentID())
				arrayGPAstu.set(7, arrayGPAstu.get(7) + arrayEnr.get(i).getGrade());

			else if (arrayEnr.get(i).getStudentID() == arrayStu.get(8).getStudentID())
				arrayGPAstu.set(8, arrayGPAstu.get(8) + arrayEnr.get(i).getGrade());

			else
				arrayGPAstu.set(9, arrayGPAstu.get(9) + arrayEnr.get(i).getGrade());

		}

		// An easier workaround then SetGrade in the Course class, and the sequence matches so the courses are correct, every other 2
		for (int i = 0; i < 3; i++)
			arraycAVG.add(0.0);

		for (int i = 0; i < 60; i++) {
			if (arrayEnr.get(i).getSectionID() == arraySec.get(0).getSectionID()
					|| arrayEnr.get(i).getSectionID() == arraySec.get(1).getSectionID())
				arraycAVG.set(0, arraycAVG.get(0) + arrayEnr.get(i).getGrade());

			else if (arrayEnr.get(i).getSectionID() == arraySec.get(2).getSectionID()
					|| arrayEnr.get(i).getSectionID() == arraySec.get(3).getSectionID())
				arraycAVG.set(1, arraycAVG.get(1) + arrayEnr.get(i).getGrade());
			else
				arraycAVG.set(2, arraycAVG.get(2) + arrayEnr.get(i).getGrade());
		}
	}
	
	@AfterClass
	public static void teardown()
	{
		arrayCour=null;
		arraySem=null;
		arraySec=null;
		arrayStu=null;
		arrayEnr=null;
		arrayGPAstu=null;
		arraycAVG=null;
	}

	@Test
	public void test() {
		assertEquals(1, 1);
	}

	@Test
	public void TestEnrollment() throws PersonException {
		assertEquals(arrayEnr.size(), 60);

	}
// Paremeter 3 is delta, same below
	@Test
	public void TestGPA() {
		for (int i = 0; i < 10; i++) {
			double GPA = arrayGPAstu.get(i) / 6;
			assertEquals(GPA, 3.0, .00001);
		}
	}

	@Test
	public void TestCourseAVG() {
		for (int i = 0; i < 3; i++) {
			double cAvg = arraycAVG.get(i) / 20;
			assertEquals(cAvg, 3, .00001);
		}
	}
	
	@Test
	public void TestMajorChange()
	{
		assertEquals(arrayStu.get(0).getMajor(), eMajor.PHYSICS);
		arrayStu.get(0).setMajor(eMajor.CHEM);
		assertEquals(arrayStu.get(0).getMajor(), eMajor.CHEM);
		
	}
	

}