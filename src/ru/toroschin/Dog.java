package ru.toroschin;

public class Dog extends Animal {

    public Dog(String name) {
        super(name, 500, 0.5, 10);
    }

    public Dog(String name, double limitOnRun, double limitOnJump, double limitOnSwim) {
        super(name, limitOnRun, limitOnJump, limitOnSwim);
    }
}
