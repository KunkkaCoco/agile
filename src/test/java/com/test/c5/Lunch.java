package com.test.c5;

import org.junit.Test;

public class Lunch {

	@Test
public void test() {
		// Can't do this! Private constructor:
		// ! Soup priv1 = new Soup();
		Soup priv2 = Soup.makeSoup();
		Sandwich f1 = new Sandwich();
		Soup.access().f();

	}
}

class Sandwich {
	void f() {
		System.out.println("f. lunch");
		new Lunch();
	}
}

class Soup {
	private Soup() {
		System.out.println("new soup");
	}

	// (1) Allow creation via static method:
	public static Soup makeSoup() {
		return new Soup();
	}

	// (2) Create a static object and
	// return a reference upon request.
	// (The "Singleton" pattern):
	private static Soup ps1 = new Soup();

	public static Soup access() {
		return ps1;
	}

	public void f() {
		System.out.println("Soup.f(). lunch");
	}
}
