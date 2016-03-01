package edu.ut.ece;

public class Bird extends Animal {
	static int staticField = 1;
	static String instanceField = "AA";
	
    @Override
    public String say() {
        return "I'm a bird. " + canFly();
    }

    @Override
    public String canFly() {
        return "I can fly.";
    }
}
