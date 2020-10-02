package ru.toroschin;

public class Lesson1 {
    public static void main(String[] args) {

        // п.2 Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte myByte = 1;
        short myShort = 5000;
        int myInt = 35600;
        long myLong = 30000;
        float myFloat = (float) 5.0565;
        double myDouble = 0.11221;
        char myChar = 'a';
        boolean myBoolean = true;

        // п.3 Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
        System.out.println("Пункт 3. a * (b + (c / d))=" + calcExpression(6.7, 4, 32,8.2));

        // п4 Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
        // если да – вернуть true, в противном случае – false;
        System.out.println("Пункт 4. сумма от 10 до 20: " + checkSumInInterval(0, 20));

        // п.5 Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
        // в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
        checkPlusOrMinus(-2);

        // п.6 Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
        System.out.println("Пункт 6. Поиск отрицательного: " + checkMinus(-1));

        // п.7 Написать метод, которому в качестве параметра передается строка, обозначающая имя,
        // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        printHello("Петр");

        // п.8 Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        checkYear(596);

    }

    private static double calcExpression(double a, double b, double c, double d) {
        return a*(b+(c/d));
    }

    private static boolean checkSumInInterval(int a, int b) {
        return (a+b)<=20 && (a+b)>=10;
    }

    private static void checkPlusOrMinus(int number) {
        if (number>=0) {
            System.out.println("Пункт 5. Проверка знака числа: положительное");
        } else {
            System.out.println("Пункт 5. Проверка знака числа: отрицательное");
        }
    }

    private static boolean checkMinus(int number) {
        return number<0;
    }

    private static void printHello(String name) {
        System.out.println("Привет, "+name+"!");
    }

    private static void checkYear(int year) {
        int t1 = year%4;
        int t2 = year%100;
        int t3 = year%400;
        if ((t1 == 0) && (t2 != 0) && (t3 != 0) || (t1==0 && t2==0 && t3==0)) {
            System.out.println("Пункт 8. Проверка года "+year+": является високосным");
        } else {
            System.out.println("Пункт 8. Проверка года "+year+": НЕ является високосным");
        }
    }
}
