package edu.ut.ece;

public abstract class Animal {
    String name;
    int age;
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public void greeting() { System.out.println(say()); }
    public abstract String say();
}
