package edu.ut.ece;

public class Main {
    public static void main(String[] args) {
        Animal bird = new Bird();
        bird.greeting();
        Util.buildDog().greeting();
        Util.buildBird().greeting();
    }

    public static void anotherMethod() {
        System.out.println("another method");
    }
}
