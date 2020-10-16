package ru.toroschin;

public class Lesson7 {
    public static void main(String[] args) {
        // 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
        Cat[] cat = new Cat[5];
        cat[0] = new Cat("Барсик", 5);
        cat[1] = new Cat("Васька", 15);
        cat[2] = new Cat("Муся", 6);
        cat[3] = new Cat("Аська", 3);
        cat[4] = new Cat("Черныш", 20);

        Plate plate = new Plate(25);

        plate.printInfo();

        // Все коты кушают
        for (int i=0; i<cat.length; i++) {
            cat[i].eat(plate);
            cat[i].printInfo();
        }
        plate.printInfo();

        // 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
        plate.addFood(18);
        plate.printInfo();

        for (int i=0; i<cat.length; i++) {
            cat[i].eat(plate);
            cat[i].printInfo();
        }

        plate.printInfo();
    }
}
