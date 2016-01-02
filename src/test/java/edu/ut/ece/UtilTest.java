package edu.ut.ece;

import org.junit.Test;

public class UtilTest {
	@Test
    public void testDog() {
        Dog dog = Util.buildDog();
        dog.say();
    }
	
	@Test
	public void testBird() {
		Bird bird = Util.buildBird();
		bird.say();
	}
}
