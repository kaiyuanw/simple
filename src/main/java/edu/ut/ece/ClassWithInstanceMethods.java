package edu.ut.ece;

public class ClassWithInstanceMethods {
    
    private int four = 4;
    int five = 5;
    
    public int getOne() {
        return getTwo() - 1;
    }
    
    private int getTwo() {
        return 2;
    }
    
    private int getThree() {
        return 3;
    }
    
    private int getThree(int add) {
        if (add == 3)
            return add;
        return 3;
    }
    
    private int getThree(String msg) {
        return 3;
    }
    
    private int getThree(double d, float f, int i) {
        if (d + f - i == 3.0)
            return 3;
        return 3;
    }
    
    private int getFour() {
        return four;
    }
    
    int getFive() {
        return five;
    }
    
    public int getSix() {
        return getThree() + getThree("a") - getThree(1) + getThree(1.0d,1.0f,1);
    }
}
