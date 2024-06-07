package com.test;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class NumericalFunctions {
    public static void main(String[] args) throws IOException {

        // Считывание чисел из файла
        BufferedReader reader = new BufferedReader(new FileReader("input10.txt"));
        ArrayList<Long> numsArray = new ArrayList<>();
        String[] stringNumsArray = reader.readLine().split(" ");

        // Обработка чисел из файла (перевод в числовое значение)
        for (int i = 0; i < stringNumsArray.length; i++) {
            numsArray.add(Long.parseLong(stringNumsArray[i]));
        }

        // Вызов функций
        long min = min(numsArray);
        long max = max(numsArray);
        long sum = sum(numsArray);
        long mult = mult(numsArray);

        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);
        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + mult);

    }

    public static long min(ArrayList<Long> numsArray) {
        long min = Long.MAX_VALUE;
        for (long num : numsArray) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static long max(ArrayList<Long> numsArray) {
        long max = Integer.MIN_VALUE;
        for (long num : numsArray) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static long sum(ArrayList<Long> numsArray) {
        BigInteger sum = BigInteger.ZERO;
        for (long num : numsArray) {
            BigInteger numBigInt = BigInteger.valueOf(num);
            sum = sum.add(numBigInt);

            // Проверка на переполнение
            if (sum.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0 || sum.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0) {
                throw new ArithmeticException("Переполнение типа long");
            }
        }
        return sum.longValue();
    }

    public static long mult(ArrayList<Long> numsArray) {
        BigInteger result = BigInteger.ONE;
        for (long num : numsArray) {
            BigInteger numBigInt = BigInteger.valueOf(num);
            result = result.multiply(numBigInt);

            // Проверка на переполнение
            if (result.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0 || result.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0) {
                throw new ArithmeticException("Переполнение типа long");
            }
        }
        return result.longValue();
    }
}