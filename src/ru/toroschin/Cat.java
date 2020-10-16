package ru.toroschin;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullness = false;
    }

    public void eat(Plate plate) {
        if (!fullness) {
            fullness = plate.isEnoughFood(appetite);
            plate.decreaseFood(appetite);
        }
    }

    public void printInfo() {
        if (fullness) {
            System.out.println("Кот "+name+" сытый!");
        } else {
            System.out.println("Кот "+name+" голодный.");
        }
    }

}
