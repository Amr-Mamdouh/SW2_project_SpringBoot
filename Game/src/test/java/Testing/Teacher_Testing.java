package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Teacher;
import Model.game;

public class Teacher_Testing {
Teacher t=new Teacher();
game g=new game();
//First test the create course function and check it pass 
	@Test
	public void TestCreate_Course1() {
		assertEquals(20001, t.createCourse("Computer Sciencse",100025));
	}
	//first test the create course function and check it fail
	@Test
	public void TestCreate_Course2() {
		assertEquals(-1, t.createCourse("Computer Sciencse",100025));
	}
	
	//Second test the create course function and check it pass 
		@Test
		public void TestCreate_Game1() {
			assertEquals(40001, g.creategame("Matlab", "any thing ",30, 100025, "truefalse"));
		}
		//Second test the create course function and check it fail
		@Test
		public void TestCreate_Game2() {
			assertEquals(-1,g.creategame("Matlab", "any thing ",30, 100025, "truefalse"));
		}
		
}
