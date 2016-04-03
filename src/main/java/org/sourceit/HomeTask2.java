package org.sourceit;
import java.util.Random;
import static java.lang.Math.*;

public class HomeTask2 {

    /**
     * Конвертирует десятичное число в бинарную форму
     *
     * @param number может быть только позитивным
     * @return бинарная форма числа
     */
    public static long decimalToBinary(int number) {
        long decimalNumber = 0,
                poryadok = 1;
        while (number > 0){
            decimalNumber += (number % 2) * poryadok;
            number /= 2;
            poryadok *= 10;
        }
        return decimalNumber;
    }

    /**
     * Конвертирует десятичное число в октальную форму
     *
     * @param number может быть только позитивным
     * @return октальная форма числа
     */
    public static long decimalToOctal(int number) {
        long decimalNumber = 0,
                poryadok = 1;
        while (number > 0){
            decimalNumber += (number % 8) * poryadok;
            number /= 8;
            poryadok *= 10;
        }
        return decimalNumber;
    }

    /**
     * Конвертирует десятичное число в хексовою форму
     *
     * @param number может быть только позитивным
     * @return хексовая форма числа
     */
    public static long decimalToHex(int number) {
        long decimalNumber = 0,
                poryadok = 1;
        while (number > 0){
            decimalNumber += (number % 16) * poryadok;
            number /= 16;
            poryadok *= 100;
        }
        return decimalNumber;
    }

    /**
     * Конвертирует бинарную форму в десятичное число
     *
     * @param binary бинарная форма, может быть только позитивным
     * @return десятичное число
     */
    public static int binaryToDecimal(long binary) {
        int decimalNumber = 0,
                poryadok = 1;
        while (binary > 0){
            decimalNumber += (binary % 10) * poryadok;
            binary /= 10;
            poryadok *= 2;
        }
        return decimalNumber;
    }

    /**
     * Конвертирует октальную форму в десятичное число
     *
     * @param octal октальная форма, может быть только позитивным
     * @return десятичное число
     */
    public static int octalToDecimal(long octal) {
        int decimalNumber = 0,
                poryadok = 1;
        while (octal > 0){
            decimalNumber += (octal % 10) * poryadok;
            octal /= 10;
            poryadok *= 8;
        }
        return decimalNumber;
    }

    /**
     * Конвертирует хексовую форму в десятичное число
     *
     * @param hex хексовая форма, может быть только позитивным
     * @return десятичное число
     */
    public static int hexToDecimal(long hex) {
        int decimalNumber = 0,
                poryadok = 1;
        while (hex > 0){
            decimalNumber += (hex % 100) * poryadok;
            hex /= 100;
            poryadok *= 16;
        }
        return decimalNumber;
    }

    /**
     * Генерируют двумерный массив, со случайными числами.
     *
     * @param rows
     * @param columns
     * @return двумерный массив
     */
    public static int[][] generateTwoDimensionArray(int rows, int columns) {
        int[][] twoDimensionArray = new int [rows] [columns];
        Random randNum = new Random();
        for(int i = 0; i < rows; i++)
            for(int j =0; j < columns; j++)
                twoDimensionArray[i][j] = randNum.nextInt(100);
        return twoDimensionArray;
    }

    /**
     * Определить и вывести на экран индекс строки с
     * наибольшим по модулю произведением элементов.
     * Если таких строк несколько, то вывести индекс
     * первой встретившейся из них.
     *
     * @param input двумерный массив
     * @return индекс строки
     */
    public static int findMaxProduct(int[][] input) {
        long maxProduct = 0l;
        int indexLine = 0;
        for (int i = 0; i < input.length; i++) {
            long maxProductLine = 1;
            for(int j = 0; j <  input[i].length; j++) {
                maxProductLine *= abs(input[i][j]);
            }
            if (maxProductLine > maxProduct) {
                maxProduct = maxProductLine;
                indexLine = i;
            }
//            System.out.printf("Рядок %2d добуток %20d max %20d\n", i, maxProductLine, maxProduct);
        }
        return indexLine;
    }

    /**
     * Выводит все простые числа из интервала от 2 до n.
     *
     * @param n
     * @return массив простых чисел.
     */
    public static int[] getSimple(int n) {
        int m = 0;
        for(int i =2; i <= n; i++ ){
            if (isSimple(i)) m++;
        }
        int[] simpleNumbers = new int[m];
        int j = 0;
        for(int i =2; i <= n; i++ ){
            if (isSimple(i)) {
                simpleNumbers[j] = i;
                j++;
            }
        }
        return simpleNumbers;
    }

    static boolean isSimple (int a) {
        int i = 2;
        boolean isSimple = true;
        while (i <= a / 2) {
            if (a % i == 0) isSimple = false;
            i++;
        }
        return isSimple;
    }
    // Рекурсивные методы. Реализовать их нужно с помощью рекурсии.

    /**
     * Вычисляет сумму чисел от 1 до n включительно.
     *
     * @param n предел
     * @return сумма
     */
    public static long sum(int n) {
        long sumN = n;
        sumN = n < 0 ? 0 : sumN + sum(n - 1);
        return sumN;

    }

//    public static long sum(int n) {
//        return (n * (n + 1)) / 2;
//
//    }

    /**
     * Метод вычисляет, результат умножения.
     *
     * @param first
     * @param second
     * @return
     */
    public static int product(int first, int second) {
        if (abs(second) > 1)
            return (second > 0 ? first : - first) + product(first, second > 0 ? --second : ++second);
        return second > 0 ? first : - first;
    }







//    public static void main (String args[]){
//        System.out.println("5 \u00B7 6 = " + product(5, 6) + "\nΣx, (x = 1, 10) = " + sum(10));
//
//        int SimpleNumbers [] = new int [30];
//        SimpleNumbers = getSimple (30);
//        System.out.print("SimpleNumbers :");
//        for (int i = 0; i < SimpleNumbers.length; i++ ) {
//            if (SimpleNumbers[i] != 0) System.out.print(SimpleNumbers[i] + "  ");
//        }
//        System.out.println();
//
//        System.out.println("GenerateTwoDimensionArray :");
//        int m =10, n = 10;
//        int twoDimensionArray [][] = new int [m][n];
//        twoDimensionArray = generateTwoDimensionArray(m, n);
//        for (int i = 0; i < m; i++ ) {
//            for (int j = 0; j < n; j++) {
//
//                System.out.printf("%12d  ", twoDimensionArray[i][j]);
//            }
//
//            System.out.println();
//        }
//
//        int[][] array = {
//                {1, 2, 3, 4},
//                {1, 3, 6, 7},
//                {5, 6, 7, 9},
//                {10, 5, 3, 4}
//
//        };
//        System.out.println("Index max\u03A0 = " + findMaxProduct (array));
//        System.out.println("Index max\u03A0 = " + findMaxProduct (twoDimensionArray));
//        System.out.println("119(10) = " + decimalToBinary(119) + "(2)");
//        System.out.println("119(10) = " + decimalToOctal(119) + "(8)");
//        System.out.println("65535(10) = " + decimalToHex(65535) + "(16)");
//        System.out.println("100(10) = " + decimalToHex(100) + "(16)");
//        System.out.println(decimalToBinary(119) + "(2) = " + binaryToDecimal(decimalToBinary(119)) + "(10)");
//        System.out.println(decimalToOctal(119) + "(8) = " + octalToDecimal(decimalToOctal(119)) + "(10)");
//        System.out.println(decimalToHex(65535) + "(16) = " + hexToDecimal(decimalToHex(65535)) + "(10)");
//        for (int i = 0; i <= 0x0FFF; i++) {
//            System.out.printf("%d(10) = %d(16)\n", i, decimalToHex(i));
//    System.out.println(product(2, 4));
//    System.out.println(product(-2, 4));
//    System.out.println(product(-2, -4));
//    System.out.println(product(2, -4));
//
//        }
//    }

}

