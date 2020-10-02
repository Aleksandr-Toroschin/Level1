package ru.toroschin;

public class Lesson2 {
    public Lesson2() {
    }

    public static void main(String[] args) {
        int[] range = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printOneArray("Задание 1, начальный массив:", range);

        for(int i = 0; i < range.length; ++i) {
            if (range[i] == 0) {
                range[i] = 1;
            } else if (range[i] == 1) {
                range[i] = 0;
            }
        }

        printOneArray("Задание 1, результат:", range);
        int[] range2 = new int[8];

        for(int i = 0; i < 8; ++i) {
            range2[i] = i * 3;
        }

        printOneArray("Задание 2:", range2);
        int[] range3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printOneArray("Задание 3, начальный массив:", range3);

        for(int i = 0; i < range3.length; ++i) {
            if (range3[i] < 6) {
                range3[i] *= 2;
            }
        }

        printOneArray("Задание 3, результат:", range3);
        int size = 6;
        int[][] squareArray = new int[size][size];

        for(int i = 0; i < squareArray.length; ++i) {
            squareArray[i][i] = 1;
            squareArray[squareArray.length - i - 1][i] = 1;
        }

        printTwoArray("Задание 4:", squareArray);
        int[] range5 = new int[]{1, 6, 9, 3, 0, 23, 15, 4, 2};
        int minValue = range5[0];
        int maxValue = range5[0];
        printOneArray("Задание 5, массив:", range5);

        for(int i = 0; i < range5.length; ++i) {
            if (minValue > range5[i]) {
                minValue = range5[i];
            }

            if (maxValue < range5[i]) {
                maxValue = range5[i];
            }
        }

        System.out.println("Минимальный элемент = " + minValue + "; максимальный элемент = " + maxValue);
        int[] range6 = new int[]{21, 1, 1, 1, 1, 2, 1, 4, 14};
        printOneArray("Задание 6, массив:", range6);
        if (checkBalance(range6)) {
            System.out.println("Есть место равенства!");
        } else {
            System.out.println("Нет места равенства!");
        }

        int[] range7 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        printOneArray("Задание 7, начальный массив:", range7);
        displacementElements(range7, -5);
        printOneArray("Задание 7, результат:", range7);
    }

    private static boolean checkBalance(int[] arr) {
        boolean result = false;
        int sum = 0;

        int i;
        for(i = 0; i < arr.length; ++i) {
            sum += arr[i];
        }

        for(i = 0; i < arr.length; ++i) {
            int sum1 = 0;

            for(int j = 0; j <= i; ++j) {
                sum1 += arr[j];
            }

            int sum2 = sum - sum1;
            if (sum1 == sum2) {
                result = true;
                break;
            }
        }

        return result;
    }

    private static void displacementElements(int[] arr, int count) {
        byte direction;
        int stepCount;
        if (count < 0) {
            direction = 1;
            stepCount = count * -1;
        } else {
            direction = -1;
            stepCount = count;
        }

        for(int i = 1; i <= stepCount; ++i) {
            int element;
            int j;
            if (count < 0) {
                element = arr[0];

                for(j = 0; j < arr.length - 1; ++j) {
                    arr[j] = arr[j + direction];
                }

                arr[arr.length - 1] = element;
            } else {
                element = arr[arr.length - 1];

                for(j = arr.length - 1; j > 0; --j) {
                    arr[j] = arr[j + direction];
                }

                arr[0] = element;
            }
        }

    }

    private static void printOneArray(String heading, int[] arr) {
        System.out.println(heading);
        printOneDimArray(arr);
    }

    private static void printTwoArray(String heading, int[][] arr) {
        System.out.println(heading);
        printTwoDimArray(arr);
    }

    private static void printOneDimArray(int[] arr) {
        System.out.print(arr[0]);

        for(int i = 1; i < arr.length; ++i) {
            System.out.print(", " + arr[i]);
        }

        System.out.println();
    }

    private static void printTwoDimArray(int[][] arr) {
        int[][] var1 = arr;
        int var2 = arr.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            int[] ints = var1[var3];
            printOneDimArray(ints);
        }

    }
}