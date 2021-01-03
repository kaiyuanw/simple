package edu.ut.ece;

import org.junit.*;

public class BirdTest {

  @Test
  public void testSay() {
    new Bird().say();
  }

  @Test
  public void testCanFly() {
    new Bird().canFly();
  }
}
