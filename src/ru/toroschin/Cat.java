package ru.toroschin;

public class Cat extends Animal {

    public Cat(String name) {
        super(name, 200, 2, 0);
    }

    public Cat(String name, double limitOnRun, double limitOnJump, double limitOnSwim) {
        super(name, limitOnRun, limitOnJump, limitOnSwim);
    }

    @Override
    public void swim(double length) {
        System.out.println("Кот не умеет плавать!");
    }

}
