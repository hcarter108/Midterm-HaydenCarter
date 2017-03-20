package com.cisc181.core;

public class PersonException extends Exception {
private Person p;

public PersonException(Person p, String message)
{
	super(message);
	this.p=p;
			}
}
