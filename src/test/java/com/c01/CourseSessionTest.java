package com.c01;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.c01.CourseSession;
import com.c01.Student;


public class CourseSessionTest {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

	@Test
	public void test(){
		CourseSession session = new CourseSession("ENGL","101");
		assertEquals("ENGL",session.getDepartment());
		assertEquals("101",session.getNumber());
		assertEquals(0,session.getNumberOfStudent());
	}
	@Test
	public void testEnrollStudens(){
		CourseSession session = new CourseSession("ENGL","101");
		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(1,session.getNumberOfStudent());
		List<Student> allStudents = session.getAllStudents();
		assertEquals(1,allStudents.size());
		assertEquals(student1,allStudents.get(0));



		Student student2 = new Student("Cpralee DeVaughn");
		session.enroll(student2);
		assertEquals(2,session.getNumberOfStudent());
		assertEquals(2,allStudents.size());
		assertEquals(student2,allStudents.get(1));
	}


}
