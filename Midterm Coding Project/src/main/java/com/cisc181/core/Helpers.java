package com.cisc181.core;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {
	public static boolean isValidPhone(String phoneNum) {
		String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNum);
		if (matcher.matches())
			return true;
		return false;
	}
	
	// Used in Staff Test for exception
	public static Date createCustDate(int year, int month, int day)
	{
		return new GregorianCalendar(year, month, day).getTime();
	}
}
