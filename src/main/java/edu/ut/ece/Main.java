package edu.ut.ece;

public class Main {
    public static void main(String[] args) {
        Animal bird = new Bird();
        bird.greeting();
        ClassWithStaticMethods.buildDog().greeting();
        ClassWithStaticMethods.buildBird().greeting();
    }

    public static void anotherMethod() {
        System.out.println("another method");
    }
}
