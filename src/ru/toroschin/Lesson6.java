package ru.toroschin;

public class Lesson6 {
    public static void main(String[] args) {
        // создаем животных
        Animal cat1 = new Cat("Барсик");
        Animal cat2 = new Cat("Тишка", 300, 1.5, 0);
        Animal dog1 = new Dog("Дик");
        Animal dog2 = new Dog("Тузик", 400, 0.5, 13);
        Animal dog3 = new Dog("Бобик", 600, 0.2, 8);

        Animal[] animals = {cat1, cat2, dog1, dog2, dog3};

        // даем команды
        for (int i=0; i<animals.length; i++) {
            System.out.println("Даем команду: " + animals[i].getName() + " \"бежать 400м\"");
            animals[i].run(400);
            System.out.println("Даем команду: " + animals[i].getName() + " \"прыгнуть 1м\"");
            animals[i].jump(1);
            System.out.println("Даем команду: " + animals[i].getName() + " \"плыть 9м\"");
            animals[i].swim(9);
        }
    }
}
