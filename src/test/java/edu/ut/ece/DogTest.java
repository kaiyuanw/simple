package edu.ut.ece;

import static org.junit.Assert.fail;

import org.junit.*;

public class DogTest {

  @Test
  public void testSay() {
    new Dog().say();
  }

  @Test
  public void testCanFly() {
    new Dog().canFly();
  }

  @Test
  public void testCanFlyFailed() {
    new Dog().canFly();
    fail();
  }
}
