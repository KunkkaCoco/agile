package com.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JunitTest {
	private static Logger logger = LoggerFactory.getLogger(JunitTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

	// @Test
	public void testSublist() {

		logger.debug("-----test-----");
	}

	@Test
	public void testconsole() {

		System.console();
	}

}
