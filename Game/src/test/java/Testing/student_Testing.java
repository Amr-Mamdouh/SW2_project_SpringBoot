package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Student;

public class student_Testing {
	Student s=new Student();
	//First test the create function
	//test the create  student function and compare  the result by send the data to function and check the student it this test should pass and return student id 
		@Test
		public void test_Student_Creat1() {
			int res=s.createstudent("amr", "amrfouad", "12345", 'm', "01020251677", 20);
			assertEquals(3001,res);
		}
		//test the create  student function and compare  the result by send the data to function and check the student it this test should fail to insert and return -1 

		@Test
		public void test_Student_Creat2() {
			int res=s.createstudent("amr", "amrfouad", "123456", 'm', "01020251677", 20);
			assertEquals(-1,res);
		}
	//second function Test login function
	// this test case should be pass i work to test the student  login function by send right user name and pass and check the student id 
	@Test
	public void test_Student_Login1() {
		Student s=new Student();
		assertEquals(12345, s.login("amr", "12345"));
	}
	// this test case should  be fail and pass i work to test the student  login function by send right user name and pass and check wrong student id 

	@Test
	public void test_Student_Login2() {
		Student s=new Student();
		assertEquals(-1, s.login("amr", "12345"));
	}
	// this test case should be pass i work to test the student  login function by send wrong user name and pass and check the student id 

	@Test
	public void test_Student_Login3() {
		Student s=new Student();
		assertEquals(-1, s.login("amr", "12567"));
	}

}
