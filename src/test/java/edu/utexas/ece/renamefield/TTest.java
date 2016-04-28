package edu.utexas.ece.renamefield;

import org.junit.Test;

import edu.utexas.ece.renamefield.S;
import junit.framework.TestCase;

public class TTest extends TestCase {
	@Test
	public void test1() {
		new S().a();
	}
	
	@Test
	public void test2() {
		new S().m(new D());
	}
	
	@Test
	public void test3() {
		new D().xxS();
	}
	
	@Test
	public void test4() {
		new C();
	}
}
