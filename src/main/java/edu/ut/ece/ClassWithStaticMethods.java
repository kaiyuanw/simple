package edu.ut.ece;

public class ClassWithStaticMethods {
	public static Dog buildDog() {
		return new Dog();
	}
	
	public static Bird buildBird() {
		return new Bird();
	}
	
	public static int getOne() {
	    return 1;
	}
	
	private static int getTwo() {
	    return getOne() + getOne();
	}
	
	private static int getThree() {
	    return getTwo() + getOne();
	}
}
