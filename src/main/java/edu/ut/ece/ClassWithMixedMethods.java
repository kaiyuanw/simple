package edu.ut.ece;

public class ClassWithMixedMethods {
    
    private int one = 1;
    private static int two = 2;
    int three = 3;
    static int four = 4;
    
    private static int getOne() {
        return 1;
    }
    
    private int getTwo() {
        return 2;
    }
    
    int getThree() {
        return three;
    }
    
    static int getFour() {
        return four;
    }
}
