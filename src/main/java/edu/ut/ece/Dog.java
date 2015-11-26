package edu.ut.ece;

public class Dog extends Animal {

    @Override
    public String say() {
        return "I'm a dog.";
    }

    @Override
    public String canFly() {
        return "I cannot fly.";
    }
}
