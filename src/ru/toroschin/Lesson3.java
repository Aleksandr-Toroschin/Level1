package ru.toroschin;

import java.util.Scanner;

public class Lesson3 {
    private static Scanner scanner;

    public Lesson3() {
    }

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру: Угадай число!");
        int range = 9;

        String userSelect;
        for(boolean playAgain = true; playAgain; playAgain = userSelect.equals("1")) {
            int number = (int)(Math.random() * (double)(range + 1));
            playLevel(range, number);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            userSelect = scanner.next();
        }

        System.out.println("Игра окончена.");
        scanner.close();
    }

    private static void playLevel(int range, int number) {
        System.out.println("Угадате число от 0 до " + range);
        System.out.println("Вам дается 3 попытки.");
        int i = 1;
        boolean victory = false;

        while(i < 4) {
            System.out.println("Попытка " + i + ": ");
            if (scanner.hasNextInt()) {
                int inputNumber = scanner.nextInt();
                if (inputNumber == number) {
                    System.out.println("Поздравляем! Вы угадали.");
                    victory = true;
                    break;
                }

                if (inputNumber < number) {
                    System.out.println("Загаданное число больше.");
                } else {
                    System.out.println("Загаданное число меньше.");
                }

                ++i;
            } else {
                System.out.println("Введенное значение не является числом. Введите число.");
                scanner.next();
            }
        }

        if (!victory) {
            System.out.println("К сожалению, все попытки закончились, Вы не угадали(((");
            System.out.println("Было загадано число " + number);
        }

    }

    static {
        scanner = new Scanner(System.in);
    }
}
