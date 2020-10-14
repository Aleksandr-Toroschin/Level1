package ru.toroschin;

public abstract class Animal {
    private String name;
    private final double limitOnRun;
    private final double limitOnJump;
    private final double limitOnSwim;

    public Animal(String name, double limitOnRun, double limitOnJump, double limitOnSwim) {
        this.name = name;
        this.limitOnRun = limitOnRun;
        this.limitOnJump = limitOnJump;
        this.limitOnSwim = limitOnSwim;
    }

    public String getName(){
        return name;
    }

    public void run(double length) {
        System.out.println("run: " + (length <= limitOnRun));

    }

    public void jump(double length) {
        System.out.println("jump: " + (length <= limitOnJump));
    }

    public void swim(double length) {
        System.out.println("swim: " + (length <= limitOnSwim));

    }

}
