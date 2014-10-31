package com.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import thinkInjava.c04.Flower;

public class Tmain {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test####################################################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After  test####################################################################");
	}

	// @Test
	public void testFlower() {

		Flower x = new Flower();
		x.print();
	}

}
