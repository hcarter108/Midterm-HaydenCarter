package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	
	private static ArrayList<Staff> arrayS = new ArrayList<Staff>();

	@BeforeClass
	public static void setup() throws PersonException 
	{
		arrayS.add(new Staff("John", "J", "James", new Date(), "1 Street", "3027272727", "j@udel.edu", "blah", 2, 1.0,
				new Date(), eTitle.MR));
		arrayS.add(new Staff("Joe", "J", "James", new Date(), "1 Street", "3027272727", "j@udel.edu", "blah", 2, 2.0,
				new Date(), eTitle.MR));
		arrayS.add(new Staff("Jesus", "J", "James", new Date(), "1 Street", "3027272727", "j@udel.edu", "blah", 2, 3.0,
				new Date(), eTitle.MR));
		arrayS.add(new Staff("Jordan", "J", "James", new Date(), "1 Street", "3027272727", "j@udel.edu", "blah", 2, 4.0,
				new Date(), eTitle.MR));
		arrayS.add(new Staff("Juan", "J", "James", new Date(), "1 Street", "3027272727", "j@udel.edu", "blah", 2, 5.0,
				new Date(), eTitle.MR));
	}

	@AfterClass
	public static void teardown()
	{
		arrayS=null;
	}
	@Test
	public void test() {
		assertEquals(1, 1);
	}

	// required a delta to pass, .00000001, since double I suppose
	@Test
	public void testSalary() throws PersonException {
		double count = 0;
		for (Staff s : arrayS) {
			count += s.getSalary();
		}
		double average = count / 5;
		assertEquals(average, 3.0, .00000001);
	}

	@Test(expected = PersonException.class)
	public void staffInvPhone() throws PersonException {
		new Staff("John", "J", "James", new Date(), "1 Street", "1111", "j@udel.edu", "blah", 2, 1.0,
				new Date(), eTitle.MR);
	}

	@Test(expected = PersonException.class)
	public void staffInvDOB() throws PersonException {
		new Staff("John", "J", "James", Helpers.createCustDate(1800,1,1), "1 Street", "3027272727", "j@udel.edu", "blah", 2, 1.0,
				new Date(), eTitle.MR);
	}
}
