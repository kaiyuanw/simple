package edu.ut.ece;

import org.junit.Test;

public class UtilTest {
	@Test
    public void testDog() {
        Dog dog = ClassWithStaticMethods.buildDog();
        dog.say();
    }
	
	@Test
	public void testBird() {
		Bird bird = ClassWithStaticMethods.buildBird();
		bird.say();
	}
}
