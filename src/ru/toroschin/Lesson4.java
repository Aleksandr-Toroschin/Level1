package ru.toroschin;

import java.util.Scanner;

public class Lesson4 {
    private static char[][] map;
    private static final int SIZE = 3; // размер поля
    private static final int WIN_LENGTH = 3; // количество фишек в один ряд для победы

    private static final char DOT_X = 'X';
    private static final char DOT_0 = '0';
    private static final char DOT_EMPTY = '-';

    private static char dotHuman;
    private static char dotAi;

    public static void main(String[] args) {
        // 1. инициализировать поле
        initMap();
        // 1.1 Вывод поля
        printMap();
        // 2. Выбор игральной фишки. - ДОП К ДЗ
        inputDot();
        // в цикле
        for (int i = 0; i < (SIZE * SIZE + 1) / 2; i++) {
            // 3. Ход первого игрока.
            makeHumanStep();
            // 4. Вывод поля.
            printMap();
            // 5. Проверка победы.
            if (hasWin(dotHuman)) {
                System.out.println("Вы выиграли!");
                break;
            }
            // 6. Проверка на ничью.
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            // 7. Ход второго игрока (ИИ).
            makeAiStep();
            // 8. Вывод поля.
            printMap();
            // 9. Проверка победы.
            if (hasWin(dotAi)) {
                System.out.println("Выиграл компьютер!");
                break;
            }
            // 10. Проверка на ничью.
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void inputDot() {
        Scanner scanner = new Scanner(System.in);
        String dot;
        do {
            System.out.println("Какую фишку Вы вибираете: Х или 0?");
            dot = scanner.next();
        } while (!isDotValid(dot));
        dotHuman = dot.charAt(0);
        if (dotHuman == DOT_X) {
            dotAi = DOT_0;
        } else {
            dotAi = DOT_X;
        }
    }

    private static void makeHumanStep() {
        int x;
        int y;

        do {
            System.out.println("Введите координаты от 1 до " + SIZE + ", ячейка должна буть пустой:");
            x = getIntFormConsole() - 1;
            y = getIntFormConsole() - 1;
        } while (!isCellValid(x, y));

        map[y][x] = dotHuman;
    }

    private static boolean hasWin(char dot) {
        String winStr = "";
        for (int i = 0; i < WIN_LENGTH; i++) {
            winStr += dot;
        }
        return (foundLine(dot, winStr)[0].equals("1"));
    }

    private static String[] foundLine(char dot, String line) {
        String row;
        String col;
        String diagLeft1;
        String diagLeft2;
        String diagRight1;
        String diagRight2;

        // массив с резульататами поиска линии. Нужен для ИИ, по нему определяем линию, которую строит человек
        // индекс 0 - найдена или нет линия (0 - не найдена, 1 - найдена)
        // индекс 1 - вид линии (1 - строка, 2 - колонка, 3 - диагональ левая, 4 - диагональ правая)
        // индекс 2 - координата Y (по логике java, т.е. i)
        // индекс 3 - координата X (по логике java, т.е. j)
        // индекс 4 - найденная линия
        String[] foundLine = new String[5];
        for (int i = 0; i < 5; i++) {
            foundLine[i] = "0";
        }

        // проверка строк и столбцов
        for (int i = 0; i < map.length; i++) {
            row = "";
            col = "";
            for (int j = 0; j < map[i].length; j++) {
                row += map[i][j];
                col += map[j][i];
            }
            if (fillLine(foundLine, 1, row, line, i)) {
                return foundLine;
            }
            if (fillLine(foundLine, 2, col, line, i)) {
                return foundLine;
            }
        }
        // проверка всех диагоналей, не только главных
        for (int i = 0; i < map.length; i++) {
            diagLeft1 = "";
            diagLeft2 = "";
            diagRight1 = "";
            diagRight2 = "";
            for (int j = 0; j < map[i].length - i; j++) {
                diagLeft1 += map[i + j][j];
                diagLeft2 += map[j][i + j];
            }
            for (int j = 0; j <= i; j++) {
                diagRight1 += map[i - j][j];
                diagRight2 += map[map.length - 1 - j][map[i].length - 1 - i + j];
            }
            if (fillLine(foundLine, 3, diagLeft1, line, i)) {
                return foundLine;
            }
            if (fillLine(foundLine, 4, diagLeft2, line, i)) {
                return foundLine;
            }
            if (fillLine(foundLine, 5, diagRight1, line, i)) {
                return foundLine;
            }
            if (fillLine(foundLine, 6, diagRight2, line, i)) {
                return foundLine;
            }
        }
        return foundLine;
    }

    private static boolean fillLine(String[] lineArray, int option, String sourceLine, String searchLine, int i) {
        // option - вид проверяемой линии
        if (sourceLine.contains(searchLine)) {
            lineArray[0] = "1";
            lineArray[4] = sourceLine;
            switch (option) {
                case 1:
                    // строка
                    lineArray[1] = "1";
                    lineArray[2] = String.valueOf(i);
                    lineArray[3] = String.valueOf(0);
                    break;
                case 2:
                    // колонка
                    lineArray[1] = "2";
                    lineArray[2] = String.valueOf(0);
                    lineArray[3] = String.valueOf(i);
                    break;
                case 3:
                    // диагональ левая 1
                    lineArray[1] = "3";
                    lineArray[2] = String.valueOf(i);
                    lineArray[3] = String.valueOf(0);
                    break;
                case 4:
                    // диагональ левая 2
                    lineArray[1] = "3";
                    lineArray[2] = String.valueOf(0);
                    lineArray[3] = String.valueOf(i);
                    break;
                case 5:
                    // диагональ правая 1
                    lineArray[1] = "4";
                    lineArray[2] = String.valueOf(i);
                    lineArray[3] = String.valueOf(0);
                    break;
                case 6:
                    // диагональ правая 2
                    lineArray[1] = "4";
                    lineArray[2] = String.valueOf(map.length - 1);
                    lineArray[3] = String.valueOf(map[i].length - 1 - i);
                    break;
                default:
                    lineArray[1] = "0";
                    lineArray[2] = "0";
                    lineArray[3] = "0";
            }
            return true;
        }
        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void makeAiStep() {
        int x;
        int y;

        String[] receivedLine;
        // 1. проверка, нет ли победного хода
        receivedLine = findStep(dotAi);
        if (receivedLine[0].equals("1")) {
            x = getX(receivedLine);
            y = getY(receivedLine);
            System.out.println("Нашел победный ход!!!");
            if (!isCellValid(x, y)) {
                System.out.println("ошибка x " + (x + 1) + " y " + (y + 1));
            }
        } else {
            // 2. Блокируем ход противника
            receivedLine = findStep(dotHuman);
            if (receivedLine[0].equals("1")) {
                x = getX(receivedLine);
                y = getY(receivedLine);
                System.out.println("Блокирую Ваш план...");
                if (!isCellValid(x, y)) {
                    System.out.println("ошибка x " + (x + 1) + " y " + (y + 1));
                }
            } else {
                // 3. если блокировать нечего, ходим наугад
                do {
                    System.out.println("Хожу наугад))");
                    x = (int) (Math.random() * SIZE);
                    y = (int) (Math.random() * SIZE);
                } while (!isCellValid(x, y));
            }
        }
        System.out.println("Компьютер походил по координатам: " + (x + 1) + " " + (y + 1));
        map[y][x] = dotAi;
    }

    private static String[] findStep(char dot) {
        String testLine;
        String[] receivedLine = new String[5];
        receivedLine[0] = "0";

        for (int j = 0; j < WIN_LENGTH; j++) {
            // подготовка искомой линии, которую мог построить противник
            testLine = "";
            for (int k = 0; k < WIN_LENGTH; k++) {
                if (k == j) {
                    testLine += DOT_EMPTY;
                } else {
                    testLine += dot;
                }
            }

            receivedLine = foundLine(dot, testLine);
            if (receivedLine[0].equals("1")) {
                return receivedLine;
            }
        }
        return receivedLine;
    }

    private static int getX(String[] line) {
        int vid = Integer.parseInt(line[1]);

        switch (vid) {
            case 1:
                // если это строка
                return line[4].indexOf(DOT_EMPTY);
            case 2:
                // если это колонка
                return Integer.parseInt(line[3]);
            case 3:
            case 4:
                // если это правая диагональ
                // если это левая диагональ
                return Integer.parseInt(line[3]) + line[4].indexOf(DOT_EMPTY);
            default:
                return 0;
        }
    }

    private static int getY(String[] line) {
        int vid = Integer.parseInt(line[1]);

        switch (vid) {
            case 1:
                // если это строка
                return Integer.parseInt(line[2]);
            case 2:
                // если это колонка
                return line[4].indexOf(DOT_EMPTY);
            case 3:
                // если это левая диагональ
                return Integer.parseInt(line[2]) + line[4].indexOf(DOT_EMPTY);
            case 4:
                // если это правая диагональ
                return Integer.parseInt(line[2]) - line[4].indexOf(DOT_EMPTY);
            default:
                return 0;
        }
    }

    private static int getIntFormConsole() {
        Scanner scanner = new Scanner(System.in);
        do {
            if (!scanner.hasNextInt()) {
                System.out.println("Введите целое число:");
                scanner.nextLine();
            }
        } while (!scanner.hasNextInt());
        return scanner.nextInt();
    }

    private static boolean isCellValid(int x, int y) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            return map[y][x] == DOT_EMPTY;
        } else {
            return false;
        }
    }

    private static boolean isDotValid(String dot) {
        return (dot.length() == 1 && (dot.charAt(0) == DOT_X || dot.charAt(0) == DOT_0));
    }

}
