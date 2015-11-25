package edu.ut.ece;

public class Bird extends Animal implements Flyable {
    @Override
    public String say() {
        return "I'm a bird. " + canFly();
    }

    @Override
    public String canFly() {
        return "I can fly.";
    }
}
