package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.game;

public class game_Testing {
game ga=new game();
@Test
public void test_TrueQuestion_Creat1() {
	boolean res=ga.addtrue_question("are your play football", "true", 500);
	assertEquals(true,res);
}
//test the create  student function and compare  the result by send the data to function and check the student it this test should fail to insert and return -1 

@Test
public void test_TrueQuestion_Creat2() {
	boolean res=ga.addtrue_question("are your play football", "true", 500);
	assertEquals(false ,res);
}

}
