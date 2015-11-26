package edu.ut.ece;

public class Bird extends Animal {
    @Override
    public String say() {
        return "I'm a bird. " + canFly();
    }

    @Override
    public String canFly() {
        return "I can fly.";
    }
}
