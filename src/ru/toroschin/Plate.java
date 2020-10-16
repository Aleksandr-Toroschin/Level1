package ru.toroschin;

public class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    public boolean isEnoughFood(int valueFood) {
        return (food>=valueFood);
    }

    public void decreaseFood(int valueFood) {
        // 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
        if (isEnoughFood(valueFood)) {
            food -= valueFood;
        }
    }

    public void printInfo() {
        System.out.println("В тарелке еды: "+food);
    }

    public void addFood(int valueFood) {
        food += valueFood;
    }
}
