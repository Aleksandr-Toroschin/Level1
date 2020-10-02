package ru.toroschin;

import java.util.Scanner;

public class Lesson3_2 {
    private static Scanner scanner;
    private static char[] prompt;

    public Lesson3_2() {
    }

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру Угадай слово!");
        String[] words = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int range = 25;

        for(int i = 0; i < 15; ++i) {
            prompt[i] = '#';
        }

        String userSelect;
        for(boolean playAgain = true; playAgain; playAgain = userSelect.equals("1")) {
            String word = words[(int)(Math.random() * (double)(range + 1))];
            playGuessWords(word);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            userSelect = scanner.next();
        }

        System.out.println("Игра окончена.");
        scanner.close();
    }

    private static void playGuessWords(String word) {
        for(int i = 0; i < 1000000; ++i) {
            System.out.println("Введите слово:");
            if (scanner.hasNext()) {
                String inputWord = scanner.next();
                if (inputWord.equals(word)) {
                    System.out.println("Поздравляем! Вы угадали.");
                    break;
                }

                System.out.println("Неверно, попробуйте еще раз.");
                makePartWord(word, inputWord);
                if (checkEnableCollisions()) {
                    System.out.println("Совпадают некоторые буквы. Подсказка: " + new String(prompt));
                }
            }
        }

    }

    private static void makePartWord(String word, String inputWord) {
        int minLength = Math.min(word.length(), inputWord.length());

        for(int i = 0; i < minLength; ++i) {
            if (word.charAt(i) == inputWord.charAt(i)) {
                prompt[i] = word.charAt(i);
            }
        }

    }

    private static boolean checkEnableCollisions() {
        boolean enable = false;

        for(int i = 0; i < 15; ++i) {
            if (prompt[i] != '#') {
                enable = true;
                break;
            }
        }

        return enable;
    }

    static {
        scanner = new Scanner(System.in);
        prompt = new char[15];
    }
}